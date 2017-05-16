package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;

import java.io.IOException;


/**
 * Created by nik on 21.06.15.
 */
public class Controller {
    private Model model;

    public Controller(Model model) {

        if(model == null)
            throw new IllegalArgumentException();

        this.model = model;
    }

    public void onCitySelect(String cityName) throws IOException
    {

        try
        {
            model.selectCity(cityName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
