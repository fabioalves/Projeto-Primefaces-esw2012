/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dao.vo;

import javax.persistence.*;

/**
 *
 * @author Odenor
 */
@Entity
@Table(name="galeriafotos")
public class GaleriaFotosVO {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    @Column(length=50,nullable=false)
    private String titulo;
    @Column(length=100,nullable=false)
    private String foto;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private HospedariaVO hospedaria;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
}
