/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dao.dao;

import br.dao.utils.DAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.HospedagemVO;
import br.dao.vo.UsuarioVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author fabio
 */
public class HospedagemDAO extends DAO<HospedagemDAO> {
    
    public HospedagemDAO()throws PersistenciaException{
        super(FabricaEntityManager.getEntityManager());
    }
    
    public HospedagemDAO(EntityManager entityManager)throws PersistenciaException{
        super(entityManager);
    }
    
    public HospedagemVO getHospedagemPorCodigo(int codigo) throws PersistenciaException
    {
        try {            
            return this.entityManager.find(HospedagemVO.class, codigo);            
        } catch(PersistenceException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
    
    
    public List<HospedagemVO> getListHospedagemPorUsuario(UsuarioVO usuarioVO) throws PersistenciaException
    {
        try {
            Query query=this.entityManager.createQuery("FROM HospedagemVO hospedagem WHERE hospedagem.Usuario.getId() = :idusuario");
            query.setParameter("idusuario", usuarioVO.getId());
            return query.getResultList();     
        
        } catch(PersistenceException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
    
    
}
