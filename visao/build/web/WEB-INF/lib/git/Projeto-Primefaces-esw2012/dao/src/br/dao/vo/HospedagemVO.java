/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dao.vo;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 *
 * @author Odenor
 */
@Entity
@Table(name="hospedagem")
public class HospedagemVO implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="hospedariaID")
    private HospedariaVO hospedaria;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="usuarioID")
    private UsuarioVO usuario;
    
    @Temporal(TemporalType.DATE)
    private Date diaInicio;
    
    @Temporal(TemporalType.DATE)
    private Date diaFim;
    
    @Column(length=1,nullable=false)
    private char situacao;
    
    @Column(length=400,nullable=false)
    private String comentario;

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
     * @return the hospedaria
     */
    public HospedariaVO getHospedaria() {
        return hospedaria;
    }

    /**
     * @param hospedaria the hospedaria to set
     */
    public void setHospedaria(HospedariaVO hospedaria) {
        this.hospedaria = hospedaria;
    }

    /**
     * @return the usuario
     */
    public UsuarioVO getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the diaInicio
     */
    public Date getDiaInicio() {
        return diaInicio;
    }

    /**
     * @param diaInicio the diaInicio to set
     */
    public void setDiaInicio(Date diaInicio) {
        this.diaInicio = diaInicio;
    }

    /**
     * @return the diaFim
     */
    public Date getDiaFim() {
        return diaFim;
    }

    /**
     * @param diaFim the diaFim to set
     */
    public void setDiaFim(Date diaFim) {
        this.diaFim = diaFim;
    }

    /**
     * @return the situacao
     */
    public char getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(char situacao) {
        this.situacao = situacao;
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

   
}
