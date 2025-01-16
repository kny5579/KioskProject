package com.example.challenge2;

import com.example.challenge2.Cart;

public enum DiscountInfo {
    NATIONAL("국가 유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    GENERAL("일반", 0);

    private final String userType;
    private final int rate;

    private DiscountInfo(String userType, int rate) {
        this.userType = userType;
        this.rate = rate;
    }

    public String getUserType() {
        return this.userType;
    }

    public int getRate() {
        return this.rate;
    }

    public int getTotalPrice(Cart cart) {
        return cart.calculatePrice() - (cart.calculatePrice()*this.rate/100);
    }

    @Override
    public String toString() {
        return String.format("%-5s : %d%%",userType,rate);
    }
}
