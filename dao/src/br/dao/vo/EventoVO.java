package br.dao.vo;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="evento")
public class EventoVO {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    @Column(length=100,nullable=false)
    private String titulo;
    @Column(length=400,nullable=false)
    private String descricao;
    @Temporal(TemporalType.DATE)
    private Date diaHoraInicio;
    @Temporal(TemporalType.DATE)
    private Date diaHoraFim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDiaHoraInicio() {
        return diaHoraInicio;
    }

    public void setDiaHoraInicio(Date diaHoraInicio) {
        this.diaHoraInicio = diaHoraInicio;
    }

    public Date getDiaHoraFim() {
        return diaHoraFim;
    }

    public void setDiaHoraFim(Date diaHoraFim) {
        this.diaHoraFim = diaHoraFim;
    }
}
