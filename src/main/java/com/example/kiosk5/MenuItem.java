package com.example.kiosk5;

//세부 메뉴 속성을 가지는 클래스
public class MenuItem {

    private final String foodName;
    private final double price;
    private final String details;

    //생성자
    public MenuItem(String foodName, double price, String details) {
        this.foodName = foodName;
        this.price = price;
        this.details = details;
    }

    //메뉴 출력 문구 지정
    @Override
    public String toString() {
        return String.format("%-15s | w %.1f | %-15s", foodName, price, details);
    }
}
