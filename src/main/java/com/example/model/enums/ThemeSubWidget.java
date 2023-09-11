package com.example.model.enums;

public class ThemeSubWidget {
    private String name;
    private ThemeSub themeSub;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThemeSub getThemeSub() {
        return themeSub;
    }

    public void setThemeSub(ThemeSub themeSub) {
        this.themeSub = themeSub;
    }

    @Override
    public String toString() {
        return "ThemeSubWidget [name=" + name + ", themeSub=" + themeSub + "]";
    }
}
