package br.dao.dao;

import br.dao.utils.DAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.CidadeVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
        

public class CidadeDAO extends DAO<CidadeVO>{
    
    public CidadeDAO()throws PersistenciaException{
        super(FabricaEntityManager.getEntityManager());
    }
    
    public CidadeDAO(EntityManager entityManager)throws PersistenciaException{
        super(entityManager);
    }
    
    public CidadeVO buscarPorCodigo(int codigo) throws PersistenciaException{
        try{
            return this.entityManager.find(CidadeVO.class, codigo);
        }catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar a cidade");
        }
    }
    
    public List<CidadeVO> buscarTodos() throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM CidadeVO ORDER BY nome");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar cidades.");
        }                
    }
    
    public List<CidadeVO> buscarPorNome(String nome) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM CidadeVO WHERE Nome like "+nome+"% ORDER BY nome");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar cidades.");
        }        
    }
    
    public List<CidadeVO> buscarPorUF(String uf) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM CidadeVO WHERE Uf = "+uf+" ORDER BY Uf");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar cidades.");
        }        
    }
    
}
