package com.example.kiosk3;

import com.example.kiosk2.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk(Arrays.asList(
                new MenuItem("빅맥", 0.6, "쇠고기 패티 두장, 소스, 치즈, 야채가 어우러진 버거"),
                new MenuItem("쿼터파운더치즈", 0.7, "쇠고기 패티, 두꺼운 치즈, 야채, 머스타드가 들어간 버거"),
                new MenuItem("슈슈버거", 0.65, "통새우살 가득한 버거"),
                new MenuItem("불고기버거", 0.5, "불고기 소스와 쇠고기 패티가 어우러진 버거")));

        kiosk.start();

    }
}
