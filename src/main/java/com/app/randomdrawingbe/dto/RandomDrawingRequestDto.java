package com.app.randomdrawingbe.dto;

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
    private String type;
}
