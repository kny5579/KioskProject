package com.example.challenge2;

import com.example.challenge2.handler.MenuItemHandler;
import com.example.challenge2.handler.OrderHandler;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

//메뉴 관리 및 사용자 입력 처리
public class Kiosk {

    private final Cart cart = new Cart();

    private final MenuItemHandler menuItemHandler = new MenuItemHandler(cart);
    private final OrderHandler orderHandler = new OrderHandler(cart);

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
            //메인메뉴와 오더메뉴 표시
            displayMainOrder();

            //메뉴 숫자 입력 받기
            System.out.print("메뉴의 숫자를 입력해주세요: ");
            try {
                int selectMenuNum = scanner.nextInt();
                if (selectMenuNum == 0) {
                    exit = true;
                    System.out.println("프로그램을 종료합니다.");
                } else if (selectMenuNum > 0 && selectMenuNum <= menuList.size()) {
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                    Menu selectedMenu = menuList.get(selectMenuNum - 1);

                    System.out.println("\n[ " + selectedMenu.getCategoryName().toUpperCase() + " MENU ]");

                    //Menu가 가진 List<MenuItem>을 반복문을 활용하여 메뉴 출력
                    selectedMenu.showMenuItem();

                    if (selectMenuNum == 1) {
                        System.out.println("할인 품목은 한 종류만 주문 가능합니다.");
                    }
                    //아이템 숫자 입력 받기
                    System.out.print("메뉴의 숫자를 입력해주세요: ");

                    //아이템 선택 및 장바구니 추가하기
                    menuItemHandler.selectMenuHandler(scanner, selectedMenu);
                } else if (cart.isCartNotEmpty() && selectMenuNum == menuList.size() + 1) {
                    //장바구니에 물건이 있고 주문을 선택한 경우
                    orderHandler.checkOrder(scanner);
                } else if (cart.isCartNotEmpty() && selectMenuNum == menuList.size() + 2) {
                    //장바구니에 물건이 있고 취소를 선택한 경우
                    orderHandler.cancelOrder(scanner);
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

    //메인메뉴와 오더메뉴 표시하는 메소드
    private void displayMainOrder() {
        System.out.println("\n[ MAIN MENU ]");

        // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력. stream으로 변경
        IntStream.range(0, menuList.size()).forEach(i -> System.out.println(i + 1 + ". " + menuList.get(i).getCategoryName()));
        System.out.println("0. 종료 | 종료");

        //장바구니에 물건이 있는 경우
        if (cart.isCartNotEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println(menuList.size() + 1 + ". Orders      | 장바구니를 확인 후 주문합니다.");
            System.out.println(menuList.size() + 2 + ". Cancel      | 진행중인 주문을 취소합니다.");
        }
    }


}
