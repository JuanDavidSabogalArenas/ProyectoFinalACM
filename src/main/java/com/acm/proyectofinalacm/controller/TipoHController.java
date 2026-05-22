package com.acm.proyectofinalacm.controller;

import com.acm.proyectofinalacm.entities.TipoHabitacion;
import com.acm.proyectofinalacm.service.TipoHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("apiacm/tipoh")
public class TipoHController {
    private TipoHService tipoHService;
    @Autowired
    public TipoHController(TipoHService tipoHService) {
        this.tipoHService = tipoHService;
    }

    @PostMapping("/create-tipoh")
    public ResponseEntity<TipoHabitacion> saveTipoHabitacion(@RequestBody TipoHabitacion tipoHabitacion) {
        TipoHabitacion tipoHabitacionExistente = tipoHService.crearTipoH(tipoHabitacion);
        return ResponseEntity.ok(tipoHabitacionExistente);
    }
    @GetMapping("/findbyId/{id}")
    public ResponseEntity<TipoHabitacion> findById(@PathVariable Integer id) {
        TipoHabitacion tipoHEncontrado= tipoHService.findbyId(id);
        if (tipoHEncontrado!=null){
            return ResponseEntity.ok(tipoHEncontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/deletebyId/{id}")
    public ResponseEntity<TipoHabitacion> deleteById(@PathVariable Integer id) {
        TipoHabitacion tipoHEliminado= tipoHService.deletebyId(id);
        if  (tipoHEliminado!=null){
            return ResponseEntity.ok(tipoHEliminado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update-tipoh/{id}")
    public ResponseEntity<TipoHabitacion> updateTipoH(@PathVariable Integer id, @RequestBody TipoHabitacion tipoHabitacion) {
        try{
            TipoHabitacion tipoHActualizado= tipoHService.updateTipoH(id,tipoHabitacion);
            return ResponseEntity.ok(tipoHActualizado);
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
