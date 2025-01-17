package com.example.challenge2;

//장바구니 관리하는 클래스
public class CartItem extends MenuItem {

    private int quantity;

    public CartItem(String foodName, int quantity, double price) {
        super(foodName, price); //details에 null을 넣는 건 안좋은 것 같아 수정
        this.quantity = quantity;
    }

    //getter
    public int getQuantity() {
        return quantity;
    }

    //setter
    public void plusQuantity() {
        ++quantity;
    }

    @Override
    public String toString() {
        return String.format("%-5s | w %.1f | %d개", getFoodName(), getPrice(), quantity);
    }

}
