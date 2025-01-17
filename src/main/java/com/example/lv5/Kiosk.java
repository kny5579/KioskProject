package com.example.lv5;

import java.util.List;
import java.util.Scanner;

//메뉴 관리 및 사용자 입력 처리
public class Kiosk {

    private final List<Menu> menuList;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }


    //메뉴 입력 및 반복문
    public void start() {
        //Scanner 선언
        Scanner scanner = new Scanner(System.in);
        //반복문 탈출 flag 선언
        boolean exit = false;

        while (!exit) {
            System.out.println("[ MAIN MENU ]");
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println(i + 1 + ". " + menuList.get(i).getCategoryName());
            }
            System.out.println("0. 종료 | 종료");

            //메뉴 숫자 입력 받기. 코드 반복을 줄이기 위해 if else로 수정
            System.out.print("메뉴의 숫자를 입력해주세요: ");
            try {
                int selectMenuNum = scanner.nextInt();
                if (selectMenuNum == 0) {
                    exit = true;
                    System.out.println("프로그램을 종료합니다.");
                } else if (selectMenuNum > 0 && selectMenuNum <= menuList.size()) {

                    // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                    Menu selectedMenu = menuList.get(selectMenuNum - 1);

                    System.out.println("[ " + selectedMenu.getCategoryName().toUpperCase() + " MENU ]");

                    //Menu가 가진 List<MenuItem>을 반복문을 활용하여 메뉴 출력
                    selectedMenu.showMenuItem();

                    //아이템 숫자 입력 받기
                    System.out.print("메뉴의 숫자를 입력해주세요: ");

                    try {
                        int selectItemNum = scanner.nextInt();
                        if (selectItemNum == 0) {
                            //뒤로가기
                            continue;
                        } else if (selectItemNum > 0 && selectItemNum <= selectedMenu.getMenuItems().size()) {
                            System.out.println("\n선택한 메뉴: " + selectedMenu.getMenuItems().get(selectItemNum - 1));
                        } else {
                            System.out.println("\n잘못된 선택입니다. 다시 입력해 주세요.");
                        }
                    } catch (Exception e) {
                        System.out.println("\n유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
                        scanner.next();
                    }
                    System.out.println();

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
