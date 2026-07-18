package com.homework.ChainOfResponsibility;

public class Parcel {
    private final String title;
    private final double weight;
    private final boolean isFragile;
    private boolean isPackedInBubbleWrap = false;
    private boolean isLabelGlued = false;

    public Parcel(String content, double weight, boolean isFragile) {
        this.title = content;
        this.weight = weight;
        this.isFragile = isFragile;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public String getTitle() {
        return title;
    }

    public void wrapInBubble() {
        this.isPackedInBubbleWrap = true;
    }

    public void glueLabel() {
        this.isLabelGlued = true;
    }

    @Override
    public String toString() {
        return String.format("Посылка [%s]: Вес=%.2f кг., Хрупкое=%s, Пупырка=%s, Штрихкод=%s", title, weight,
                isFragile, isPackedInBubbleWrap, isLabelGlued);
    }
}
