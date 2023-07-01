package com.api.canvas.canvas.intefaces;

import java.util.List;
import java.util.UUID;

import com.api.canvas.canvas.entities.ModelCanvas;

public interface ICanvasModel {

    public List<ModelCanvas> findAll();

    public ModelCanvas findById(UUID id);

    public ModelCanvas save(ModelCanvas nuevo);

    public void delete(UUID id);
}
