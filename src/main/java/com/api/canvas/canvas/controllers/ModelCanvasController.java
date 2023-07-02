package com.api.canvas.canvas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.canvas.canvas.entities.ModelCanvas;
import com.api.canvas.canvas.intefaces.ICanvasModel;

@RestController
@RequestMapping("/api")
public class ModelCanvasController {

    @Autowired
    private ICanvasModel canvas_model_service;

    @GetMapping("/modelCanvas")
    public List<ModelCanvas> getModelsCanvas() {
        return canvas_model_service.findAll();
    }

    @GetMapping("/modelCanvas/{id}")
    public ResponseEntity<?> getModelCanvas(@PathVariable UUID id) {
        ModelCanvas model = null;
        Map<String, Object> response = new HashMap<>();

        try {
            model = canvas_model_service.findById(id);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (model == null) {
            response.put("Mensaje", "El modelo " + id + " no fue encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ModelCanvas>(model, HttpStatus.OK);

    }

    @PostMapping("/modelCanvas")
    public ResponseEntity<?> save(@RequestBody ModelCanvas nuevo) {
        ModelCanvas model = null;
        Map<String, Object> response = new HashMap<>();

        try {
            model = canvas_model_service.save(nuevo);
            response.put("Mensaje", "Modelo registrado con exito");
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al registrar en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @PutMapping("/modelCanvas/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody ModelCanvas data) {
        ModelCanvas actual = canvas_model_service.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (actual == null) {
            response.put("Mensaje", "El modelo " + id + " no fue encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            actual.setSegmento_mercado(data.getSegmento_mercado());
            actual.setPropuesta_valor(data.getPropuesta_valor());
            actual.setCanales(data.getCanales());
            actual.setRelaciones_clientes(data.getRelaciones_clientes());
            actual.setFuente_ingresos(data.getFuente_ingresos());
            actual.setActividades_clave(data.getActividades_clave());
            actual.setRecursos_clave(data.getRecursos_clave());
            actual.setAsociaciones_clave(data.getAsociaciones_clave());
            actual.setEstructura_costos(data.getEstructura_costos());
            canvas_model_service.save(actual);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al buscar modelo canvas");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(actual, HttpStatus.CREATED);
    }

    @DeleteMapping("/modelCanvas/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        Map<String, Object> response = new HashMap<>();

        try {
            canvas_model_service.delete(id);
            response.put("Mensaje", "modelo canvas eliminado con exito");
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al eliminar modelo canvas");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
