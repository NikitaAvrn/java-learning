package com.homework.ChainOfResponsibility;

public class WeightControlRobot extends WarehouseRobot {
    private final double maxWeightLimit = 20;

    @Override
    public boolean process(Parcel parcel) {
        if (parcel.getWeight() > maxWeightLimit) {
            System.out.println(String.format("Робот контроля веса: Превышен лимит! Посылка '%s' отправлена в брак.",
                    parcel.getTitle()));
            return false;
        }
        System.out.println("Робот контроля веса: Вес в норме.");
        return passToNext(parcel);
    }

}
