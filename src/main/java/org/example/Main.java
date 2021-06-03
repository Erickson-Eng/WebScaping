package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://www.infomoney.com.br/mercados/").get();
        Element link = doc.getElementById("infiniteScroll");
        List<Element> elementsList = link.getElementsByClass("row py-3 item");

        for (int i = 0; i < 3; i++) {
            int j = 0;
            Element title = elementsList.get(i).select("a").get(j);
            String abHref = title.attr("abs:href");
            String titleArticle1 = title.getElementsByAttributeStarting("title").attr("title");

            Document document = Jsoup.connect(abHref).get();
            Element author = document.getElementsByClass("author-name").get(j);
            Element refAuthor = author.select("a").get(j);
            String authorName = refAuthor.text();

            Element articleDate = document.getElementsByClass("article-date").get(j);
            Element refDate = articleDate.select("time").get(j);
            String date = refDate.attr("datetime");
            DateTimeFormatter inputDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss-03:00");
            DateTimeFormatter outputDtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(date, inputDtf);
            String finalDate = outputDtf.format(localDateTime);

            Elements articleBody = document.getElementsByClass("col-md-9 col-lg-8 col-xl-6  m-sm-auto m-lg-0 article-content");

            System.out.println(abHref);
            System.out.println(titleArticle1);
            System.out.println(authorName);
            System.out.println(finalDate);

            for (Element element: articleBody
                 ) {
                System.out.println(element.text());
            }
            System.out.println();
        }
    }
}
