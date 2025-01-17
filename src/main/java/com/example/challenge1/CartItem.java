package com.example.challenge1;

//장바구니 관리하는 클래스
public class CartItem extends MenuItem {

    private int quantity;

    public CartItem(String foodName, int quantity, double price) {
        super(foodName, price);
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
