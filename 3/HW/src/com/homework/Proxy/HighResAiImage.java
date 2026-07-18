package com.homework.Proxy;

public class HighResAiImage implements ArtImage {
    private final String prompt;

    public HighResAiImage(String prompt) {
        this.prompt = prompt;
        generateWithAi();
    }

    private void generateWithAi() {
        System.out.println(String.format("Запущена генерация нейросетью для '%s'...", prompt));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println(String.format("Картинка '%s' успешно сгенерирована в 4К", prompt));
    }

    @Override
    public void display() {
        System.out.println(String.format("Вывод на экран '%s' в высоком разрешении", prompt));
    }
}
