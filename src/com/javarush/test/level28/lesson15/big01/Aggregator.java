package com.javarush.test.level28.lesson15.big01;


import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.LinkedInStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

import java.io.IOException;


/**
 * Created by nik on 19.06.15.
 */
public class Aggregator {

    public static void main(String[] args) throws IOException
    {
/*
3. Для запуска нужно еще обновить метод main в Aggregator.
3.1. Создай вью, модель, контроллер.
3.2. Засэть во вью контроллер.
3.3. Вызови у вью метод  userCitySelectEmulationMethod.
 */
        /*
        2. В методе main создай провайдер для LinkedInStrategy. Передай этот провайдер в конструктор Model.
Это удобно сделать, т.к. модель принимает много провайдеров.
Остальную логику менять не нужно. Видишь, как легко расширять функционал?
От правильной архитектуры зависит многое.

         */
        HtmlView htmlView = new HtmlView();

        Provider provider = new Provider(new HHStrategy());
        Provider linkedInProvider = new Provider(new LinkedInStrategy());

        Provider[] providers = {provider,linkedInProvider};

        Model model = new Model(htmlView,providers);

        Controller controller = new Controller(model);

        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod();
     /*   String testString="Test writing!!!";
        try
        {
            htmlView.updateFile(testString);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
*/
    }

}
