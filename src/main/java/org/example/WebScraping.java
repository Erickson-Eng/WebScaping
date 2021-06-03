package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class WebScraping {

 public static Document getConnection(String url) throws IOException {
     return Jsoup.connect(url).get();
 }
}
