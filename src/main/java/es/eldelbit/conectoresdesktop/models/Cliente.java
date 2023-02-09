/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.eldelbit.conectoresdesktop.models;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author virtualbox
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private Long id;

    private String nombre;

    private Integer edad;

    private String direccion;

    @Column(name = "fecha_nacimiento")
    @SerializedName("fecha_nacimiento")
    private Timestamp fechaNacimiento;

    @Column(name = "created_at", insertable = false, updatable = false)
    @SerializedName("created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    @SerializedName("updated_at")
    private Timestamp updatedAt;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, Integer edad, String direccion, Timestamp fechaNacimiento, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Timestamp FechaNacimiento) {
        this.fechaNacimiento = FechaNacimiento;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
