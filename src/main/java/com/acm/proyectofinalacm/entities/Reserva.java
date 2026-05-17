package com.acm.proyectofinalacm.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="reserva")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha_inicio;
    private Date fecha_final;
    private String estado;
    private double precio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habitacion",referencedColumnName = "id")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "reserva",cascade = CascadeType.ALL)
    private List<Servicio> servicios;
}
