package br.com.billinterest.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CalculationBillRequest {

    @NotNull
    private String code;
    @NotNull
    @JsonProperty("data_pagamento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate payDay;
}
