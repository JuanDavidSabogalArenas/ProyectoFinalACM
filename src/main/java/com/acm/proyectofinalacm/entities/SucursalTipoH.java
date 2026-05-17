package com.acm.proyectofinalacm.entities;

import com.acm.proyectofinalacm.embedableClass.SucursalTipoHId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="sucursal_tipoh")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalTipoH {
    @EmbeddedId
    private SucursalTipoHId id;

    @ManyToOne
    @MapsId("sucursalId")
    @JoinColumn(name="sucursal_id")
    private Sucursal sucursal;

    @ManyToOne
    @MapsId("tipoHabitacionId")
    @JoinColumn(name="tipoHabitacion_id")
    private TipoHabitacion tipoHabitacion;

    private double precio;
    private Integer cantidad;

}
