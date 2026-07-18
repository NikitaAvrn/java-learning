package com.homework;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.homework.Adapter.CelsiusThermometer;
import com.homework.Adapter.FahrenheitThermometer;
import com.homework.Adapter.FahrenheitToCelsiusAdapter;
import com.homework.Builder.MadMaxCar;
import com.homework.ChainOfResponsibility.BubbleWrapRobot;
import com.homework.ChainOfResponsibility.LabelRobot;
import com.homework.ChainOfResponsibility.Parcel;
import com.homework.ChainOfResponsibility.WarehouseRobot;
import com.homework.ChainOfResponsibility.WeightControlRobot;
import com.homework.Decorator.BayonetDecorator;
import com.homework.Decorator.RustedRifle;
import com.homework.Decorator.SilencerDecorator;
import com.homework.Decorator.Weapon;
import com.homework.Proxy.ArtImage;
import com.homework.Proxy.LazyArtProxy;
import com.homework.Strategy.DriftDrive;
import com.homework.Strategy.EcoDrive;
import com.homework.Strategy.ElectricCar;
import com.homework.Strategy.PowerDrive;

public class Main {
    public static void main(String[] args) {
        strategyPattern();
        chainOfResponsibilityPattern();
        builderPattern();
        proxyPattern();
        decoratorPattern();
        adapterPattern();
    }

    private static void adapterPattern() {
        FahrenheitThermometer fahrenheitThermometer = new FahrenheitThermometer();
        CelsiusThermometer celsiusThermometer = new FahrenheitToCelsiusAdapter(fahrenheitThermometer);

        System.out.println("Серия замеров");
        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("Замер номер %d", i + 1));
            double temperature = celsiusThermometer.getCelsiusTemperature();
            System.out.println(String.format("Температура: %.1f °C%n", temperature));
        }
    }

    private static void decoratorPattern() {
        Weapon myGun = new RustedRifle();
        System.out.println(myGun);
        myGun.fire();

        myGun = new SilencerDecorator(myGun);
        System.out.println(myGun);
        myGun.fire();

        BayonetDecorator ultraGun = new BayonetDecorator(myGun);
        System.out.println(ultraGun);
        ultraGun.fire();
        ultraGun.meleeAttack();
    }

    private static void proxyPattern() {
        ArtImage picture1 = new LazyArtProxy("Кот в сапгах в стиле киберпанка");
        ArtImage picture2 = new LazyArtProxy("Восход солнца на Марсе");

        System.out.println(LocalDateTime.now());
        picture1.display();

        System.out.println(LocalDateTime.now());
        picture1.display();

        // picture2 не использовали - память и процессорное время не использовали
        System.out.println(picture2);
    }

    private static void builderPattern() {
        MadMaxCar madMaxCar = new MadMaxCar.Builder("Багги", "V8 QuatroTurbo")
                .setArmor(28)
                .installNitro()
                .addWeapon("Пушка ШВАК 20мм")
                .addWeapon("Пулемет 12мм")
                .build();
        MadMaxCar truck = new MadMaxCar.Builder("Камаз 53410", "Ядерный реактор")
                .setArmor(45)
                .addWeapon("Две циркулярные пилы")
                .addWeapon("Огнемёт")
                .build();

        System.out.println(madMaxCar);
        System.out.println(truck);
    }

    private static void chainOfResponsibilityPattern() {
        WarehouseRobot conveyor = new WeightControlRobot();
        conveyor.setNext(new BubbleWrapRobot())
                .setNext(new LabelRobot());

        List<Parcel> parcels = new ArrayList<Parcel>(List.of(
                new Parcel("Хрустальная ваза", 2.5, true),
                new Parcel("Смартфон ЯТелефон ПроМаркс", .5, true),
                new Parcel("Наковальня", 55, false)));

        for (Parcel parcel : parcels) {
            System.out.println(String.format("--- %s ---", parcel.getTitle()));
            if (conveyor.process(parcel)) {
                System.err.println("Успех! Заказ отправлен клиенту");
            } else {
                System.err.println("Ошибка! Заказ отменен");
            }
        }
    }

    private static void strategyPattern() {
        System.out.println("Strategy pattern");

        ElectricCar tesla = new ElectricCar(new EcoDrive());
        tesla.pressAccelerate();
        tesla.releaseAccelerate();
        System.out.println(tesla.engineInfo());

        System.out.println(tesla.changeDriveMode(new PowerDrive()));
        tesla.pressAccelerate();
        tesla.releaseAccelerate();
        System.out.println(tesla.engineInfo());

        System.out.println(tesla.changeDriveMode(new DriftDrive()));
        tesla.pressAccelerate();
        tesla.releaseAccelerate();
        System.out.println(tesla.engineInfo());
    }
}