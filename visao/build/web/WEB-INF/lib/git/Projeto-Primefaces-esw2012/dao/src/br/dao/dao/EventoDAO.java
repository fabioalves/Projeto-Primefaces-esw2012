package br.dao.dao;

import br.dao.vo.EventoVO;
import br.dao.utils.DAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class EventoDAO extends DAO<EventoVO>{
    
    public EventoDAO()throws PersistenciaException{
        super(FabricaEntityManager.getEntityManager());
    }
    
    public EventoDAO(EntityManager entityManager)throws PersistenciaException{
        super(entityManager);
    }
    
    public EventoVO buscarPorCodigo(int codigo) throws PersistenciaException
    {
        try {
            return this.entityManager.find(EventoVO.class,codigo);
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar o grupo");
        }
    }
    
    public List<EventoVO> buscarTodos() throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM EventoVO ORDER BY titulo");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar eventos.");
        }                
    }
    
    public List<EventoVO> buscarPorNome(String titulo) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM EventoVO WHERE titulo like "+titulo+"% ORDER BY titulo");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar eventos.");
        }        
    }
    
    public List<EventoVO> buscarPorData(Date data) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM EventoVO WHERE diaHoraInicio = "+data+"% ORDER BY titulo");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar eventos.");
        }        
    }
    
}
