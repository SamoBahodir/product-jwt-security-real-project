package com.productexseption.integration.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Advice implements Serializable {

    @JsonProperty("category")
    private List<?> category;
    @JsonProperty("document")
    private List<DocumentDTO> document;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DocumentDTO implements Serializable {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("image")
        private String image;
    }
}
