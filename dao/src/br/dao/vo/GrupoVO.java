package br.dao.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="grupo")
public class GrupoVO implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    
    @Column(length=100,nullable=false)
    private String titulo;
    
    @OneToMany(fetch= FetchType.EAGER)
    private List<ModuloVO> listaModuloVO;


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


    public List<ModuloVO> getListaModuloVO() {
        return listaModuloVO;
    }


    public void setListaModuloVO(List<ModuloVO> listaModuloVO) {
        this.listaModuloVO = listaModuloVO;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
        {
            return false;
        }
        if(getClass()!=obj.getClass())
        {
            return false;
        }
        
        final GrupoVO other=(GrupoVO)obj;
        if(this.id!=other.id)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        return hash;
    }
    
}

