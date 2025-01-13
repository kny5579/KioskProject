package com.example.kiosk;

//세부 메뉴 속성을 가지는 클래스
public class MenuItem {

    private String burgerName;
    private double price;
    private String details;

    //생성자
    public MenuItem(String burgerName, double price, String details) {
        this.burgerName = burgerName;
        this.price = price;
        this.details = details;
    }

}
