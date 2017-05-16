package com.javarush.test.level13.lesson11.bonus03;

public abstract class AbstractRobot implements Attackable, Defensable
{
    private static int hitCount;
    public BodyPart attack()
    {
        BodyPart attackedBodyPart = BodyPart.CHEST;//null;
        hitCount = hitCount + 1;

        if (hitCount == 1)
        {
            attackedBodyPart =  BodyPart.ARM;
        } else if (hitCount == 2)
        {
            attackedBodyPart =  BodyPart.HEAD;
        } else if (hitCount == 3)
        {
        //    hitCount = 0;
            attackedBodyPart =  BodyPart.LEG;
        }
        else if (hitCount == 4)
        {
           //hitCount = 0;
            attackedBodyPart =  BodyPart.CHEST;
        }
        else if (hitCount == 5)
        {
            hitCount = 0;
        }
        return attackedBodyPart;
    }

    public BodyPart defense()
    {
        BodyPart defencedBodyPart = BodyPart.CHEST ;//null;
        hitCount = hitCount + 1;

        if (hitCount == 1)
        {
            defencedBodyPart =  BodyPart.CHEST; //HEAD
        } else if (hitCount == 2)
        {
            defencedBodyPart =  BodyPart.ARM; //LEG
        } else if (hitCount == 3)
        {
          //  hitCount = 0;
           defencedBodyPart =  BodyPart.HEAD; //ARM
        } else if (hitCount == 4)
        {
           // hitCount = 0;
            defencedBodyPart =  BodyPart.LEG;
        }
        else if (hitCount == 5)
        {
            hitCount = 0;
        }
        return defencedBodyPart;
    }
}
