package com.example.kiosk2;

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
        return String.format("%-5s | w %.1f | %-5s", burgerName, price, details);
    }
}
