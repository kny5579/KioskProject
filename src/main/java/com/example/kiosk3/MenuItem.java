package com.example.kiosk3;

//세부 메뉴 속성을 가지는 클래스
public class MenuItem {

    private final String burgerName;
    private final double price;
    private final String details;

    //생성자
    public MenuItem(String burgerName, double price, String details) {
        this.burgerName = burgerName;
        this.price = price;
        this.details = details;
    }

    //메뉴 출력 문구 지정
    @Override
    public String toString() {
        return String.format("%-15s | w %.1f | %-15s", burgerName, price, details);
    }
}
