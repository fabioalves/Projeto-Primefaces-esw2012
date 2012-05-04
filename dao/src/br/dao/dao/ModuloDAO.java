package br.dao.dao;

import br.dao.utils.DAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.ModuloVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class ModuloDAO extends DAO<ModuloVO>{
   
    public ModuloDAO() throws PersistenciaException {
        super(FabricaEntityManager.getEntityManager());
    }
    
    public ModuloDAO(EntityManager entityManager) throws PersistenciaException {
        super(entityManager);
    }
    
    public ModuloVO buscarPorCodigo(int codigo) throws PersistenciaException {
        try{
             return this.entityManager.find(ModuloVO.class, codigo);
        }catch(PersistenceException e) {
            throw  new PersistenciaException("Não foi possivel encontrar módulo");
        }
    }
    
    public List<ModuloVO> buscarTodos() throws PersistenciaException {
        try{
            Query query=this.entityManager.createQuery("FROM ModuloVO ORDER BY titulo");
            return query.getResultList();      
        }catch (PersistenceException e){
            throw new PersistenciaException("Não foi possivel encontrar modulos");
        }
    }
    
    public List<ModuloVO> buscarPorNome(String titulo) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM ModuloVO WHERE Nome like "+titulo+"% ORDER BY titulo");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar modulos.");
        }        
    }    
    
}
