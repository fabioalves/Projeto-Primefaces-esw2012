/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bo.bo;

import br.bo.util.Util;
import br.dao.dao.UsuarioDAO;
import br.dao.utils.FabricaEntityManager;
import br.dao.utils.PersistenciaException;
import br.dao.vo.UsuarioVO;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Transaction;
import org.hibernate.Session;
import br.bo.util.SessionFactoryUtil;

/**
 *
 * @author Odenor
 */
public class Usuario {
    private UsuarioDAO usuarioDAO;
        
    public Usuario() throws NegocioException {
        try {
            usuarioDAO = new UsuarioDAO();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar Persistência "+ex.getMessage());
        }
    }
    
    public UsuarioVO login(String email, String senha) throws NegocioException {
        try {
            
            try {
                senha = Util.gerarHashMD5(senha);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            UsuarioVO usuarioVO = usuarioDAO.buscarPorEmailSenha(email, senha);
        
            if(usuarioVO != null)
                return usuarioVO;
            else
                throw new NegocioException("Usuário não encontrado");
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Não foi possível realizar o login. "+
                    ex.getMessage());
        }   
    }
    

    public void inserir(UsuarioVO usuarioVO) throws NegocioException {


        String senha=usuarioVO.getSenha();
        try {
                senha = Util.gerarHashMD5(senha);
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex.getMessage());
            }
        usuarioVO.setSenha(senha);

        String mensagemErros = this.validarDados(usuarioVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }
        
        try {
            this.usuarioDAO.iniciarTransacao();
            this.usuarioDAO.incluir(usuarioVO);
            this.usuarioDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            
            throw new NegocioException("Erro ao incluir novo usuário - " + ex.getMessage());
        }
    }

    public void alterar(UsuarioVO usuarioVO) throws NegocioException {

        String mensagemErros = this.validarDados(usuarioVO);
        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }
        try {
           usuarioDAO.alterar(usuarioVO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao alterar o grupo de produto - " + ex.getMessage());
        }
    }

    public void excluir(UsuarioVO usuarioVO) throws NegocioException {
        try {
           usuarioDAO.excluir(usuarioVO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao excluir o grupo de produto - " + ex.getMessage());
        }
    }

    public UsuarioVO buscarPorCodigo(int codigo) throws NegocioException{
        try {
            return usuarioDAO.buscarPorCodigo(codigo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro na seleção por codigo - "+ex.getMessage());
        }
    }

    public List<UsuarioVO> buscarTodos() throws NegocioException {
        try {
            return usuarioDAO.buscarTodos();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro na seleção por codigo - "+ex.getMessage());
        }
    }

    private String validarDados(UsuarioVO usuarioVO) {

        String mensagemErros = "";

        /*
        if (usuarioVO.getNome().length() == 0) {
            mensagemErros += "Nome não pode ser vazio";
        }

        if (usuarioVO.getBairro().length() == 0) {
            mensagemErros += "Bairro não pode ser vazio";
        }

        if (usuarioVO.getCelular().length() == 0) {
            mensagemErros += "Celular não pode ser vazio";
        }
        
        if (usuarioVO.getCep().length() == 0) {
            mensagemErros += "CEP não pode ser vazio";
        }

        if (usuarioVO.getEmail().length() == 0) {
            mensagemErros += "Email não pode ser vazio";
        }

        if (usuarioVO.getEndereco().length() == 0) {
            mensagemErros += "Endereço não pode ser vazio";
        }*/
        
        if (usuarioVO.getSenha().length() == 0) {
            mensagemErros += "Senha não pode ser vazio";
        }
        
        if (usuarioVO.getEmail().length() == 0) {
            mensagemErros += "Email não pode ser vazio";
        }        
        
        return mensagemErros;
    }    
}
