package com.acm.proyectofinalacm.embedableClass;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class SucursalTipoHId implements Serializable {
    private Integer sucursalId;
    private Integer tipoHabitacionId;
}
