package com.acm.proyectofinalacm.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pago")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double monto;
    private String estado;
    private String tipo;
    private String fecha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reserva",referencedColumnName = "id")
    private Reserva reserva;
}
