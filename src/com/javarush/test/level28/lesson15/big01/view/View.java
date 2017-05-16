package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Created by nik on 28.06.15.
 */
public interface View {
    void update(List<Vacancy> vacancies) throws IOException;
    void setController(Controller controller);
}
