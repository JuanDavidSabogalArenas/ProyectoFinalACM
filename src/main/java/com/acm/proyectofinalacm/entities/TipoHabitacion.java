package com.acm.proyectofinalacm.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;
    private String descripcion;
    private int capacidad;

    @OneToMany(mappedBy="tipoHabitacion",cascade=CascadeType.ALL)
    @JsonIgnore
    private List<SucursalTipoH> sucursal_tipoh;

}
