package br.dao.dao;

import br.dao.utils.DAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.UsuarioVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Odenor
 */
public class UsuarioDAO extends DAO<UsuarioVO> {
    
    public UsuarioDAO() throws PersistenciaException
    {
        super(FabricaEntityManager.getEntityManager());
    }
    public UsuarioDAO(EntityManager entityManager)throws PersistenciaException{
        super(entityManager);
    }
    
    public UsuarioVO buscarPorCodigo(int codigo) throws PersistenciaException
    {
        try {
            return this.entityManager.find(UsuarioVO.class,codigo);
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar o usuário");
        }
    }
    
    public UsuarioVO buscarPorEmailSenha(String email, String senha) throws PersistenciaException
    {
        try {         
            
            Query query = this.entityManager.createQuery("FROM UsuarioVO u "+
                    "WHERE u.email = :em "+ 
                    "AND u.senha = :sen");
            
            query.setParameter("em", email);
            query.setParameter("sen", senha);
            
            return (UsuarioVO) query.getSingleResult();
            
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar o usuário");
        }
    }
    
    public List<UsuarioVO> buscarTodos() throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM UsuarioVO ORDER BY nome");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar usuários.");
        }                
    }
    
    public List<UsuarioVO> buscarPorNome(String nome) throws PersistenciaException
    {
        try 
        {
            Query query=this.entityManager.createQuery("FROM UsuarioVO WHERE Nome like %"+nome+"% ORDER BY nome");
            return query.getResultList();                    
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível encontrar usuários.");
        }        
    }
            
}
