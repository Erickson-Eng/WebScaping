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


            Element ahref = title.select("a").get(i);
            String absHref = ahref.attr("abs:href");
            System.out.println(absHref);
            System.out.println(title.getElementsByAttributeStarting("title").attr("title"));
            Document document = Jsoup.connect(absHref).get();
            Element author = document.getElementsByClass("author-name").get(i);
            Element ref = author.select("a").get(i);
            String authorName = ref.text();
            System.out.println(authorName);




        }


    }
}
