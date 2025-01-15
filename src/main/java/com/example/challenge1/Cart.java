package com.example.challenge1;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartList;

    public Cart() {
        cartList = new ArrayList<CartItem>();
    }

    //장바구니 항목을 추가하는 함수. 장바구니에 이미 있으면 quantity 추가
    public void addCart(MenuItem menuItem) {
        for (CartItem cartItem : cartList) {
            if (cartItem.getFoodName().equals(menuItem.getFoodName())) {
                cartItem.plusQuantity();
                return;
            }
        }
        cartList.add(new CartItem(menuItem.getFoodName(), 1, menuItem.getPrice()));
    }

    //getter. 장바구니 목록 가져오는 함수
    public List<CartItem> getCartList() {
        return cartList;
    }

    //setter. 주문 취소 시 장바구니 리셋하는 함수
    public void resetCartList() {
        cartList.clear();
    }

    //cartList 비었는지 체크. 장바구니에 물건이 있을 경우 true
    public boolean isCartNotEmpty() {
        return !cartList.isEmpty();
    }

    //리스트에 들어있는 CartItem을 순차적으로 보여주는 함수(장바구니에 담은 모든 항목 출력)
    public void showCartItem() {
        //리스트 안에 있는 CartItem 하나씩 출력
        for (CartItem cartItem : cartList) {
            System.out.println(cartItem);
        }
    }

    //총 금액 계산하는 함수
    public int calculatePrice() {
        double sumPrice = 0.0;
        for (CartItem cartItem : cartList) {
            sumPrice += cartItem.getPrice() * cartItem.getQuantity();
        }
        return (int) (sumPrice * 10000); //한국식 돈으로 계산
    }

}
