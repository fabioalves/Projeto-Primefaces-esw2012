package br.dao.dao;

import br.dao.vo.GrupoVO;
import br.dao.utils.DAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.HospedariaVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


public class GrupoDAO extends DAO<GrupoVO>{
    public GrupoDAO()throws PersistenciaException{
        super(FabricaEntityManager.getEntityManager());
    }
    
    public GrupoDAO(EntityManager entityManager)throws PersistenciaException{
        super(entityManager);
    }
    
    public GrupoVO buscarPorCodigo(int codigo) throws PersistenciaException
    {
        try {
            return this.entityManager.find(GrupoVO.class,codigo);
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar o grupo");
        }
    }
    
    public List<GrupoVO> buscarTodos() throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM GrupoVO ORDER BY titulo");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar grupos.");
        }                
    }
    
    public List<GrupoVO> buscarPorNome(String titulo) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM GrupoVO WHERE titulo like "+titulo+"% ORDER BY titulo");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar grupos.");
        }        
    }
    
}
