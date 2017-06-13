package com.law.scrambler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class URLHandler {
    public static Elements invoke(String urlString) {

        Document document = null;
        try {
            document = Jsoup.connect(urlString).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document.select("div[class=\"ingredient-group\"]");
    }

}
