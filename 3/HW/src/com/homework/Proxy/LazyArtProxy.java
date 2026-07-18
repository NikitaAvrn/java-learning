package com.homework.Proxy;

public class LazyArtProxy implements ArtImage {
    private final String prompt;
    private HighResAiImage realImage;

    public LazyArtProxy(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("Объект еще на создан. Инициализация...");
            realImage = new HighResAiImage(prompt);
        } else {
            System.out.println("Объект уже создан и лежит в памяти");
        }
        realImage.display();
    }
}
