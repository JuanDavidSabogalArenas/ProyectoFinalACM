package com.acm.proyectofinalacm.service;


import com.acm.proyectofinalacm.entities.TipoHabitacion;
import com.acm.proyectofinalacm.repositories.TipoHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoHService {
    private TipoHRepository tipoHRepository;

    @Autowired
    public TipoHService(TipoHRepository tipoHRepository) {
        this.tipoHRepository = tipoHRepository;
    }

    //Crear un tipo de Habitacion
    public TipoHabitacion crearTipoH(TipoHabitacion tipoHabitacion){
        return tipoHRepository.save(tipoHabitacion);
    }
    //Encontrar tipo de Habitacion por id

    public TipoHabitacion findbyId(Integer id){
        return tipoHRepository.findById(id).orElse(null);
    }

    //Eliminar tipo de Habitacion por id
    public TipoHabitacion deletebyId(Integer id){
        return  tipoHRepository.findById(id).map(
                tipoHabitacion -> {tipoHRepository.delete(tipoHabitacion);
        return tipoHabitacion;
        }).orElse(null);
    }
    //Metodo para actualizar un tipo de cuarto
    public TipoHabitacion updateTipoH(Integer id,TipoHabitacion tipoHabitacion){
        TipoHabitacion tipoHabitacionExistente=tipoHRepository.findById(id).orElseThrow(()->new RuntimeException("TipoHabitacion no encontrado con id "+id));
        tipoHabitacionExistente.setDescripcion(tipoHabitacion.getDescripcion());
        tipoHabitacionExistente.setCapacidad(tipoHabitacion.getCapacidad());
        return tipoHRepository.save(tipoHabitacionExistente);
    }
}
