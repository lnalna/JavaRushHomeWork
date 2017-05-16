package com.javarush.test.level24.lesson14.big01;

/**
 * Created by admin on 24.02.15.
 * а) Добавь в класс BaseObject  переменные x(double), y (double), radius (double)
 б) Добавить геттеры и сеттеры
 в) Добавь конструктор BaseObject(double x, double y, double radius)
 г) Надо пройтись по все классам-наследникам и поправить у них конструкторы
 Если вы пользуйтесь Intellij IDEA - Alt+Insert вам в помощь


 Т.к. объекты мы условно считаем кругами, то предлагаю такую формулу взаимодействия
 Если центр круга одного объекта попал в круг другого, то будем считать, что они столкнулись.
 Или еще проще:
 дистанция_между_объектами < max (радиус_первого_объекта, радиус_второго_объекта)

 */
public abstract class BaseObject
{
    protected double x;
    protected double y;
    protected double radius;

    protected BaseObject(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX()
    {
        return x;
    }
    public void setX(double x)
    {
        this.x=x;
    }
    public double getY()
    {
        return y;
    }
    public void setY(double y)
    {
        this.y=y;
    }
    public double getRadius()
    {
        return radius;
    }
    public void setRadius(double radius)
    {
        this.radius=radius;
    }

    public abstract void draw(Canvas canvas);
    public abstract void move();

    public void checkBorders(double minx, double maxx, double miny, double maxy)
    {
    if (x < minx) x = minx;
    if (x > maxx) x = maxx;
    if (y < miny) y = miny;
    if (y > maxy) y = maxy;
    }

    public boolean isIntersec(BaseObject o)
    {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
}
