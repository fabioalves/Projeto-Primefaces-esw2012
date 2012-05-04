/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dao.dao;
import br.dao.utils.DAO;
import br.dao.vo.AvaliacaoVO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.HospedagemVO;
import br.dao.vo.HospedariaVO;
import br.dao.vo.UsuarioVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jivago
 */
public class AvaliacaoDAO extends DAO<AvaliacaoVO>{
    public AvaliacaoDAO() throws PersistenciaException{
        super(FabricaEntityManager.getEntityManager());
    }
    
    public AvaliacaoDAO(EntityManager entityManager) throws PersistenciaException{
        super(entityManager);
    }
    
    public AvaliacaoVO BuscarPorCodigo(int codigo) throws PersistenciaException{
        try {
            return this.entityManager.find(AvaliacaoVO.class, codigo);
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível encontrar a Avaliação!"); 
        }
    }
    
    public List<AvaliacaoVO> BuscarPorHospedagem(HospedagemVO vo) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("FROM AvaliacaoVO a WHERE a.hospedagem = :param");
            query.setParameter("param", vo );
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Avaliação por Hospedagem");
        }
    }
    
    public List<AvaliacaoVO> BuscarPorUsuario(UsuarioVO vo) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("FROM AvaliacaoVO a WHERE a.avaliado='U' AND a.hospedagem.usuario = :param");
            query.setParameter("param", vo );
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Avaliação por Usuario");
        }
    }

    public List<AvaliacaoVO> BuscarPorHospedaria(HospedariaVO vo) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("FROM AvaliacaoVO a WHERE a.avaliado='H' AND  a.hospedagem.hospedaria = :param");
            query.setParameter("param", vo );
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Avaliação por Hospedaria");
        }
    }

}
