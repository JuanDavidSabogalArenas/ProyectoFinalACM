package com.acm.proyectofinalacm.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String telefono;
    private String correo;
    private String rol;

    @ManyToOne
    @JoinColumn(name="sucursal_id")
    private Sucursal sucursal;
}
