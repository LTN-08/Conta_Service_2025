package com.example.Conta_Service_2025.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
public class ContaRequestDTO {
    @NotNull
    private String nomeTitular;
    @NotNull
    private Integer numeroAgencia;
    @NotNull
    private Integer numeroConta;
    @NotEmpty
    private String chavePix;

}
