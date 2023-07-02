package com.api.canvas.canvas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

}
