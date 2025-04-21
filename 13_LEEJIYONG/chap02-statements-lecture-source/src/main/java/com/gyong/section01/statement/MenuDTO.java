package com.gyong.section01.statement;

public class MenuDTO {

    private String menu_name;
    private int menu_price;

    public MenuDTO(String menu_name, int menu_price) {
        this.menu_name = menu_name;
        this.menu_price = menu_price;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
            "menu_name='" + menu_name + '\'' +
            ", menu_price=" + menu_price +
            '}';
    }
}
