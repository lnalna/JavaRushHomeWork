package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by nik on 19.06.15.
 */
public interface Strategy {
    List<Vacancy> getVacancies(String searchString);

}

