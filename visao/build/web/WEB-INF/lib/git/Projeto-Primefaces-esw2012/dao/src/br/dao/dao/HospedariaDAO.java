/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dao.dao;

import br.dao.utils.DAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.CidadeVO;
import br.dao.vo.HospedariaVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Odenor
 */
public class HospedariaDAO extends DAO<HospedariaVO> {
    
    public HospedariaDAO()throws PersistenciaException{
        super(FabricaEntityManager.getEntityManager());
    }
    public HospedariaDAO(EntityManager entityManager)throws PersistenciaException{
        super(entityManager);
    }
    
    public HospedariaVO buscarPorCodigo(int codigo) throws PersistenciaException
    {
        try {
            return this.entityManager.find(HospedariaVO.class,codigo);
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar as hospedarias");
        }
    }

    public List<HospedariaVO> buscarPorNomeCidade(String nomeCidade) throws PersistenciaException
    {
        try {
            Query query=this.entityManager.createQuery("FROM HospedariaVO h "+
                    "WHERE LOWER(h.cidade.nome) like :nm ORDER BY nome");
            query.setParameter("nm", nomeCidade.toLowerCase());

            return query.getResultList();
                       
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar as hospedarias");
        }
    }
    
    public List<HospedariaVO> buscarTodos() throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM HospedariaVO ORDER BY Nome");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar as hospedarias.");
        }                
    }
    public List<HospedariaVO> buscarPorAnfitriao(int usuarioID) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM HospedariaVO h "+ 
                    "WHERE h.usuarioVO.id = :usid ORDER BY Nome");
            query.setParameter("usid", usuarioID);
            
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar as hospedarias.");
        }                
    }
    
    
    public List<HospedariaVO> buscarPorNome(String nome) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM HospedariaVO WHERE Nome like :nm ORDER BY nome");
            query.setParameter("nm", nome);
            
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar as hospedarias.");
        }        
    }
            
}
