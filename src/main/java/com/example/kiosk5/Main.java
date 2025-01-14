package com.example.kiosk5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Menu 객체 생성하면서 카테고리 이름 설정
        Menu burgerCategory = new Menu("Burgers");
        //Menu 클래스 내 있는 List<MenuItem>에 MenuItem 객체 생성하면서 삽입
        burgerCategory.addMenuItem(new MenuItem("빅맥", 0.6, "쇠고기 패티 두장, 소스, 치즈, 야채가 어우러진 버거"));
        burgerCategory.addMenuItem(new MenuItem("쿼터파운더치즈", 0.7, "쇠고기 패티, 두꺼운 치즈, 야채, 머스타드가 들어간 버거"));
        burgerCategory.addMenuItem(new MenuItem("슈슈버거", 0.65, "통새우살 가득한 버거"));
        burgerCategory.addMenuItem(new MenuItem("불고기버거", 0.5, "불고기 소스와 쇠고기 패티가 어우러진 버거"));

        Menu DrinkCategory = new Menu("Drinks");
        DrinkCategory.addMenuItem(new MenuItem("콜라", 0.2, "시원한 콜라"));
        DrinkCategory.addMenuItem(new MenuItem("사이다", 0.2, "시원한 사이다"));
        DrinkCategory.addMenuItem(new MenuItem("환타", 0.2, "시원한 환타"));

        Menu DessertCategory = new Menu("Desserts");
        DessertCategory.addMenuItem(new MenuItem("애플파이", 0.2, "사과와 시나몬 필링 가득한 파이"));
        DessertCategory.addMenuItem(new MenuItem("오레오 맥플러리", 0.4, "바닐라 아이스크림에 오레오 크럼블이 섞인 디저트"));
        DessertCategory.addMenuItem(new MenuItem("바닐라 쉐이크", 0.3, "바닐라 향이 가득한 밀크쉐이크"));

        //Menu 리스트 생성
        List<Menu> menuList = new ArrayList<>();
        menuList.add(burgerCategory);
        menuList.add(DrinkCategory);
        menuList.add(DessertCategory);

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menuList);

        // Kiosk 내 시작하는 함수 호출
        kiosk.start();

    }
}
