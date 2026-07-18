package com.homework.ChainOfResponsibility;

public class BubbleWrapRobot extends WarehouseRobot {

    @Override
    public boolean process(Parcel parcel) {
        if (parcel.isFragile()) {
            parcel.wrapInBubble();
            System.out.println("Робот-упаковщик: Товар хрупкий! Обернул в пупырчатую пленку.");
        } else {
            System.out.println("Робот-упаковщик: Обычный товар, пупырка не нужна.");
        }
        return passToNext(parcel);
    }

}
