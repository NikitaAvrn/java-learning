package com.additional;

public class People {
    private String name;
    private Integer age;
    private Sex sex;

    public People(String name, Integer age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Sex getSex() {
        return this.sex;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s; Возраст: %d; Пол: %s", this.name, this.age, this.sex.name());
    }
}
