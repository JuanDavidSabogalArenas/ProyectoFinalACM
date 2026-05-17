package com.acm.proyectofinalacm.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="tipo_habitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private int capacidad;

    @OneToMany(mappedBy = "tipo_habitacion",cascade=CascadeType.ALL)
    private List<SucursalTipoH> sucursal_tipoh;

}
