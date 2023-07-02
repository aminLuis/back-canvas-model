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

    // @Column(nullable = false)
    private String segmento_mercado;

    private Double propuesta_valor;

    private String canales;

    private String relaciones_clientes;

    private String fuente_ingresos;

    private String actividades_clave;

    private String recursos_clave;

    private String asociaciones_clave;

    private String estructura_costos;

    public void setSegmento_mercado(String segmento_mercado) {
        this.segmento_mercado = segmento_mercado;
    }

    public String getSegmento_mercado() {
        return segmento_mercado;
    }

    public void setPropuesta_valor(Double propuesta_valor) {
        this.propuesta_valor = propuesta_valor;
    }

    public Double getPropuesta_valor() {
        return propuesta_valor;
    }

    public void setCanales(String canales) {
        this.canales = canales;
    }

    public String getCanales() {
        return canales;
    }

    public void setRelaciones_clientes(String relaciones_clientes) {
        this.relaciones_clientes = relaciones_clientes;
    }

    public String getRelaciones_clientes() {
        return relaciones_clientes;
    }

    public void setFuente_ingresos(String fuente_ingresos) {
        this.fuente_ingresos = fuente_ingresos;
    }

    public String getFuente_ingresos() {
        return fuente_ingresos;
    }

    public void setActividades_clave(String actividades_clave) {
        this.actividades_clave = actividades_clave;
    }

    public String getActividades_clave() {
        return actividades_clave;
    }

    public void setRecursos_clave(String recursos_clave) {
        this.recursos_clave = recursos_clave;
    }

    public String getRecursos_clave() {
        return recursos_clave;
    }

    public void setAsociaciones_clave(String asociaciones_clave) {
        this.asociaciones_clave = asociaciones_clave;
    }

    public String getAsociaciones_clave() {
        return asociaciones_clave;
    }

    public void setEstructura_costos(String estructura_costos) {
        this.estructura_costos = estructura_costos;
    }

    public String getEstructura_costos() {
        return estructura_costos;
    }
}
