package org.example;

import org.example.entities.Article;
import org.example.utils.DateUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String url = "https://www.infomoney.com.br/mercados/";
        Document doc = WebScraping.getConnection(url);
        Element link = doc.getElementById("infiniteScroll");
        List<Element> elementsList = link.getElementsByClass("row py-3 item");

        for (int i = 0; i < 3; i++) {
            int j = 0;

            //Titulo do artigo
            Element title = elementsList.get(i).select("a").get(j);
            String abHref = title.attr("abs:href");
            String titleArticle1 = title.getElementsByAttributeStarting("title").attr("title");

            // metodo de captura das informações
            Document document = WebScraping.getConnection(abHref);

            // Subtitulo
            Element subTitle = document.getElementsByClass("article-lead").get(j);
            String subTitleText = subTitle.text();

            //Autor
            Element author = document.getElementsByClass("author-name").get(j);
            Element refAuthor = author.select("a").get(j);
            String authorName = refAuthor.text();

            //Data de publicação
            Element articleDate = document.getElementsByClass("article-date").get(j);
            Element refDate = articleDate.select("time").get(j);
            String date = refDate.attr("datetime");
            String dateTime = DateUtil.brazilDateTimeFormatter(date);
            // corpo da publicação
            String texts = "";
            // Conteuodo do artigo
            Elements articleBody = document.getElementsByClass("col-md-9 col-lg-8 col-xl-6  m-sm-auto m-lg-0 article-content");
//            articleBody.forEach(n -> texts = n.text());


            for (Element element: articleBody)
                texts = element.text();


            Article newArticle = new Article(abHref,titleArticle1,subTitleText,authorName,dateTime,texts);
            System.out.println(newArticle);
            System.out.println();
        }
    }
}
