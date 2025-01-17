package com.example.challenge2.handler;

import com.example.challenge2.Cart;
import com.example.challenge2.DiscountInfo;

import java.util.Scanner;

//장바구니 물건 주문 및 취소 처리 핸들러
public class OrderHandler {

    private final Cart cart;

    public OrderHandler(Cart cart) {
        this.cart = cart;
    }

    //장바구니에 물건이 있고 주문을 선택한 경우
    public void checkOrder(Scanner scanner) {
        System.out.println("\n아래와 같이 주문하시겠습니까?");
        System.out.println("\n[ Orders ]");
        cart.showCartItem();
        System.out.println("\n[ Total ]");
        System.out.println(cart.calculatePrice() + "원");

        System.out.println("\n1. 주문       2. 메뉴판");
        int finalOrder = scanner.nextInt();
        if (finalOrder == 1) {
            //할인 정보를 제공. enum 활용
            System.out.println("할인 정보를 입력해주세요.");
            DiscountInfo[] discountInfos = DiscountInfo.values();
            for (int i = 0; i < discountInfos.length; i++) {
                System.out.println(i + 1 + ". " + discountInfos[i]);
            }
            int discountInput = scanner.nextInt();
            if (discountInput > 0 && discountInput <= discountInfos.length) {
                DiscountInfo discountInfo = discountInfos[discountInput - 1];
                System.out.println("주문이 완료되었습니다. 금액은 w " + discountInfo.getTotalPrice(cart) + "원입니다.");
                cart.resetCartList(); // 주문 후 장바구니 초기화
            } else System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
        } else if (finalOrder == 2) return;
        else System.out.println("\n잘못된 선택입니다. 다시 입력해 주세요.");
    }

    //장바구니에 물건이 있고 취소를 선택한 경우
    public void cancelOrder(Scanner scanner) {
        System.out.println("주문을 취소하면 장바구니 항목이 삭제됩니다. 취소하려면 1을 눌러주세요");
        int resetListInput = scanner.nextInt();
        if (resetListInput == 1) {
            cart.resetCartList(); //장바구니 항목 삭제
            System.out.println("주문이 취소되었습니다.");
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
        }
    }

}
