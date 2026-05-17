package com.acm.proyectofinalacm.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private double total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pago",referencedColumnName = "id")
    private Pago pago;
}

