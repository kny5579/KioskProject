package com.example.challenge2;

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

    //생성자. cartItem 클래스에서 사용할 생성자
    public MenuItem(String foodName, double price) {
        this.foodName = foodName;
        this.price = price;
        this.details = "no details";
    }

    public String getFoodName() {
        return foodName;
    }

    public double getPrice() {
        return price;
    }

    //메뉴 출력 문구 지정
    @Override
    public String toString() {
        return String.format("%-5s | w %.1f | %-5s", foodName, price, details);
    }
}
