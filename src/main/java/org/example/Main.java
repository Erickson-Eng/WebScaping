package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
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
            String date = refDate.text();

            // Output
            System.out.println(absHref); // url
            System.out.println(titleArticle); // titulo
            System.out.println(authorName); // Nome do autor
            System.out.println(date);

        }


    }
}
