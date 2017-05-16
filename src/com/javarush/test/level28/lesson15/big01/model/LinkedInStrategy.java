package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 01.07.15.
 */
public class LinkedInStrategy implements Strategy{

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancyList = new ArrayList<>();
        return vacancyList;
    }
}
