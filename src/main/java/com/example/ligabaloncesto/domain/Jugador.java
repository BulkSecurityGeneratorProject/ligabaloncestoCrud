package com.example.ligabaloncesto.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.example.ligabaloncesto.domain.util.CustomLocalDateSerializer;
import com.example.ligabaloncesto.domain.util.ISO8601LocalDateDeserializer;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A Jugador.
 */
@Entity
@Table(name = "JUGADOR")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "nombre")
    private String nombre;
    
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    @JsonDeserialize(using = ISO8601LocalDateDeserializer.class)
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    
    @Column(name = "canastas_totales")
    private Integer canastasTotales;
    
    @Column(name = "rebotes_totales")
    private Integer rebotesTotales;
    
    @Column(name = "asistencias_totales")
    private Integer asistenciasTotales;
    
    @Column(name = "posicion_campo")
    private String posicionCampo;

    @ManyToOne
    private Equipo equipo;

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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getCanastasTotales() {
        return canastasTotales;
    }

    public void setCanastasTotales(Integer canastasTotales) {
        this.canastasTotales = canastasTotales;
    }

    public Integer getRebotesTotales() {
        return rebotesTotales;
    }

    public void setRebotesTotales(Integer rebotesTotales) {
        this.rebotesTotales = rebotesTotales;
    }

    public Integer getAsistenciasTotales() {
        return asistenciasTotales;
    }

    public void setAsistenciasTotales(Integer asistenciasTotales) {
        this.asistenciasTotales = asistenciasTotales;
    }

    public String getPosicionCampo() {
        return posicionCampo;
    }

    public void setPosicionCampo(String posicionCampo) {
        this.posicionCampo = posicionCampo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Jugador jugador = (Jugador) o;

        if ( ! Objects.equals(id, jugador.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + "'" +
                ", fechaNacimiento='" + fechaNacimiento + "'" +
                ", canastasTotales='" + canastasTotales + "'" +
                ", rebotesTotales='" + rebotesTotales + "'" +
                ", asistenciasTotales='" + asistenciasTotales + "'" +
                ", posicionCampo='" + posicionCampo + "'" +
                '}';
    }
}
