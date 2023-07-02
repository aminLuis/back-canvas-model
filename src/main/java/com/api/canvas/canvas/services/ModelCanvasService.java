package com.api.canvas.canvas.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.canvas.canvas.dao.ModelCanvasRepositoryDao;
import com.api.canvas.canvas.entities.ModelCanvas;
import com.api.canvas.canvas.intefaces.ICanvasModel;

@Service
public class ModelCanvasService implements ICanvasModel {

    @Autowired
    private ModelCanvasRepositoryDao model_canvas_dao;

    @Override
    public List<ModelCanvas> findAll() {
        return (List<ModelCanvas>) model_canvas_dao.findAll();
    }

    @Override
    public ModelCanvas findById(UUID id) {
        return model_canvas_dao.findById(id).orElseThrow(null);
    }

    @Override
    public ModelCanvas save(ModelCanvas nuevo) {
        return model_canvas_dao.save(nuevo);
    }

    @Override
    public void delete(UUID id) {
        model_canvas_dao.deleteById(id);
    }

}
