package com.example.lv3;

import java.util.List;
import java.util.Scanner;

//메뉴 관리 및 사용자 입력 처리
public class Kiosk {

    //List 선언 및 초기화
    private final List<MenuItem> menuItems;

    //생성자를 통해 리스트의 값 할당
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //메뉴 입력 및 반복문
    public void start() {
        //Scanner 선언
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //리스트 안에 있는 MenuItem 하나씩 출력
            System.out.print("[ McDonald's MENU ]\n");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(i + 1 + ". " + menuItems.get(i));
            }
            System.out.println("0. 종료 | 종료");

            //숫자 입력 받기. 코드 반복을 줄이기 위해 if else로 수정
            System.out.print("메뉴의 숫자를 입력해주세요: ");
            try {
                int selectMenu = scanner.nextInt();
                if (selectMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (selectMenu > 0 && selectMenu <= menuItems.size()) {
                    System.out.println("\n선택한 메뉴: " + menuItems.get(selectMenu - 1));
                } else {
                    System.out.println("\n잘못된 선택입니다. 다시 입력해 주세요.");
                }
            } catch (Exception e) {
                System.out.println("\n유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
                scanner.next();
            }
            System.out.println();
        }
    }
}
