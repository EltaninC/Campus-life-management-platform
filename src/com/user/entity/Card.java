package com.user.entity;

public class Card {
    private int card_id;
    private int s_id;
    private String s_name;
    private int money;
    private int water;
    private int electric;

    public int getCard_id() {
        return card_id;
    }

    public int getS_id() {
        return s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public int getMoney() {
        return money;
    }

    public int getWater() {
        return water;
    }

    public int getElectric() {
        return electric;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public void setElectric(Integer electric) {
        this.electric = electric;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", money=" + money +
                ", water=" + water +
                ", electric=" + electric +
                '}';
    }

    public Card() {

    }

    public Card(int card_id, int s_id, String s_name, int money, int water, int electric) {
        this.card_id = card_id;
        this.s_id = s_id;
        this.s_name = s_name;
        this.money = money;
        this.water = water;
        this.electric = electric;
    }
}
