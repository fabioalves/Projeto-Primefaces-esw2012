/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import br.bo.bo.Hospedagem;
import br.bo.bo.Hospedaria;
import br.bo.bo.NegocioException;
import br.bo.bo.Usuario;
import br.dao.utils.PersistenciaException;
import br.dao.vo.HospedagemVO;
import br.dao.vo.HospedariaVO;
import br.dao.vo.UsuarioVO;
import br.visao.util.Util;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class Test {
    public static void main(String[] args) throws NegocioException, PersistenciaException {
        
        Hospedaria hosp = new Hospedaria();
        HospedariaVO hospedVO = hosp.buscarPorCodigo(20);
        
        Hospedagem hospedagem = new Hospedagem();
        HospedagemVO hospVO = hospedagem.buscarHospedagemPorCodigo(50);
        
        System.out.println(hospVO.getDiaInicio());
       // hospVO.setSituacao('1');
       // hospedagem.atualizar(hospVO);
    }
    
}
