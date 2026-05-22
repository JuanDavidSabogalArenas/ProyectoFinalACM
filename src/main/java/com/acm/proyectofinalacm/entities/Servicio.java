package com.acm.proyectofinalacm.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servicio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private double precio;


    @ManyToOne
    @JoinColumn(name="reserva_id")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name="sucursal_id")
    private Sucursal sucursal;
}
