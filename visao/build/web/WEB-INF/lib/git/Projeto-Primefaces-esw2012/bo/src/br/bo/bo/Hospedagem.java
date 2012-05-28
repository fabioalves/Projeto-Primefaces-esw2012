/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bo.bo;


import br.dao.dao.HospedagemDAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.HospedagemVO;
import br.dao.vo.HospedariaVO;
import br.dao.vo.UsuarioVO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class Hospedagem {
    private HospedagemDAO hospedagemDAO;
    
    public Hospedagem() throws NegocioException {
        try {
            hospedagemDAO = new HospedagemDAO();            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar Persistência "+ex.getMessage());
        }
    }
    
    public List<HospedagemVO> buscarHospedagemPorUsuario(UsuarioVO usuarioVO) throws PersistenciaException {
        return this.hospedagemDAO.getListHospedagemPorUsuario(usuarioVO);
    }
    
    public List<HospedagemVO> buscarHospedagemPorHospedaria(HospedariaVO hospedariaVO) throws PersistenciaException {
        return this.hospedagemDAO.getListHospedagemPorHospedaria(hospedariaVO);
    }
    
    public void reservar(HospedagemVO hospedagemVO) throws NegocioException {
        try {
            this.hospedagemDAO.iniciarTransacao();
            this.hospedagemDAO.incluir(hospedagemVO);
            this.hospedagemDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
    public void atualizar(HospedagemVO hospedagemVO) throws NegocioException {
        try {
            this.hospedagemDAO.iniciarTransacao();
            this.hospedagemDAO.alterar(hospedagemVO);
            this.hospedagemDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
    public HospedagemVO buscarHospedagemPorCodigo(int codigo) throws NegocioException {
        try {
            return this.hospedagemDAO.getHospedagemPorCodigo(codigo);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
}
