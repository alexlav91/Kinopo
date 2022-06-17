package ru.lop.kinopo.model.dto;

import lombok.Data;

@Data
public class APIResponse<T> {

    int recordCount;
    T response;

    public APIResponse() {
    }

    public APIResponse(int recordCount, T response) {
        this.recordCount = recordCount;
        this.response = response;
    }
}
