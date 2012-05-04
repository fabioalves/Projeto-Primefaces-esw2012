package br.bo.bo;

import br.dao.dao.ModuloDAO;
import br.dao.vo.ModuloVO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import java.util.List;

public class Modulo {
    private ModuloDAO moduloDAO;
    
    public Modulo() throws NegocioException {
        try{
            moduloDAO = new ModuloDAO();
        }catch (PersistenciaException e) {
            throw new NegocioException("Erro ao iniciar Persistência" + e.getMessage());
        }
    }
    
    public void inserir(ModuloVO moduloVO) throws NegocioException {
        String mensagemErro = this.validarDados(moduloVO);
        
        if (!mensagemErro.isEmpty()) {
            throw new NegocioException(mensagemErro);
        }
        
        try {
           moduloDAO.iniciarTransacao(); 
           moduloDAO.incluir(moduloVO);
           moduloDAO.confirmarTransacao();
        } catch (PersistenciaException e) {
            throw new NegocioException("Erro ao incluir uma nova módulo - " + e.getMessage());
        }
    }
    
    
    
    public void alterar(ModuloVO moduloVO) throws NegocioException {
        String mensagemErro = this.validarDados(moduloVO);
        
        if (!mensagemErro.isEmpty()){
            throw new NegocioException(mensagemErro);
        }
        
        try{
            moduloDAO.iniciarTransacao();
            moduloDAO.alterar(moduloVO);
            moduloDAO.confirmarTransacao();
        }catch (PersistenciaException e) {
            throw new NegocioException("Erro ao alterar o modulo - " + e.getMessage());
        }
    }
    
    public void excluir(ModuloVO moduloVO) throws NegocioException{
        try{
            moduloDAO.iniciarTransacao();
            moduloDAO.excluir(moduloVO);
            moduloDAO.confirmarTransacao();
        } catch(PersistenciaException e) {
            throw new NegocioException("Erro ao excluir o módulo - " + e.getMessage());
        }
    }
    
    public ModuloVO buscarPorCodigo(int codigo) throws NegocioException{
        try{
            return moduloDAO.buscarPorCodigo(codigo);
        } catch (PersistenciaException e) {
            throw new NegocioException("Erro ao pesquisar modulo pelo codigo - " + e.getMessage());
        }
    }
    
    public List<ModuloVO> pesquisaParteNome(String titulo) throws NegocioException {
        try {
            return moduloDAO.buscarPorNome(titulo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar modulo pelo titulo - " + ex.getMessage());
        }
    }
    
    public List<ModuloVO> buscarTodos() throws NegocioException {
        try {
            return moduloDAO.buscarTodos();
        } catch (PersistenciaException e) {
            throw new NegocioException("Erro ao buscar todos os modulos - "+ e.getMessage());
        }        
    }
    
    private String validarDados(ModuloVO moduloVO) {
        String mensagemErros = "";
        
        if (moduloVO.getTitulo().length() == 0) {
            mensagemErros += "Campo Título é obrigatório";
        }
        
        return  mensagemErros;
    }
}
