package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 21.06.15.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
   //   private static final String URL_FORMAT ="http://javarush.ru/testdata/big28data.html";

    @Override
    public List<Vacancy> getVacancies(String searchString) {

        List<Vacancy> vacancyList = new ArrayList<>();
        int pageNumber = 0;

        while (true) {
            try {
                Document doc = getDocument(searchString, pageNumber);
                Elements vacancyElements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");

                if (vacancyElements.size() == 0) break;

                for (Element vacancyElement : vacancyElements) {
                    Vacancy parsedVacancy = new Vacancy();

                    parsedVacancy.setTitle(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    parsedVacancy.setCompanyName(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    parsedVacancy.setCity(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    parsedVacancy.setSiteName(doc.title());
                    parsedVacancy.setUrl(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                    parsedVacancy.setSalary(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());

                    vacancyList.add(parsedVacancy);
                }
                pageNumber++;
            }
            catch (IOException e) {
            }
        }

        return vacancyList;
    }
    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT,searchString, page);
        Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (jsoup)").referrer("some text").timeout(5000).get();
        return doc;
    }
}
