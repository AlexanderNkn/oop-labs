package main.java.lab1.person;

import main.java.lab1.actions.HeroAction;

public class Hero {
    private HeroAction activity;

    public void setHeroAction(HeroAction activity) {
        this.activity = activity;
    }

    public String runAction() {
        return activity.move();
    }
}
