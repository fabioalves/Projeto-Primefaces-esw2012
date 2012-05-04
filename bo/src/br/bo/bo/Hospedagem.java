/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bo.bo;


import br.dao.dao.HospedagemDAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.HospedagemVO;
import br.dao.vo.UsuarioVO;
import java.util.List;

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
    
}
