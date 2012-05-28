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
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
    
    private String justificativa;
    
    private int avaliacaoHospede;
    private int avaliacaoAnfitriao;
    /**
     * Creates a new instance of ReservaMB
     */
    
    public DataModel<HospedagemVO> getReservas() throws PersistenciaException, NegocioException {
        Hospedagem hospedagem = new Hospedagem();
        
        setHospedariaVO((HospedariaVO)Util.getSession("hospedariaSelecionada"));
                
        listReserva = new ListDataModel<HospedagemVO>(
                hospedagem.buscarHospedagemPorHospedaria(getHospedariaVO())
                );
        return listReserva;
    }
    
    public DataModel<HospedagemVO> getReservasUsuario() throws PersistenciaException, NegocioException, IOException {
        UsuarioVO usuarioVO = (UsuarioVO)Util.getSession("usuario");
        
        if(usuarioVO != null) {       
        
        Hospedagem hospedagem = new Hospedagem();
                
        listReserva = new ListDataModel<HospedagemVO>(
                hospedagem.buscarHospedagemPorUsuario(usuarioVO));
        return listReserva;
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
            return null;
        }
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
    
    
    public String reprovar() throws NegocioException {
        Hospedagem hospedagem = new Hospedagem();
        
        HospedagemVO hospVO = (HospedagemVO)listReserva.getRowData();
        
        hospVO.setComentario(getJustificativa());
        hospVO.setSituacao('2');
        hospedagem.atualizar(hospVO);
        return "consultarReservaHospedaria";
    }
    
    public String avaliacaoHospede() throws NegocioException {
        Hospedagem hospedagem = new Hospedagem();
        
        HospedagemVO hospVO = (HospedagemVO)listReserva.getRowData();
        
        hospVO.setAvaliacaoHospede(getAvaliacaoHospede());
        hospedagem.atualizar(hospVO);
        return "avaliarHospedagem";
    }
    
    public String avaliacaoAnfitriao() throws NegocioException {
        Hospedagem hospedagem = new Hospedagem();
        
        HospedagemVO hospVO = (HospedagemVO)listReserva.getRowData();
        
        hospVO.setAvaliacaoAnfitriao(getAvaliacaoAnfitriao());
        hospedagem.atualizar(hospVO);
        return "consultarReservaHospedaria";
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

    /**
     * @return the justificativa
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * @param justificativa the justificativa to set
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    /**
     * @return the avaliacaoHospede
     */
    public int getAvaliacaoHospede() {
        return avaliacaoHospede;
    }

    /**
     * @param avaliacaoHospede the avaliacaoHospede to set
     */
    public void setAvaliacaoHospede(int avaliacaoHospede) {
        this.avaliacaoHospede = avaliacaoHospede;
    }

    /**
     * @return the avaliacaoAnfitriao
     */
    public int getAvaliacaoAnfitriao() {
        return avaliacaoAnfitriao;
    }

    /**
     * @param avaliacaoAnfitriao the avaliacaoAnfitriao to set
     */
    public void setAvaliacaoAnfitriao(int avaliacaoAnfitriao) {
        this.avaliacaoAnfitriao = avaliacaoAnfitriao;
    }
    
    
}
