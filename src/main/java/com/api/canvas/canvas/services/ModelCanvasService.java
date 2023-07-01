package com.api.canvas.canvas.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.canvas.canvas.entities.ModelCanvas;
import com.api.canvas.canvas.intefaces.ICanvasModel;

@Service
public class ModelCanvasService implements ICanvasModel {

    @Override
    public List<ModelCanvas> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ModelCanvas findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ModelCanvas save(ModelCanvas nuevo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
