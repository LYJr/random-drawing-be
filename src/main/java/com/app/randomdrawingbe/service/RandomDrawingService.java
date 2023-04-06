package com.app.randomdrawingbe.service;

import com.app.randomdrawingbe.dto.RandomDrawingRequestDto;
import com.app.randomdrawingbe.dto.RandomDrawingResponseDto;
import com.app.randomdrawingbe.enums.CommonStateEnum;
import com.app.randomdrawingbe.enums.RandomDrawingTypeEnum;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class RandomDrawingService {

    private static final SecureRandom random = new SecureRandom();

    public RandomDrawingResponseDto draw(RandomDrawingRequestDto requestDto) {
        RandomDrawingResponseDto responseDto = new RandomDrawingResponseDto();
        List<String> items = requestDto.getItems();

        try {
            responseDto.resultDefaultSetting(CommonStateEnum.OK);

            if(RandomDrawingTypeEnum.MULTI == requestDto.getType()) {
                return responseDto.resultWinner(multipleDraw(requestDto));
            }

            return responseDto.resultWinner(singleDraw(requestDto.getItems()));
        } catch (Exception e) {
            responseDto.resultDefaultSetting(CommonStateEnum.FAILURE);
            return responseDto;
        }
    }

    // 단일 추첨
    private String singleDraw(List<String> items) {
        return items.get(random.nextInt(items.size()));
    }

    // 여러명 추첨
    private List<String> multipleDraw(RandomDrawingRequestDto requestDto) {
        List<String> items = requestDto.getItems();
        List<String> resultWinners = new ArrayList<>();
        for (int i = 0; i < requestDto.getDrawCount()-1; i++) {
            int winnerIndex = random.nextInt(items.size());
            resultWinners.add(items.get(winnerIndex));
            items.remove(winnerIndex);
        }

        return resultWinners;
    }
}
