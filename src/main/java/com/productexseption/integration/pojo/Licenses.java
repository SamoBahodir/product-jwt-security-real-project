package com.productexseption.integration.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.productexseption.core.dto.Name;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Licenses {

    private Long count;
    @JsonProperty("page_size")
    private Integer pageSize;
    @JsonProperty("current_page")
    private Integer currentPage;
    @JsonProperty("data")
    private DataDTO result;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataDTO {
        @JsonProperty("certificates")
        private java.util.List<CertificatesDTO> certificates;
        @JsonProperty("totalItems")
        private Long totalItems;
        @JsonProperty("totalPages")
        private Integer totalPages;
        @JsonProperty("currentPage")
        private Integer currentPage;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CertificatesDTO {
            @JsonProperty("active")
            private Boolean active;
            @JsonProperty("status")
            private StatusDTO status;
            @JsonProperty("tin")
            private Integer tin;
            @JsonProperty("pin")
            private Object pin;
            @JsonProperty("name")
            private String name;
            @JsonProperty("region")
            private Name region;
            @JsonProperty("subRegion")
            private Name subRegion;
            @JsonProperty("address")
            private String address;
            @JsonProperty("register_number")
            private String registerNumber;
            @JsonProperty("serial")
            private Object serial;
            @JsonProperty("number")
            private String number;
            @JsonProperty("registration_date")
            private String registrationDate;
            @JsonProperty("expiry_date")
            private String expiryDate;
            @JsonProperty("type")
            private String type;
            @JsonProperty("type_title")
            private Name typeTitle;
            @JsonProperty("document")
            private Name document;
            @JsonProperty("category")
            private CategoryDTO category;
            @JsonProperty("specializations")
            private java.util.List<SpecializationsDTO> specializations;
            @JsonProperty("specialization_ids")
            private String specializationIds;
            @JsonProperty("activity_addresses")
            private java.util.List<ActivityAddressesDTO> activityAddresses;
            @JsonProperty("history")
            private Object history;
            @JsonProperty("import_register")
            private Boolean importRegister;
            @JsonProperty("training_categories")
            private Object trainingCategories;
            @JsonProperty("organization")
            private Name organization;
            @JsonProperty("organization_director")
            private Name organizationDirector;
            @JsonProperty("is_multi_specialization")
            private Boolean isMultiSpecialization;
            @JsonProperty("additions")
            private Object additions;
            @JsonProperty("branch")
            private Boolean branch;
            @JsonProperty("uuid")
            private String uuid;

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class StatusDTO {
                @JsonProperty("status")
                private String status;
                @JsonProperty("background")
                private String background;
                @JsonProperty("title")
                private Name title;

            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CategoryDTO {
                @JsonProperty("title")
                private Name title;
                @JsonProperty("icon_id")
                private String iconId;
                @JsonProperty("gradient_start_color")
                private String gradientStartColor;
                @JsonProperty("gradient_end_color")
                private String gradientEndColor;

            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SpecializationsDTO {
                @JsonProperty("position")
                private Object position;
                @JsonProperty("id")
                private Integer id;
                @JsonProperty("name")
                private Name name;
                @JsonProperty("description")
                private Name description;

            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ActivityAddressesDTO {
                @JsonProperty("position")
                private Integer position;
                @JsonProperty("value")
                private Name value;
            }
        }
    }
}
