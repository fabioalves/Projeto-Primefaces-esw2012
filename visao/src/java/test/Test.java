/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import br.bo.bo.Hospedaria;
import br.bo.bo.NegocioException;
import br.dao.vo.HospedariaVO;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class Test {
    public static void main(String[] args) throws NegocioException {
        Hospedaria hosp = new Hospedaria();
        List<HospedariaVO> list = hosp.buscarPorNomeCidade("%Cuia%");
        
        for(HospedariaVO hospedaria : list)
        {
            System.out.print(hospedaria.getNome());
        }
    }
    
}
