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
@RequestScoped
public class HospedariaMB {

    private DataModel<HospedariaVO> listHospedaria = 
            new ListDataModel<HospedariaVO>();
    
    private HospedariaVO hospedariaSelecionada;
    /**
     * Creates a new instance of HospedariaMB
     */
    public HospedariaMB() throws NegocioException {
        this.getHospedarias();
    }
    
    public void getHospedarias() throws NegocioException
    {
        UsuarioVO usuarioVO = (UsuarioVO)Util.getSession("usuario");
        
        Hospedaria hospedaria = new Hospedaria();
        
        System.out.println("000--"+usuarioVO.getId());
        
        List<HospedariaVO> lista = hospedaria.buscarPorAnfitriao(usuarioVO.getId());
        listHospedaria = new ListDataModel<HospedariaVO>(lista);        
    }
    
    public String selecionarHospedaria() {
        setHospedariaSelecionada((HospedariaVO)listHospedaria.getRowData());
        Util.setSession("hospedariaSelecionada", hospedariaSelecionada);
        
        return "consultarReservaHospedaria";
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
