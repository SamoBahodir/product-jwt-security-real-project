package com.productexseption.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessDataIterable<T> {
    private Integer status;
    private ResponseMessage message;
    private List<T> data;
    private int totalPages;
    private long totalCount;
    private int size;
    private int page;

    public SuccessDataIterable(Page<T> objects) {
        this.status = 0;
        this.message = new ResponseMessage();
        this.data = new ArrayList<>();
        objects.forEach(this.data::add);
        this.totalPages = objects.getTotalPages();
        this.totalCount = objects.getTotalElements();
        this.size = objects.getSize();
        this.page = objects.getNumber();
    }

    public SuccessDataIterable(Iterable<T> objects) {
        this.data = new ArrayList<>();
        objects.forEach(this.data::add);
        if (objects instanceof Page<?> page) {
            this.page = page.getNumber();
            this.size = page.getSize();
            this.totalCount = page.getTotalElements();
            this.page = page.getTotalPages();
        }
    }

}
