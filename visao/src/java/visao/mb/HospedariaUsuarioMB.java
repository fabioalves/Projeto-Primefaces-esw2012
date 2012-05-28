/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.mb;

import br.bo.bo.Hospedaria;
import br.bo.bo.NegocioException;
import br.dao.vo.HospedariaVO;
import br.dao.vo.UsuarioVO;
import br.visao.util.Util;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Fabio
 */
@Named(value = "hospedariaUsuarioMB")
@SessionScoped
public class HospedariaUsuarioMB implements Serializable {
private DataModel<HospedariaVO> listHospedariaUsuario = 
            new ListDataModel<HospedariaVO>();

private HospedariaVO hospedariaSelecionada;
    /**
     * Creates a new instance of HospedariaUsuarioMB
     */
    public HospedariaUsuarioMB() throws NegocioException, IOException {
        UsuarioVO usuarioVO = (UsuarioVO)Util.getSession("usuario"); 
        if(usuarioVO == null)
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
    }
    
    public String selecionarHospedaria(int id) throws NegocioException {        
        setHospedariaSelecionada(new Hospedaria().buscarPorCodigo(id));
        Util.setSession("hospedariaSelecionada", getHospedariaSelecionada());
        
        return "consultarReservaHospedaria";
    }
    
    public DataModel<HospedariaVO> getHospedariasUsuario() throws NegocioException {
        UsuarioVO usuarioVO = (UsuarioVO)Util.getSession("usuario"); 
        Hospedaria hospedaria = new Hospedaria();
        return new ListDataModel<HospedariaVO>(
                hospedaria.buscarPorAnfitriao(usuarioVO.getId()));
    }

    /**
     * @return the listHospedariaUsuario
     */
    public DataModel<HospedariaVO> getListHospedariaUsuario() {
        return listHospedariaUsuario;
    }

    /**
     * @param listHospedariaUsuario the listHospedariaUsuario to set
     */
    public void setListHospedariaUsuario(DataModel<HospedariaVO> listHospedariaUsuario) {
        this.listHospedariaUsuario = listHospedariaUsuario;
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
