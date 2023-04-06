package com.app.randomdrawingbe.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

class RandomDrawingServiceTest {

    private static final SecureRandom random = new SecureRandom();

    private List<String> name = new ArrayList<>();

//    @Before
    public void 인원추가() {
        name.add("예지");
        name.add("석우");
        name.add("시현");
        name.add("진");
        name.add("윤성");
        name.add("율");
        name.add("인웅");
        name.add("세웅");
    }

    @Test
    public void 뽑기() {
        인원추가();

        List<String> 수요일_발표자 = new ArrayList<>();
        String 수요일_수기자 = "";

        List<String> 목요일_발표자 = new ArrayList<>();
        String 목요일_수기자 = "";

        List<String> 임시_대기자 = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if(i < 2) {
                int 뽑힌사람 = random.nextInt(name.size());
                수요일_발표자.add (name.get(뽑힌사람));
                임시_대기자.add(name.get(뽑힌사람));

                name.remove(뽑힌사람);

            }

            if(i == 2) {
                수요일_수기자 = name.get(random.nextInt(name.size()));
            }

            if(i > 2 && i != 5 ) {
                int 뽑힌사람 = random.nextInt(name.size());
                목요일_발표자.add(name.get(뽑힌사람));
                name.remove(뽑힌사람);
            }

            if(i == 5) {
                for (String s : 임시_대기자) {
                    name.add(s);
                }
                목요일_수기자 = name.get(random.nextInt(name.size()));
            }
        }

        System.out.println("수요일 발표자 : " + 수요일_발표자);
        System.out.println("수 - 수기자 : " + 수요일_수기자);
        System.out.println("목요일 발표자 : " + 목요일_발표자);
        System.out.println("목 - 발표자 : " + 목요일_수기자);
    }

}