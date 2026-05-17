package com.acm.proyectofinalacm.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="sucursal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String email;
    private String categoria;
    private String estado;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "sucursal", cascade=CascadeType.ALL)
    private List<Habitacion> habitaciones;

    @OneToMany(mappedBy = "sucursal",cascade = CascadeType.ALL)
    private List<Empleado> empleados;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="administrador",referencedColumnName = "id")
    private Administrador administrador;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<Servicio> servicios;

}
