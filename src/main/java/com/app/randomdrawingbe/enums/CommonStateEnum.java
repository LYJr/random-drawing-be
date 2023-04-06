package com.app.randomdrawingbe.enums;

public enum CommonStateEnum {
    OK(200, "응답에 성공하였습니다"),
    FAILURE(402, "실패했습니다");


    CommonStateEnum(int codeNumber, String message) {

    }
}
