package com.example.test_dcloud.infrastructure;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SearchFirstPageRequest {

    @NotNull
    private String text;

    @NotNull
    private String engine;
}
