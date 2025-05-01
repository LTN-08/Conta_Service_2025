package com.example.Conta_Service_2025.controller;


import com.example.Conta_Service_2025.dto.ContaDTO;
import com.example.Conta_Service_2025.dto.ContaRequestDTO;
import com.example.Conta_Service_2025.dto.ContaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Conta_Service_2025.service.ContaService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/contas")
@RequiredArgsConstructor
@Tag(name = "Conta Service", description = "APIs para gerenciamento de contas")
public class ContaController {
    private final ContaService contaService;

    @Operation(summary = "Criar uma nova conta")
    @PostMapping
    public ResponseEntity<ContaResponseDTO> conta(@RequestBody @Valid ContaRequestDTO contaRequestDTO) throws Exception {
        ContaResponseDTO contaResponseDTO = contaService.criarConta(contaRequestDTO);
        return new ResponseEntity<>(contaResponseDTO, CREATED);
    }

    @Operation(summary = "Atualizar uma conta existente")
    @PutMapping("/{id}")
    public ResponseEntity<ContaResponseDTO> atualizarConta(@RequestBody @Valid ContaRequestDTO contaRequestDTO, @PathVariable UUID id) throws Exception {
        ContaResponseDTO contaResponseDTO = contaService.atualizarConta(contaRequestDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(contaResponseDTO);
    }

    @Operation(summary = "Buscar uma conta pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> conta(@PathVariable UUID id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.buscaContaById(id));
    }
    @Operation(summary = "Buscar todas as contas")
    @GetMapping
    public ResponseEntity<List<ContaDTO>> contas(){
       return ResponseEntity.status(HttpStatus.OK).body(contaService.buscaTodasContas());

    }
    @Operation(summary = "Deletar uma conta pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConta(@PathVariable UUID id){
        contaService.deletarConta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
