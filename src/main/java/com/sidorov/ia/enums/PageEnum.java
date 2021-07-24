package com.sidorov.ia.enums;

public enum PageEnum {
    MAIN("main");

    public String getName() {
        return name;
    }

    private final String name;

    PageEnum(String name) {
        this.name = name;
    }



}
