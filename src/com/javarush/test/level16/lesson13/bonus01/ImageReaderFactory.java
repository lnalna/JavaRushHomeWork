package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

import java.io.IOException;

/**
 * Created by admin on 27.11.14.
 */
public class ImageReaderFactory
{


    public static ImageReader getReader(ImageTypes test)
    {
        if (test==ImageTypes.BMP) return new BmpReader();
        else if (test==ImageTypes.JPG) return new JpgReader();
        else if (test==ImageTypes.PNG) return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");

    }
}
