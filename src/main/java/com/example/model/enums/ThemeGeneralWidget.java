package com.example.model.enums;

public class ThemeGeneralWidget {
    private String name;
    private ThemeGeneral themeGeneral;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThemeGeneral getThemeGeneral() {
        return themeGeneral;
    }

    public void setThemeGeneral(ThemeGeneral themeGeneral) {
        this.themeGeneral = themeGeneral;
    }

    @Override
    public String toString() {
        return "ThemeGeneralWidget [name=" + name + ", themeGeneral=" + themeGeneral + "]";
    }
}
