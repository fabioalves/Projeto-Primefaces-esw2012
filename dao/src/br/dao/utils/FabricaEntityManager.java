/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dao.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author Odenor
 */
public class FabricaEntityManager {
    private static EntityManagerFactory emf=null;
    
    static{ emf= Persistence.createEntityManagerFactory("daoPU"); }
    
    public static EntityManager getEntityManager() throws PersistenceException{
        if(emf==null)
        {
            throw new PersistenceException("Unidade de Persistência não iniciada");
        }
        return emf.createEntityManager();
    }
            
}
