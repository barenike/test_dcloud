package com.example.test_dcloud.controller;

import com.example.test_dcloud.infrastructure.SearchFirstPageRequest;
import com.example.test_dcloud.infrastructure.SearchFirstPageResponse;
import com.example.test_dcloud.service.SearchEngineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SearchEngineController {
    private final SearchEngineService searchEngineService;

    public SearchEngineController(SearchEngineService searchEngineService) {
        this.searchEngineService = searchEngineService;
    }

    @PostMapping("/api/v1/search")
    public ResponseEntity<SearchFirstPageResponse> select(@RequestBody @Valid SearchFirstPageRequest searchFirstPageRequest) {
        try {
            SearchFirstPageResponse response = searchEngineService.getFirstSearchPage(searchFirstPageRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
