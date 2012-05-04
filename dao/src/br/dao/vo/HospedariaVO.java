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
@Table(name="hospedaria")
public class HospedariaVO 
{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    @Column(length=100,nullable=false)
    private String nome;
    @Column(length=150,nullable=false)
    private String endereco;
    @Column(length=50,nullable=false)
    private String bairro;
    @ManyToOne(fetch= FetchType.EAGER)
    private CidadeVO cidade;
    @Column(length=15,nullable=false)
    private String cep;
    @Column(length=10,nullable=false)
    private String telefone;
    @Column(length=10,nullable=false)
    private String celular;
    @Column(length=100,nullable=false)
    private String localizacaoGeografica;
    @Column(nullable=false,precision=5,scale=2)
    private float valorDiaria;

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
     * @return the cidade
     */
    public CidadeVO getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(CidadeVO cidade) {
        this.cidade = cidade;
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
     * @return the localizacaoGeografica
     */
    public String getLocalizacaoGeografica() {
        return localizacaoGeografica;
    }

    /**
     * @param localizacaoGeografica the localizacaoGeografica to set
     */
    public void setLocalizacaoGeografica(String localizacaoGeografica) {
        this.localizacaoGeografica = localizacaoGeografica;
    }

    /**
     * @return the valorDiaria
     */
    public float getValorDiaria() {
        return valorDiaria;
    }

    /**
     * @param valorDiaria the valorDiaria to set
     */
    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
