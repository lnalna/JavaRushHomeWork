package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.*;
import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * Created by nik on 28.06.15.
 */
public class HtmlView implements View {

    private Controller controller;

    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            String newVacanciesFileHtml = getUpdatedFileContent(vacancies);
            updateFile(newVacanciesFileHtml);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }
    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() throws IOException
    {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {
        Document document = null;
        document = getDocument();
        Element original = document.getElementsByClass("template").first();
        Element template = original.clone();
        template.removeClass("template").addClass("vacancy").removeAttr("style");
        //document.select("tr[class$=\"vacancy\"]").not("tr[class=\"vacancy template\"]").remove();
        document.select("tr[class$=vacancy]").remove();

        for (Vacancy vacancy : vacancies) {
            Element vac = template.clone();
            vac.getElementsByAttributeValue("class", "city").get(0).text(vacancy.getCity());
            vac.getElementsByAttributeValue("class", "companyName").get(0).text(vacancy.getCompanyName());
            vac.getElementsByAttributeValue("class", "salary").get(0).text(vacancy.getSalary());
            vac.getElementsByAttribute("href").get(0).attr("href", vacancy.getUrl()).text(vacancy.getTitle());
            original.before(vac.outerHtml());
        }
        return document.html();
    }
    private void updateFile(String newData) throws IOException {
        //      класс с методами записи строк // класс-преобразователь // класс записи байтов в файл
        PrintWriter pw = new PrintWriter( new OutputStreamWriter( new FileOutputStream(filePath), "UTF-8"));
        pw.write(newData);
        pw.close();
    }
    protected Document getDocument() throws IOException {
        File file = new File(filePath);
        return Jsoup.parse(file, "UTF-8");
    }
}
