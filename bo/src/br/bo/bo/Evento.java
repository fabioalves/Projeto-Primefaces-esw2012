package br.bo.bo;

import br.dao.dao.EventoDAO;
import br.dao.utils.PersistenciaException;
import br.dao.vo.EventoVO;
import java.util.Date;
import java.util.List;

public class Evento {
    private EventoDAO eventoDAO;
    
    public Evento() throws NegocioException{
        try{
            eventoDAO = new EventoDAO();
        }catch (PersistenciaException e) {
            throw new NegocioException("Erro ao iniciar Persistência "+ e.getMessage());
        }
    }
    
    
    public void inserir(EventoVO eventoVO) throws NegocioException{
        String mensagemErros = this.validarDados(eventoVO);
        
        if (!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }     
        
        try{
            eventoDAO.iniciarTransacao();
            eventoDAO.incluir(eventoVO);
            eventoDAO.confirmarTransacao();
        }catch (PersistenciaException e) {
            throw new NegocioException("Erro ao incluir um novo evento - "+e.getMessage());
        }
    }
    
    
    public void alterar(EventoVO eventoVO) throws NegocioException{
        String mensagemErro = this.validarDados(eventoVO);
        
        if (!mensagemErro.isEmpty()){
            throw new NegocioException(mensagemErro);
        }
        
        try{
            eventoDAO.iniciarTransacao();
            eventoDAO.alterar(eventoVO);
            eventoDAO.confirmarTransacao();
        }catch (PersistenciaException e){
            throw new NegocioException("Erro ao alterar o evento - " + e.getMessage());
        }
    }
    
    
    public void excluir(EventoVO eventoVO) throws NegocioException{
        try{
            eventoDAO.iniciarTransacao();
            eventoDAO.excluir(eventoVO);
            eventoDAO.confirmarTransacao();
        } catch (PersistenciaException e){
            throw  new NegocioException("Erro ao excluir o evento - " + e.getMessage());
        }
    }
    
    public EventoVO buscarPorCodigo(int codigo) throws NegocioException{
        try{
            return eventoDAO.buscarPorCodigo(codigo);
        } catch(PersistenciaException e){
            throw new NegocioException("Erro ao pesquisar evetno pelo codigo - "+e.getMessage());
        }
    }
    
    public List<EventoVO> pesquisaPorTitulo(String titulo) throws NegocioException{
        try{
            return eventoDAO.buscarPorNome(titulo);
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar evento pelo titulo - " + ex.getMessage());
        }
    }
    
    public List<EventoVO> pesquisaPorData(Date data) throws NegocioException{
        try{
            return eventoDAO.buscarPorData(data);
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar evento por data - " + ex.getMessage());
        }
    }
    
    public List<EventoVO> buscarTodos() throws NegocioException{
        try{
            return eventoDAO.buscarTodos();
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao buscar todos os eventos - " + ex.getMessage());
        }
    }

    private String validarDados(EventoVO eventoVO) {
        String mensagemErros = "";
        
        if (eventoVO.getDescricao().length() == 0){
            mensagemErros += "O campo Descrição é obrigatório";
        }
        
        if (eventoVO.getTitulo().length() == 0){
            mensagemErros += "O campo Titulo é obrigatório";
        }
        
        if (eventoVO.getDiaHoraInicio().toString().length() == 0){
            mensagemErros += "O campo Dia e Hora de Inicio é obrigatório";
        }
        
        if (eventoVO.getDiaHoraFim().toString().length() == 0){
            mensagemErros += "O campo Dia e Hora de Fim é obrigatório";
        }
        
        return  mensagemErros;
    }
}
