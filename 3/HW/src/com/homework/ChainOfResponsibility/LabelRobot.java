package com.homework.ChainOfResponsibility;

public class LabelRobot extends WarehouseRobot {

    @Override
    public boolean process(Parcel parcel) {
        parcel.glueLabel();
        System.out.println("Робот маркировки: Штрихкод наклеен.");
        return passToNext(parcel);
    }
}
