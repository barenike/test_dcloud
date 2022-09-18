package com.example.test_dcloud.service;

import com.example.test_dcloud.infrastructure.SearchFirstPageRequest;
import com.example.test_dcloud.infrastructure.SearchFirstPageResponse;
import com.example.test_dcloud.infrastructure.SearchFirstPageResponseDetails;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class SearchEngineService {

    public SearchFirstPageResponse getFirstSearchPage(SearchFirstPageRequest searchFirstPageRequest) {
        String stringUrl = "https://";
        String searchEngine = searchFirstPageRequest.getEngine();
        String text = searchFirstPageRequest.getText();
        String cssQuery = "";
        SearchFirstPageResponse response = new SearchFirstPageResponse();

        switch (searchEngine) {
            case "google.com" -> {
                stringUrl += "www." + searchEngine + "/search?q=" + text.replaceAll(" ", "+");
                cssQuery = "div[data-sokoban-container] a[data-ved]";
            }
            case "duckduckgo.com" -> {
                stringUrl += searchEngine + "/html/?q=" + text.replaceAll(" ", "+");
                cssQuery = "a[class=\"result__a\"]";
            }
            case "yandex.ru" -> {
                stringUrl += searchEngine + "/search?text=" + text.replaceAll(" ", "+");
                cssQuery = "a[class=\"Link Link_theme_normal OrganicTitle-Link organic__url link i-bem\"]";
            }
        }
        try {
            ArrayList<SearchFirstPageResponseDetails> responseDetailsList = new ArrayList<>();
            Document doc = Jsoup.connect(stringUrl).get();
            Elements links = doc.select(cssQuery);

            for (Element link : links) {
                String title = link.text();
                String url = link.absUrl("href");

                SearchFirstPageResponseDetails responseDetails = new SearchFirstPageResponseDetails();

                responseDetails.setTitle(title);
                responseDetails.setUrl(url);

                responseDetailsList.add(responseDetails);
            }
            response.setSearchFirstPageResponseDetails(responseDetailsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
