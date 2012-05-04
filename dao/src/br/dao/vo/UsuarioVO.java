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
@Table(name="usuario")
public class UsuarioVO 
{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    
    @Column(length=100,nullable=false)
    private String nome;
    
    @Column(length=150,nullable=false)
    private String email;
    
    @Column(length=50,nullable=false)
    private String senha;
    
    @Column(length=100,nullable=false)
    private String endereco;
    
    @Column(length=50,nullable=false)
    private String bairro;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private CidadeVO cidadeVO;
    
    @Column(length=50,nullable=false)
    private String cep;
    
    @Column(length=10,nullable=false)
    private String telefone;
    
    @Column(length=15,nullable=false)
    private String celular;
    
    @Column(length=100,nullable=false)
    private String foto;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private GrupoVO grupo;

    
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
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



    /**
     * @return the cidadeVO
     */
    public CidadeVO getCidadeVO() {
        return cidadeVO;
    }

    /**
     * @param cidadeVO the cidadeVO to set
     */
    public void setCidadeVO(CidadeVO cidadeVO) {
        this.cidadeVO = cidadeVO;
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
