package com.example.test_dcloud.infrastructure;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SearchFirstPageResponseDetails {

    @NotNull
    private String title;

    @NotNull
    private String url;
}
