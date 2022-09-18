package com.example.test_dcloud.infrastructure;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SearchFirstPageResponse {

    @NotNull
    @NotEmpty
    private List<SearchFirstPageResponseDetails> searchFirstPageResponseDetails;
}
