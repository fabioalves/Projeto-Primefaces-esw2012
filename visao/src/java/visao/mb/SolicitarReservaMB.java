/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.mb;

import br.bo.bo.Hospedagem;
import br.bo.bo.Hospedaria;
import br.bo.bo.NegocioException;
import br.bo.bo.Usuario;
import br.dao.utils.PersistenciaException;
import br.dao.vo.CidadeVO;
import br.dao.vo.HospedagemVO;
import br.dao.vo.HospedariaVO;
import br.dao.vo.UsuarioVO;
import br.visao.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Fabio
 */
@ManagedBean
@SessionScoped
public class SolicitarReservaMB {

    private Date periodo1;
    private Date periodo2;
    private CidadeVO cidadeVO;
    
    private DataModel listHospedaria = new ListDataModel<HospedariaVO>();
    
    private HospedariaVO hospedariaSelecionada;
    
    
    /**
     * Creates a new instance of SolicitarReservaMB
     */
    public SolicitarReservaMB() throws NegocioException {
        cidadeVO = new CidadeVO();       
    }
    
    public String buscar()  throws NegocioException
    {
        List<HospedariaVO> lista = this.getHospedarias();
        listHospedaria = new ListDataModel(lista);        
        
        return "solicitarReserva";
    }
    
    public String selecionar()
    {
        setHospedariaSelecionada((HospedariaVO)listHospedaria.getRowData());
        return "detalhesHospedaria";
    }
    
    public String reservar() throws NegocioException
    {
        HospedagemVO hospVO = new HospedagemVO();
        hospVO.setDiaInicio(periodo1);
        hospVO.setDiaFim(periodo2);
        hospVO.setHospedaria(hospedariaSelecionada);
        
        UsuarioVO usuarioVO = (UsuarioVO) Util.getSession("usuario");
        
        hospVO.setUsuario(usuarioVO);
        hospVO.setSituacao('0');
        hospVO.setComentario("");
        
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.reservar(hospVO);
        return "confirmacaoHospedagem";
    }
            
            
    
    private List<HospedariaVO> getHospedarias() throws NegocioException
    {
        Hospedaria hosp = new Hospedaria();
        return hosp.buscarPorNomeCidade("%"+cidadeVO.getNome()+"%");
    }

    /**
     * @return the periodo1
     */
    public Date getPeriodo1() {
        return periodo1;
    }

    /**
     * @param periodo1 the periodo1 to set
     */
    public void setPeriodo1(Date periodo1) {
        this.periodo1 = periodo1;
    }

    /**
     * @return the periodo2
     */
    public Date getPeriodo2() {
        return periodo2;
    }

    /**
     * @param periodo2 the periodo2 to set
     */
    public void setPeriodo2(Date periodo2) {
        this.periodo2 = periodo2;
    }

    /**
     * @return the cidade
     */
    public CidadeVO getCidadeVO() {
        return cidadeVO;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidadeVO(CidadeVO cidadeVO) {
        this.cidadeVO = cidadeVO;
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
}
