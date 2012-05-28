package br.dao.dao;

import br.dao.vo.GaleriaFotosVO;
import br.dao.utils.DAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
//import br.dao.vo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


public class GaleriaFotosDAO extends DAO<GaleriaFotosVO>{
    public GaleriaFotosDAO()throws PersistenciaException{
        super(FabricaEntityManager.getEntityManager());
    }
    
    public GaleriaFotosDAO(EntityManager entityManager)throws PersistenciaException{
        super(entityManager);
    }
    
    public GaleriaFotosVO buscarPorCodigo(int codigo) throws PersistenciaException
    {
        try {
            return this.entityManager.find(GaleriaFotosVO.class,codigo);
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar as fotos");
        }
    }
    
    public List<GaleriaFotosVO> buscarTodos() throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM GaleriaFotosVO ORDER BY titulo");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar as fotos.");
        }                
    }
    
    public List<GaleriaFotosVO> buscarPorNome(String titulo) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM GaleriaFotosVO WHERE titulo like "+titulo+"% ORDER BY titulo");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar as fotos.");
        }        
    }
    
}
