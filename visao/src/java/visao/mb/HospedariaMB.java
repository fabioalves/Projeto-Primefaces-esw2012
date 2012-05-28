/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.mb;

import br.bo.bo.Cidade;
import br.bo.bo.Hospedaria;
import br.bo.bo.NegocioException;
import br.bo.util.PopularBD;
import br.dao.utils.PersistenciaException;
import br.dao.vo.CidadeVO;
import br.dao.vo.HospedariaVO;
import br.dao.vo.UsuarioVO;
import br.visao.util.Util;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Fabio
 */
@ManagedBean
@SessionScoped
public class HospedariaMB {

    private DataModel<HospedariaVO> listHospedaria = 
            new ListDataModel<HospedariaVO>();
    
    
    
    private HospedariaVO hospedariaSelecionada;
    private List<CidadeVO> cidades;
    private String cidadeSelecionada;
    
    /**
     * Creates a new instance of HospedariaMB
     */
    public HospedariaMB() throws NegocioException {
        getHospedariasPorCidade("Cuiabá");
        Cidade cidade = new Cidade();
        cidades = cidade.buscarTodos();
    }
    
    public void getHospedarias() throws NegocioException
    {
        UsuarioVO usuarioVO = (UsuarioVO)Util.getSession("usuario");
        
        Hospedaria hospedaria = new Hospedaria();
        List<HospedariaVO> lista = hospedaria.buscarPorAnfitriao(usuarioVO.getId());
        
        listHospedaria = new ListDataModel<HospedariaVO>(lista);        
    }

    public void getHospedariasPorCidade(String cidade) throws NegocioException
    {
        Hospedaria hospedaria = new Hospedaria();
        List<HospedariaVO> lista = hospedaria.buscarPorNomeCidade(cidade);
        
        // Popular o Banco de Dados - caso estiver vazio
        if(lista.isEmpty()){
            try {
                PopularBD pp = new PopularBD();
                lista = hospedaria.buscarPorNomeCidade(cidade);
            } catch (PersistenciaException ex) {
                throw new NegocioException(ex.getMessage());
            }
        }

        listHospedaria = new ListDataModel<HospedariaVO>(lista);        
    }
        
    public String selecionarHospedaria() {
        setHospedariaSelecionada((HospedariaVO)listHospedaria.getRowData());
        Util.setSession("hospedariaSelecionada", hospedariaSelecionada);
        
        return "consultarReservaHospedaria";
    }
    
    public void detalheHospedaria() {
        setHospedariaSelecionada((HospedariaVO)listHospedaria.getRowData());
        
    }
    
    public String reservar() throws NegocioException {
        Util.setSession("hospedariaSelecionada", (HospedariaVO)listHospedaria.getRowData());
        
        return "confirmarHospedagem";
    }

    /**
     * @return the listHospedaria
     */
    public DataModel<HospedariaVO> getListHospedaria() {
        return listHospedaria;
    }

    /**
     * @param listHospedaria the listHospedaria to set
     */
    public void setListHospedaria(DataModel<HospedariaVO> listHospedaria) {
        this.listHospedaria = listHospedaria;
    }

    /**
     * @return the hospedariaSelecionada
     */
    public HospedariaVO getHospedariaSelecionada() {
        return hospedariaSelecionada;
    }

    /**
     * @param hospedariaSelecionada the hospedariaSelecionada to set
     */
    public void setHospedariaSelecionada(HospedariaVO hospedariaSelecionada) {
        this.hospedariaSelecionada = hospedariaSelecionada;
    }

    /**
     * @return the cidades
     */
    public List<CidadeVO> getCidades() {
        return cidades;
    }

    /**
     * @param cidades the cidades to set
     */
    public void setCidades(List<CidadeVO> cidades) {
        this.cidades = cidades;
    }

    /**
     * @return the cidadeSelecionada
     */
    public String getCidadeSelecionada() {
        return cidadeSelecionada;
    }

    /**
     * @param cidadeSelecionada the cidadeSelecionada to set
     */
    public void setCidadeSelecionada(String cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
    }
    
    public void listenerBusca() throws NegocioException{
        if(cidadeSelecionada != null && !cidadeSelecionada.equals("")){
            getHospedariasPorCidade(cidadeSelecionada);
        }
    }


}
