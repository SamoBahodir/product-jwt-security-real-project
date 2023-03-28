package com.productexseption.integration.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvocacyRegister {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("manCount")
    private Integer manCount;
    @JsonProperty("list")
    private List<ListDTO> list;
    @JsonProperty("femaleCount")
    private Integer femaleCount;
    private Double rate;
    private Long view;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListDTO {
        @JsonProperty("regionNameEn")
        private String regionNameEn;
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("newUploadPath")
        private Object newUploadPath;
        @JsonProperty("uploadPath")
        private String uploadPath;
        @JsonProperty("latitude")
        private Object latitude;
        @JsonProperty("regionParentNameEn")
        private String regionParentNameEn;
        @JsonProperty("regionNameUz")
        private String regionNameUz;
        @JsonProperty("licenseTypeNameUz")
        private String licenseTypeNameUz;
        @JsonProperty("regNumber")
        private String regNumber;
        @JsonProperty("licenseTypeNameEn")
        private String licenseTypeNameEn;
        @JsonProperty("regionParentNameUz")
        private String regionParentNameUz;
        @JsonProperty("licenseStatusNameUz")
        private Object licenseStatusNameUz;
        @JsonProperty("licenseId")
        private Integer licenseId;
        @JsonProperty("email")
        private Object email;
        @JsonProperty("licenseStatusNameEn")
        private Object licenseStatusNameEn;
        @JsonProperty("longitude")
        private Object longitude;
        @JsonProperty("address")
        private String address;
        @JsonProperty("contragentName")
        private String contragentName;
        @JsonProperty("regionParentNameLt")
        private String regionParentNameLt;
        @JsonProperty("fullName")
        private String fullName;
        @JsonProperty("regionNameRu")
        private String regionNameRu;
        @JsonProperty("regionNameLt")
        private String regionNameLt;
        @JsonProperty("firstName")
        private String firstName;
        @JsonProperty("beginDate")
        private String beginDate;
        @JsonProperty("parentName")
        private String parentName;
        @JsonProperty("contragentAddress")
        private String contragentAddress;
        @JsonProperty("licenseTypeNameRu")
        private String licenseTypeNameRu;
        @JsonProperty("mobilePhone")
        private String mobilePhone;
        @JsonProperty("phone")
        private String phone;
        @JsonProperty("regionParentNameRu")
        private String regionParentNameRu;
        @JsonProperty("licenseTypeNameLt")
        private String licenseTypeNameLt;
        @JsonProperty("licenseStatusNameRu")
        private Object licenseStatusNameRu;
        @JsonProperty("licenseSerialTitle")
        private String licenseSerialTitle;
        @JsonProperty("status")
        private Object status;
        @JsonProperty("licenseStatusNameLt")
        private Object licenseStatusNameLt;

    }
}
