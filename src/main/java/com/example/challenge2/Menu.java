package com.example.challenge2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//MenuItem 관리하는 클래스
public class Menu {

    //List 선언 및 초기화
    private final List<MenuItem> menuItems;

    //카테고리 선언
    private final String categoryName;

    //생성자를 통해 값 할당
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    //getter
    public String getCategoryName() {
        return categoryName;
    }

    //getter. 리스트를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    //setter. 리스트에 아이템 추가하는 함수
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    //리스트에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void showMenuItem() {
        //리스트 안에 있는 MenuItem 하나씩 출력 Stream 사용
        IntStream.range(0,menuItems.size()).forEach(i -> System.out.println(i+1+". "+menuItems.get(i)));
        System.out.println("0. 뒤로가기 | 뒤로가기");
    }

}
