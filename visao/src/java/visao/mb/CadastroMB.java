/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.mb;

import br.bo.bo.NegocioException;
import br.dao.vo.UsuarioVO;
import br.bo.bo.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jivago
 */
@ManagedBean
@RequestScoped
public class CadastroMB {
    private UsuarioVO usuario = new UsuarioVO();
    private String confirmaSenha;
    
    /**
     * Creates a new instance of CadastroMB
     */
    public CadastroMB() {
    }

    /**
     * @return the usuario
     */
    public UsuarioVO getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the confirmaSenha
     */
    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    /**
     * @param confirmaSenha the confirmaSenha to set
     */
    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public void salvar(){

        try {
            Usuario bo = new Usuario();
            
            bo.inserir(usuario);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"USUÁRIO INCLUÍDO COM SUCESSO!", "Deseja incluir outro?"));  
        } catch (NegocioException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"USUÁRIO NÃO INCLUÍDO", ex.getMessage()));  
        }
    }

}
