/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.mb;

import br.bo.bo.NegocioException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.bo.bo.Usuario;
import br.dao.utils.PersistenciaException;
import br.dao.vo.UsuarioVO;
import br.visao.util.Util;

/**
 *
 * @author Fabio
 */
@ManagedBean
@SessionScoped
public class AutenticacaoMB {
    private String nome;
    private String email;
    private String senha;
    private String msg;
    private UsuarioVO usuarioVO;

    /**
     * Creates a new instance of AutenticacaoMB
     */
    public AutenticacaoMB() {
        
    }    
    
    public String login() throws PersistenciaException {
        
        try {
            Usuario usuario = new Usuario();
            setUsuarioVO(usuario.login(email, senha));
            
            Util.setSession("usuario", usuarioVO);
            
            return "paginaInicial"; 
        
        } catch(NegocioException ex) {
            msg = ex.getMessage();            
            setUsuarioVO(null);
            
            email = senha = null;
            
            return "login";
        }
    }   
    
    public String logout() {
        this.setUsuarioVO(null);
        
        return "login";
    }
    
            

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the usuarioVO
     */
    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    /**
     * @param usuarioVO the usuarioVO to set
     */
    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
}
