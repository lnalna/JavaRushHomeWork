package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by admin on 09.06.15.
 *
 * 1. В классе Advertisement создайте поле long amountPerOneDisplaying, которое инициализируйте в конструкторе.
 Оно должно равняться стоимости одного показа рекламного объявления в копейках.

 2. В классе Advertisement создайте геттеры для полей name, duration и amountPerOneDisplaying
 */
public class Advertisement {
    private Object content;       // видео
    private String name;         // имя/название
    private long initialAmount;   // начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits;             // количество оплаченных показов
    private int duration;         // продолжительность в секундах
    private long amountPerOneDisplaying;
    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = Math.round(initialAmount * 1.0 / hits);
    }
    public void revalidate() {
        if (hits <= 0)
            throw new UnsupportedOperationException();
        this.amountPerOneDisplaying = Math.round(initialAmount * 1.0 / hits);
        hits--;
    }
    public String getName() {
        return name;
    }
    public int getDuration() {
        return duration;
    }
    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
    public int getHits() {
        return hits;
    }
}