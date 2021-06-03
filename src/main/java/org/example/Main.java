package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.List;
import java.util.Locale;

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


//            DateTimeFormatter dateTimeFormatterInput = DateTimeFormatter.ofPattern("2021-06-02'T'17:22:14'-03:00'",Locale.getDefault());
//            DateTimeFormatter dateTimeFormatterOutput = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss",Locale.getDefault());
//            LocalDateTime localDateTime = LocalDateTime.parse(date,dateTimeFormatterInput);
//            String formattedDate = dateTimeFormatterOutput.format(localDateTime);
//            System.out.println(formattedDate);



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
//        for (Element title: elementsList
//             ) {
//
//            int i = 0;
//
//            // Article
//            Element ahref = title.select("a").get(i);
//            String absHref = ahref.attr("abs:href");
//            String titleArticle = title.getElementsByAttributeStarting("title").attr("title");
//
//            // Author
//            Document document = Jsoup.connect(absHref).get();
//            Element author = document.getElementsByClass("author-name").get(i);
//            Element refAuthor = author.select("a").get(i);
//            String authorName = refAuthor.text();
//
//            // Date
//            Element articleDate = document.getElementsByClass("article-date").get(i);
//            Element refDate = articleDate.select("time").get(i);
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//            String date = refDate.attr("datetime");
//
//            Elements articleBody = document.getElementsByClass("col-md-9 col-lg-8 col-xl-6  m-sm-auto m-lg-0 article-content");
//
//            // Output
//            System.out.println("Url: " +absHref); // url
//            System.out.println("Titulo: "+titleArticle); // titulo
//            System.out.println("Author: "+authorName); // Nome do autor
//            System.out.println("Data: "+date);
//            for (Element element: articleBody
//            ) {
//                System.out.println(element.text());
//            }
//            System.out.println();
//        }
    }
}
