package com.homework;

import java.util.ArrayList;
import java.util.List;

import com.homework.ChainOfResponsibility.BubbleWrapRobot;
import com.homework.ChainOfResponsibility.LabelRobot;
import com.homework.ChainOfResponsibility.Parcel;
import com.homework.ChainOfResponsibility.WarehouseRobot;
import com.homework.ChainOfResponsibility.WeightControlRobot;
import com.homework.Strategy.DriftDrive;
import com.homework.Strategy.EcoDrive;
import com.homework.Strategy.ElectricCar;
import com.homework.Strategy.PowerDrive;

public class Main {
    public static void main(String[] args) {
        strategyPattern();
        chainOfResponsibilityPattern();
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