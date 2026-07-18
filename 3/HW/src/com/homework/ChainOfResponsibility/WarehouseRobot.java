package com.homework.ChainOfResponsibility;

public abstract class WarehouseRobot {
    protected WarehouseRobot nextRobot;

    // public WarehouseRobot(WarehouseRobot nextRobot) {
    // this.nextRobot = nextRobot;
    // }

    public WarehouseRobot setNext(WarehouseRobot next) {
        this.nextRobot = next;
        return next;
    }

    public abstract boolean process(Parcel parcel);

    protected boolean passToNext(Parcel parcel) {
        if (nextRobot == null) {
            return true;
        }
        return nextRobot.process(parcel);
    }
}
