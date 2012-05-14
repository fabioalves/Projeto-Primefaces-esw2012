/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import br.bo.bo.Hospedagem;
import br.bo.bo.Hospedaria;
import br.bo.bo.NegocioException;
import br.bo.bo.Usuario;
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
    public static void main(String[] args) throws NegocioException {
        Hospedaria hosp = new Hospedaria();
        List<HospedariaVO> lista = hosp.buscarPorNomeCidade("%a%");
        
        HospedagemVO hospVO = new HospedagemVO();
                
        hospVO.setDiaInicio(new Date(2012, 06, 05));
        hospVO.setDiaFim(new Date(2012, 06, 10));
        hospVO.setHospedaria(lista.get(0));
        hospVO.setComentario("");
        
        //UsuarioVO usuarioVO = (UsuarioVO) Util.getSession("usuario");
        
        UsuarioVO usuarioVO = new Usuario().buscarTodos().get(0);
        
        hospVO.setUsuario(usuarioVO);
        hospVO.setSituacao('A');
        
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.reservar(hospVO);
    }
    
}
