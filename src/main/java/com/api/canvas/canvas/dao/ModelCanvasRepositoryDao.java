package com.api.canvas.canvas.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.canvas.canvas.entities.ModelCanvas;

public interface ModelCanvasRepositoryDao extends JpaRepository<ModelCanvas, UUID> {

}
