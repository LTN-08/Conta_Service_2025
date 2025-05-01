package com.example.Conta_Service_2025.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Pix {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @Column
    private LocalDateTime createdAt;

    @Column
    private String chavePixPagador;

    @Column
    private String chavePixRecebedor;

    @Column
    private BigDecimal valor;

    @Column(unique = true)
    private String idemPotencia;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
}
