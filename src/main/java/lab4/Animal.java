package main.java.lab4;

public class Animal {

    @RepeatCall(count = 2)
    String moo(){
        return "Мууу!";
    }

    @RepeatCall(count = 3)
    public String grunt(){
        return "Хрю-хрю!";
    }

    @RepeatCall(count = 4)
    private String meow(){
        return  "Мяу!";
    }

    @RepeatCall(count = 5)
    protected String bark(){
        return   "Гав!";
    }
}
