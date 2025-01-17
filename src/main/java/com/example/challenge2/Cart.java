package com.example.challenge2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        //할인되는 버거는 두 종류를 다 담을 수 없도록 stream 기능 구현
        if ("불고기버거".equals(menuItem.getFoodName())) {
            cartList = cartList.stream()
                    .filter(item -> !"슈슈버거".equals(item.getFoodName()))
                    .collect(Collectors.toList());
        } else if ("슈슈버거".equals(menuItem.getFoodName())) {
            cartList = cartList.stream()
                    .filter(item -> !"불고기버거".equals(item.getFoodName()))
                    .collect(Collectors.toList());
        }
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
        //리스트 안에 있는 CartItem 하나씩 출력. stream으로 수정
        cartList.forEach(System.out::println);
    }

    //할인 전 금액 계산하는 함수. stream으로 수정
    public int calculatePrice() {
        return (int) (cartList.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum() * 10000);
    }

}
