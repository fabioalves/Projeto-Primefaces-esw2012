package br.bo.bo;

import br.dao.dao.CidadeDAO;
import br.dao.utils.PersistenciaException;
import br.dao.vo.CidadeVO;
import java.util.List;

public class Cidade {
    private CidadeDAO cidadeDAO;
    
    public Cidade() throws NegocioException{
       try{
          cidadeDAO = new CidadeDAO(); 
       }catch (PersistenciaException e) {
            throw new NegocioException("Erro ao iniciar Persistência "+ e.getMessage());
        }
    }
    
    public void inserir(CidadeVO cidadeVO) throws NegocioException{
        String mensagemErros = this.validarDados(cidadeVO);
        
        if (!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }     
        
        try{
            cidadeDAO.iniciarTransacao();
            cidadeDAO.incluir(cidadeVO);
            cidadeDAO.confirmarTransacao();
        }catch (PersistenciaException e) {
            throw new NegocioException("Erro ao incluir uma nova cidade - "+e.getMessage());
        }
    }
    
    public void alterar(CidadeVO cidadeVO) throws NegocioException{
        String mensagemErro = this.validarDados(cidadeVO);
        
        if (!mensagemErro.isEmpty()){
            throw new NegocioException(mensagemErro);
        }
        
        try{
            cidadeDAO.iniciarTransacao();
            cidadeDAO.alterar(cidadeVO);
            cidadeDAO.confirmarTransacao();
        }catch (PersistenciaException e){
            throw new NegocioException("Erro ao alterar a cidade - " + e.getMessage());
        }
    }
    
    public void excluir(CidadeVO cidadeVO) throws NegocioException{
        try{
            cidadeDAO.iniciarTransacao();
            cidadeDAO.excluir(cidadeVO);
            cidadeDAO.confirmarTransacao();
        } catch (PersistenciaException e){
            throw  new NegocioException("Erro ao excluir a cidade - " + e.getMessage());
        }
    }
    
    public CidadeVO buscarPorCodigo(int codigo) throws NegocioException{
        try{
            return cidadeDAO.buscarPorCodigo(codigo);
        } catch(PersistenciaException e){
            throw new NegocioException("Erro ao pesquisar cidade pelo codigo - "+e.getMessage());
        }
    }
    
    public List<CidadeVO> pesquisaPorNome(String nome) throws NegocioException{
        try{
            return cidadeDAO.buscarPorNome(nome);
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar cidade pelo nome - " + ex.getMessage());
        }
    }
    
    public List<CidadeVO> pesquisaPorUF(String uf) throws NegocioException{
        try{
            return cidadeDAO.buscarPorUF(uf);
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar cidade por UF - " + ex.getMessage());
        }
    }
    
    public List<CidadeVO> buscarTodos() throws NegocioException{
        try{
            return cidadeDAO.buscarTodos();
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao buscar todas as cidade - " + ex.getMessage());
        }
    }

    private String validarDados(CidadeVO cidadeVO) {
        String mensagemErros = "";
        
        if (cidadeVO.getNome().length() == 0){
            mensagemErros += "O campo Nome é obrigatório";
        }
        
        if (cidadeVO.getUf().length() == 0){
            mensagemErros += "O campo UF é obrigatório";
        }
        return mensagemErros;
    }
}
