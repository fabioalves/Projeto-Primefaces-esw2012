package br.dao.utils;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;

public class DAO<VO> {

    protected EntityManager entityManager;

    public DAO(EntityManager entityManager) throws PersistenciaException {
        this.entityManager = entityManager;
    }
    
   public void incluir(VO vo) throws PersistenciaException {
      this.entityManager.persist(vo);
   }
   public void alterar(VO vo) throws PersistenciaException{
      this.entityManager.merge(vo);
   }
   public void excluir(VO vo) throws PersistenciaException{
      this.entityManager.remove(vo);
   }
   public void iniciarTransacao() throws PersistenciaException{
      this.entityManager.getTransaction().begin();
   }
   public void confirmarTransacao() throws PersistenciaException {
       try {
           this.entityManager.getTransaction().commit();
       } catch (HibernateException he){
           he.printStackTrace();  
    
       } catch (Exception e) {
           e.printStackTrace();
       }
         
    }  

      

   public void cancelarTransacao() throws PersistenciaException{
      this.entityManager.getTransaction().rollback();
   }
}
