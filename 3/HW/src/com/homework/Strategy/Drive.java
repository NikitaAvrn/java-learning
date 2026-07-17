package com.homework.Strategy;

public interface Drive {
    void accelerate(Engine engine);

    void release(Engine engine);

    String info();
}