package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    //Змінна для сторінок
    int PAGE_VALUE = 0;

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        Document document = null;
        try {
            document = getDocument(searchString, PAGE_VALUE);
            //цикл працює доки є сторінки.
            while (true) {
                Elements elements = document.body().getElementsByClass("job");
                if (elements.size() == 0) {
                    PAGE_VALUE = 0;
                    break;
                }
                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();

                    vacancy.setTitle(element.getElementsByClass("title").select("a").first().text());
                    //vacancy.setCity(element.getElementsByClass("location").select("a").text());

                    Element city = element.getElementsByClass("location").first();
                    if(city != null) vacancy.setCity(city.select("a").text());
                    else vacancy.setCity("");

                    vacancy.setCompanyName(element.getElementsByClass("company_name").text());
                    vacancy.setSiteName("https://moikrug.ru");
                    vacancy.setUrl("https://moikrug.ru" + element.getElementsByClass("title").select("a").first().attr("href"));

                    Element sal = element.getElementsByClass("count").first();
                    if (sal != null) vacancy.setSalary(sal.text());
                    else vacancy.setSalary("");

                    result.add(vacancy);
                }
                ++PAGE_VALUE;
                document = getDocument(searchString, PAGE_VALUE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    protected Document getDocument(String searchString, int page)  {
        Document doc = null;
        String myURL = String.format(URL_FORMAT, searchString, page);
        try {
            doc = Jsoup.connect(myURL).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36")
                    .referrer("").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;}
}
