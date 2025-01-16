package com.example.challenge2.handler;

import com.example.challenge2.Menu;
import com.example.challenge2.Cart;
import com.example.challenge2.MenuItem;

import java.util.Scanner;

//메뉴 아이템 선택 및 장바구니 추가 처리 핸들러
public class MenuItemHandler {

    private final Cart cart;

    public MenuItemHandler(Cart cart) {
        this.cart = cart;
    }

    //아이템을 선택하고 장바구니에 추가하는 메소드
    public void selectMenuHandler(Scanner scanner, Menu selectedMenu) {
        try {
            int selectItemNum = scanner.nextInt();
            if (selectItemNum == 0) {
                //뒤로가기
                return;
            } else if (selectItemNum > 0 && selectItemNum <= selectedMenu.getMenuItems().size()) {
                MenuItem selectedMenuItem = selectedMenu.getMenuItems().get(selectItemNum - 1);
                System.out.println("\n선택한 메뉴: " + selectedMenuItem);

                //장바구니 관련 코드
                System.out.println("\n" + selectedMenuItem);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인       2. 취소");

                //장바구니 추가
                try {
                    int addCartInput = scanner.nextInt();
                    if (addCartInput == 1) {
                        cart.addCart(selectedMenuItem);
                        System.out.println("\n" + selectedMenuItem.getFoodName() + "이(가) 장바구니에 추가되었습니다.");
                    } else if (addCartInput == 2) return;
                    else throw new ArithmeticException("올바르지 않은 숫자입니다.");
                } catch (Exception e) {
                    System.out.println("\n유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
                    scanner.next();
                }
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
