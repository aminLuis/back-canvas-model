package com.api.canvas.canvas.entities;

import java.util.UUID;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "model_canvas")
@EntityListeners(AuditingEntityListener.class)
public class ModelCanvas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String segmento_mercado;

    // private Double propuesta_valor;

    // private String canales;

    // private String relaciones_clientes;

    // private String fuente_ingresos;

    // private String actividades_clave;

    // private String recursos_clave;

    // private String asociaciones_clave;

    // private String estructura_costos;

    public void setSegmento_mercado(String segmento_mercado) {
        this.segmento_mercado = segmento_mercado;
    }

    public String getSegmento_mercado() {
        return segmento_mercado;
    }

}
