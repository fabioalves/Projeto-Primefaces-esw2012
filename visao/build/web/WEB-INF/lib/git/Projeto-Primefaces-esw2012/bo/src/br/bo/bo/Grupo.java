package br.bo.bo;

import br.dao.dao.GrupoDAO;
import br.dao.dao.ModuloDAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.GrupoVO;
import java.util.List;


public class Grupo {
    private GrupoDAO grupoDAO;
    
    public Grupo() throws NegocioException{
        try{
            grupoDAO = new GrupoDAO();
        }catch (PersistenciaException e) {
            throw new NegocioException("Erro ao iniciar Persistência "+ e.getMessage());
        }
    }
    
    public void inserir(GrupoVO grupoVO) throws NegocioException{
        String mensagemErros = this.validarDados(grupoVO);
        
        if (!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }     
        
        try{
            grupoDAO.iniciarTransacao();
            grupoDAO.incluir(grupoVO);
            grupoDAO.confirmarTransacao();
        }catch (PersistenciaException e) {
            throw new NegocioException("Erro ao incluir um novo grupo - "+e.getMessage());
        }
    }
    
    public void alterar(GrupoVO grupoVO) throws NegocioException{
        String mensagemErro = this.validarDados(grupoVO);
        
        if (!mensagemErro.isEmpty()){
            throw new NegocioException(mensagemErro);
        }
        
        try{
            grupoDAO.iniciarTransacao();
            grupoDAO.alterar(grupoVO);
            grupoDAO.confirmarTransacao();
        }catch (PersistenciaException e){
            throw new NegocioException("Erro ao alterar o grupo - " + e.getMessage());
        }
    }
    
    public void excluir(GrupoVO grupoVO) throws NegocioException{
        try{
            grupoDAO.iniciarTransacao();
            grupoDAO.excluir(grupoVO);
            grupoDAO.confirmarTransacao();
        } catch (PersistenciaException e){
            throw  new NegocioException("Erro ao excluir o grupo - " + e.getMessage());
        }
    }
    
    public GrupoVO buscarPorCodigo(int codigo) throws NegocioException{
        try{
            return grupoDAO.buscarPorCodigo(codigo);
        } catch(PersistenciaException e){
            throw new NegocioException("Erro ao pesquisar grupo pelo codigo - "+e.getMessage());
        }
    }
    
    public List<GrupoVO> pesquisaPorTitulo(String titulo) throws NegocioException{
        try{
            return grupoDAO.buscarPorNome(titulo);
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar grupo pelo titulo - " + ex.getMessage());
        }
    }
    
    public List<GrupoVO> buscarTodos() throws NegocioException {
        try {
            return grupoDAO.buscarTodos();
        } catch (PersistenciaException e) {
            throw new NegocioException("Erro ao buscar todos os grupos - "+ e.getMessage());
        }        
    }

    private String validarDados(GrupoVO grupoVO) {
        String mensagemErros = "";
        
        if (grupoVO.getTitulo().length() == 0){
            mensagemErros += "O campo Titulo é obrigatório";
        }
        
        return  mensagemErros;
    }
    
  
}
