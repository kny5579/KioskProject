package com.example.kiosk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();
        //add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuItems.add(new MenuItem("빅맥", 0.6, "쇠고기 패티 두장, 소스, 치즈, 야채가 어우러진 버거"));
        menuItems.add(new MenuItem("쿼터파운더치즈", 0.7, "쇠고기 패티, 두꺼운 치즈, 야채, 머스타드가 들어간 버거"));
        menuItems.add(new MenuItem("슈슈버거", 0.65, "통새우살 가득한 버거"));
        menuItems.add(new MenuItem("불고기버거", 0.5, "불고기 소스와 쇠고기 패티가 어우러진 버거"));

        //Scanner 선언
        Scanner scanner = new Scanner(System.in);
        //반복문 탈출 flag 선언
        boolean exit = false;

        while (!exit) {
            //리스트 안에 있는 MenuItem 하나씩 출력
            System.out.print("[ McDonald's MENU ]\n");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(i + 1 + ". " + menuItems.get(i));
            }
            System.out.println("0. 종료 | 종료");

            //숫자 입력 받기. 코드 반복을 줄이기 위해 if else로 수정
            System.out.print("메뉴의 숫자를 입력해주세요: ");
            System.out.println();
            try {
                int selectMenu = scanner.nextInt();
                if (selectMenu == 0) {
                    exit = true;
                    System.out.println("프로그램을 종료합니다.");
                } else if (selectMenu > 0 && selectMenu <= menuItems.size()) {
                    System.out.println("선택한 메뉴: " + menuItems.get(selectMenu - 1));
                } else {
                    System.out.println("잘못된 선택입니다. 다시 입력해 주세요.");
                }
            } catch (Exception e) {
                System.out.println("유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
                scanner.next();
            }
            System.out.println();
        }

    }
}
