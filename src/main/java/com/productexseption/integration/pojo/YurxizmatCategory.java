package com.productexseption.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class YurxizmatCategory {

    @JsonProperty("data")
    private List<DataDTO> data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("parent_id")
        private String parentId;
        @JsonProperty("name")
        private String name;
        @JsonProperty("url")
        private String url;
        @JsonProperty("children")
        private List<ChildrenDTO> children;

        @NoArgsConstructor
        @Data
        public static class ChildrenDTO {
            @JsonProperty("id")
            private String id;
            @JsonProperty("parent_id")
            private String parentId;
            @JsonProperty("name")
            private String name;
            @JsonProperty("url")
            private String url;
            @JsonProperty("children")
            private List<ChildrenDTO1> children;

            @NoArgsConstructor
            @Data
            public static class ChildrenDTO1 {
                @JsonProperty("id")
                private String id;
                @JsonProperty("parent_id")
                private String parentId;
                @JsonProperty("name")
                private String name;
                @JsonProperty("url")
                private String url;
                @JsonProperty("children")
                private List<ChildrenDTO2> children;
                @NoArgsConstructor
                @Data
                public static class ChildrenDTO2 {
                    @JsonProperty("id")
                    private String id;
                    @JsonProperty("parent_id")
                    private String parentId;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("url")
                    private String url;
                }
            }
        }
    }
}
