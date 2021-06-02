package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://www.infomoney.com.br/mercados/").get();
        Element link = doc.getElementById("infiniteScroll");
        List<Element> elementsList = link.getElementsByClass("row py-3 item");

        for (Element title: elementsList
             ) {

            int i = 0;

            // Article
            Element ahref = title.select("a").get(i);
            String absHref = ahref.attr("abs:href");
            String titleArticle = title.getElementsByAttributeStarting("title").attr("title");

            // Author
            Document document = Jsoup.connect(absHref).get();
            Element author = document.getElementsByClass("author-name").get(i);
            Element refAuthor = author.select("a").get(i);
            String authorName = refAuthor.text();

            // Date
            Element articleDate = document.getElementsByClass("article-date").get(i);
            Element refDate = articleDate.select("time").get(i);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String date = refDate.attr("datetime");

            Elements articleBody = document.getElementsByClass("col-md-9 col-lg-8 col-xl-6  m-sm-auto m-lg-0 article-content");

            // Output
            System.out.println("Url: " +absHref); // url
            System.out.println("Titulo: "+titleArticle); // titulo
            System.out.println("Author: "+authorName); // Nome do autor
            System.out.println("Data: "+date);
            for (Element element: articleBody
            ) {
                System.out.println(element.text());
            }
            System.out.println();


        }
    }
}
