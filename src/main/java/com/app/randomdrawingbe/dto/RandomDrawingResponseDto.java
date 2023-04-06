package com.app.randomdrawingbe.dto;

import com.app.randomdrawingbe.enums.CommonStateEnum;
import com.app.randomdrawingbe.enums.RandomDrawingTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RandomDrawingResponseDto {

    private Object result;
    private CommonStateEnum statusCode;

    public void resultDefaultSetting(CommonStateEnum statusCode) {
        this.statusCode = statusCode;
    }

    public RandomDrawingResponseDto resultWinner(Object items) {
        this.result = items;
        return this;
    }
}
