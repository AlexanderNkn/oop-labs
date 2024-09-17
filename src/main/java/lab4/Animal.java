package main.java.lab4;

public class Animal {

    @RepeatCallAnnotation(count = 2)
    String moo(){
        return "Мууу!";
    }

    @RepeatCallAnnotation(count = 3)
    public String grunt(){
        return "Хрю-хрю!";
    }

    @RepeatCallAnnotation(count = 4)
    private String meow(){
        return  "Мяу!";
    }

    @RepeatCallAnnotation(count = 5)
    protected String bark(){
        return   "Гав!";
    }
}
