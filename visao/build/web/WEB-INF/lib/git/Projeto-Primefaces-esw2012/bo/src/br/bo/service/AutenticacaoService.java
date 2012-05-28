/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bo.service;

import br.bo.bo.NegocioException;
import br.bo.bo.Usuario;
import br.dao.vo.UsuarioVO;

/**
 *
 * @author Fabio
 */
public class AutenticacaoService {
    
    public UsuarioVO login(String email, String senha) throws NegocioException {
        try {         
            Usuario usuario = new Usuario();
            return usuario.login(email, senha);
            
        } catch(NegocioException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
}
