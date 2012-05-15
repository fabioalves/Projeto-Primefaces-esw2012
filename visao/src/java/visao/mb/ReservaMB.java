/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.mb;

import br.bo.bo.Hospedagem;
import br.bo.bo.NegocioException;
import br.dao.utils.PersistenciaException;
import br.dao.vo.HospedagemVO;
import br.dao.vo.HospedariaVO;
import br.dao.vo.UsuarioVO;
import br.visao.util.Util;
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
@RequestScoped
public class ReservaMB {

    private DataModel<HospedagemVO> listReserva;
    private HospedariaVO hospedariaVO;
    /**
     * Creates a new instance of ReservaMB
     */
    public ReservaMB() throws PersistenciaException, NegocioException {
        this.getReservas();
    }
    
    public void getReservas() throws PersistenciaException, NegocioException {
        Hospedagem hospedagem = new Hospedagem();
        
        setHospedariaVO((HospedariaVO)Util.getSession("hospedariaSelecionada"));
                
        System.out.println("--" + hospedariaVO.getNome());
        
        listReserva = new ListDataModel<HospedagemVO>(
                hospedagem.buscarHospedagemPorHospedaria(getHospedariaVO())
                );        
    }
    
    public String getSituacaoReserva(char situacao) {
        if(situacao == '0')
            return "AGUARDANDO APROVAÇÃO";
        else if(situacao == '1')
            return "APROVADA";
        else
            return "NÃO APROVADA";
    }
    
    public String aprovar() throws NegocioException {
        Hospedagem hospedagem = new Hospedagem();
        
        HospedagemVO hospVO = (HospedagemVO)listReserva.getRowData();
        
        hospVO.setSituacao('1');
        hospedagem.atualizar(hospVO);
        
        return null;
    }
    
    public String naoAprovar() throws NegocioException {
        Hospedagem hospedagem = new Hospedagem();
        
        HospedagemVO hospVO = (HospedagemVO)listReserva.getRowData();
        
        hospVO.setSituacao('0');
        hospedagem.atualizar(hospVO);
        return null;
    }

    /**
     * @return the listReserva
     */
    public DataModel<HospedagemVO> getListReserva() {
        return listReserva;
    }

    /**
     * @param listReserva the listReserva to set
     */
    public void setListReserva(DataModel<HospedagemVO> listReserva) {
        this.listReserva = listReserva;
    }

    /**
     * @return the hospedariaVO
     */
    public HospedariaVO getHospedariaVO() {
        return hospedariaVO;
    }

    /**
     * @param hospedariaVO the hospedariaVO to set
     */
    public void setHospedariaVO(HospedariaVO hospedariaVO) {
        this.hospedariaVO = hospedariaVO;
    }
    
    
}
