package com.app.randomdrawingbe.dto;

import com.app.randomdrawingbe.enums.RandomDrawingTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RandomDrawingRequestDto {

    private List<String> items;
    private Integer drawCount;
    private RandomDrawingTypeEnum type;
}
