/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.mb;

import br.bo.bo.Hospedaria;
import br.bo.bo.NegocioException;
import br.dao.vo.CidadeVO;
import br.dao.vo.HospedariaVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

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
    
    private List<HospedariaVO> listHospedaria = new ArrayList<HospedariaVO>();
    
    /**
     * Creates a new instance of SolicitarReservaMB
     */
    public SolicitarReservaMB() {
        cidadeVO = new CidadeVO();
    }
    
    public String buscar()  throws NegocioException
    {
        List<HospedariaVO> lista = this.getHospedarias();
        for(HospedariaVO l : lista)
        {
            System.out.println(l.getNome());
            getListHospedaria().add(l);
        }
        
        return null;
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
    public List<HospedariaVO> getListHospedaria() {
        return listHospedaria;
    }

    /**
     * @param listHospedaria the listHospedaria to set
     */
    public void setListHospedaria(List<HospedariaVO> listHospedaria) {
        this.listHospedaria = listHospedaria;
    }
}
