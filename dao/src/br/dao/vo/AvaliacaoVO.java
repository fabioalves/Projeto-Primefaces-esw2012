/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dao.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Odenor
 */
@Entity
@Table(name="avaliacao")
public class AvaliacaoVO implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="hospedagemID", nullable=false)
    private HospedagemVO hospedagem;

    @Column(length=1,nullable=false)
    private char avaliado;       // U=usuario / H=hospedaria
    
    @Column(length=11,nullable=false)
    private int nota;            // 1=Péssimo / 2=Ruim / 3=Regular / 4=Bom / 5=Ótimo
    
    @Column(length=400,nullable=false)
    private String comentario;
    
    @Column(length=1,nullable=false)
    private char status;            // A=avaliado / C=censurado

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
     * @return the hospedagemVO
     */
    public HospedagemVO getHospedagem() {
        return hospedagem;
    }

    /**
     * @param hospedagemVO the hospedagemVO to set
     */
    public void setHospedagem(HospedagemVO hospedagem) {
        this.hospedagem = hospedagem;
    }

    /**
     * @return the avaliado
     */
    public char getAvaliado() {
        return avaliado;
    }

    /**
     * @param avaliado the avaliado to set
     */
    public void setAvaliado(char avaliado) {
        this.avaliado = avaliado;
    }

    /**
     * @return the nota
     */
    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }
    
    
}
