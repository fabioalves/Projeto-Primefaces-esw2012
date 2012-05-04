package br.dao.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="modulo")
public class ModuloVO implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    
    @Column(length=100,nullable=false)
    private String titulo;

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
    
    @ManyToOne(fetch= FetchType.EAGER)
    private GrupoVO grupo;
    
   @Override
   public int hashCode() {
      int hash = 7;
      hash = 41 * hash + this.id;
      return hash;
   }    
   
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final ModuloVO other = (ModuloVO) obj;
      if (this.id != other.id) {
         return false;
      }
      return true;
   }

    /**
     * @return the grupo
     */
    public GrupoVO getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(GrupoVO grupo) {
        this.grupo = grupo;
    }
    
}
