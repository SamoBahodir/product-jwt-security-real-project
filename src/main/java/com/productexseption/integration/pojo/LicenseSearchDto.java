package com.productexseption.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenseSearchDto {

    private Integer perPage = 10;
    private Integer page = 0;
    private String name;
    private String tin;
    private Long pin;
    private String number;
    @JsonProperty("document_type")
    private String documentType;
    @JsonProperty("document_id")
    private Long documentId;

}
