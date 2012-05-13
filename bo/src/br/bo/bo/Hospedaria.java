/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bo.bo;

import br.dao.dao.HospedariaDAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.CidadeVO;
import br.dao.vo.HospedariaVO;
import java.util.List;

/**
 *
 * @author Odenor
 */
public class Hospedaria {
    private HospedariaDAO hospedariaDAO;
    
    public Hospedaria() throws NegocioException {
        try {
            hospedariaDAO=new HospedariaDAO();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar Persistência "+ex.getMessage());
        }
    }

    public void inserir(HospedariaVO hospedariaVO) throws NegocioException {

        String mensagemErros = this.validarDados(hospedariaVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            hospedariaDAO.iniciarTransacao();
            hospedariaDAO.incluir(hospedariaVO);
            hospedariaDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao incluir uma nova hospedaria - " + ex.getMessage());
        }
    }

    public void alterar(HospedariaVO hospedariaVO) throws NegocioException {

        String mensagemErros = this.validarDados(hospedariaVO);
        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }
        try {
           hospedariaDAO.alterar(hospedariaVO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao alterar o grupo de produto - " + ex.getMessage());
        }
    }

    public void excluir(HospedariaVO HospedariaVO) throws NegocioException {
        try {
           hospedariaDAO.excluir(HospedariaVO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao excluir o grupo de produto - " + ex.getMessage());
        }
    }

    public HospedariaVO buscarPorCodigo(int codigo) throws NegocioException{
        try {
            return hospedariaDAO.buscarPorCodigo(codigo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro na seleção por codigo - "+ex.getMessage());
        }
    }
    
    public List<HospedariaVO> buscarPorNomeCidade(CidadeVO cidadeVO) throws NegocioException{
        try {
            return hospedariaDAO.buscarPorNomeCidade(cidadeVO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro na seleção por codigo - "+ex.getMessage());
        }
    }

    public List<HospedariaVO> buscarTodos() throws NegocioException {
        try {
            return hospedariaDAO.buscarTodos();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro na seleção por codigo - "+ex.getMessage());
        }
    }

    private String validarDados(HospedariaVO hospedariaVO) {

        String mensagemErros = "";

        if (hospedariaVO.getNome().length() == 0) {
            mensagemErros += "Nome não pode ser vazio";
        }
        
        if (hospedariaVO.getLocalizacaoGeografica().length() == 0) {
            mensagemErros += "Localização não pode ser vazio";
        }        
        
        return mensagemErros;
    }        
}
