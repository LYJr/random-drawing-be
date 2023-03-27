package com.app.randomdrawingbe.service;

import com.app.randomdrawingbe.dto.RandomDrawingRequestDto;
import com.app.randomdrawingbe.dto.RandomDrawingResponseDto;
import com.app.randomdrawingbe.enums.RandomDrawingTypeEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomDrawingService {

    //어우 나 씹멍청이;;
    private static final Random random = new Random();

    public RandomDrawingResponseDto draw(RandomDrawingRequestDto requestDto) {
        RandomDrawingResponseDto responseDto = new RandomDrawingResponseDto();
        List<String> items = requestDto.getItems();

        responseDto.resultDefaultSetting();

        if(RandomDrawingTypeEnum.PLURAL.name().equals(requestDto.getType())) {
            return responseDto.resultWinner(multipleDraw(items, requestDto.getDrawCount()));
        }

        return responseDto.resultWinner(singleDraw(items));
    }

    // 단일 추첨
    private String singleDraw(List<String> items) {
        return items.get(random.nextInt(items.size()));
    }

    // 여러명 추첨
    private List<String> multipleDraw(List<String> items, int drawCount) {
        List<String> resultWinners = new ArrayList<>();
        for (int i = 0; i < drawCount-1; i++) {
            int winnerIndex = random.nextInt(items.size());
            resultWinners.add(items.get(winnerIndex));
            items.remove(winnerIndex);
        }

        return resultWinners;
    }
}
