package com.app.randomdrawingbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RandomDrawingResponseDto {

    private Object result;
    private String massage;
    private String statusCode;

    // TODO: 2023/03/27 구현중.
    public void resultDefaultSetting() {

    }

    public RandomDrawingResponseDto resultWinner(Object multipleDraw) {
        return this;
    }
}
