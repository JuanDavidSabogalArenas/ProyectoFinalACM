package com.acm.proyectofinalacm.repositories;


import com.acm.proyectofinalacm.entities.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHRepository extends JpaRepository<TipoHabitacion,Integer> {
}
