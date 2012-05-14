/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.mb;

import br.bo.bo.Hospedagem;
import br.bo.bo.NegocioException;
import br.dao.utils.PersistenciaException;
import br.dao.vo.HospedagemVO;
import br.dao.vo.UsuarioVO;
import br.visao.util.Util;
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
public class ReservaMB {

    private DataModel<HospedagemVO> listReserva;
    /**
     * Creates a new instance of ReservaMB
     */
    public ReservaMB() throws PersistenciaException, NegocioException {
        this.getReservas();
    }
    
    public void getReservas() throws PersistenciaException, NegocioException {
        Hospedagem hospedagem = new Hospedagem();
        
        UsuarioVO usuarioVO = (UsuarioVO)Util.getSession("usuario");
                
        listReserva = new ListDataModel<HospedagemVO>(
                hospedagem.buscarHospedagemPorUsuario(usuarioVO)
                );
        
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
    
    
}
