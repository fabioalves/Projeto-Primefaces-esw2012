/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.dao.dao.*;
import br.dao.utils.PersistenciaException;
import br.dao.vo.*;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author fabio
 */
public class teste {
    public static void main(String[] args) throws PersistenciaException 
    {
        // Usuário Hóspede
        //
        UsuarioVO usuario = new UsuarioVO();
        usuario.setNome("Jivago");
        usuario.setEmail("ji_maia@hotmail.com");
        usuario.setSenha("maia");
        usuario.setEndereco("Rua Alizios, 145");
        usuario.setBairro("Jd.Bom Clima");
        usuario.setCep("78048-226");
        usuario.setFoto("jivago.jpg");
        usuario.setTelefone("9926.1155");
        usuario.setCelular("9926.1155");
        
        // Cidade
        //
        CidadeVO cidade = new CidadeVO();
        cidade.setNome("Cuiabá");
        cidade.setUf("MT");
        
        
        // Hospedaria
        //
        HospedariaVO hospedaria = new HospedariaVO();
        hospedaria.setNome("Casa de Hospedagem Cuiabá");
        hospedaria.setEndereco("Av. Fernando Correia, 222");
        hospedaria.setBairro("Coxipó");
        hospedaria.setCep("78000-000");
        hospedaria.setCelular("1234");
        hospedaria.setTelefone("1234");
        hospedaria.setValorDiaria(550);
        hospedaria.setLocalizacaoGeografica("123456,654321");
        hospedaria.setCidade(cidade);
        
        // Hospedagem
        //
        HospedagemVO hospedagem = new HospedagemVO();
        java.sql.Date dataSQL = null;
        try {
            dataSQL = converteData("01/01/2012");
        } catch (Exception ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        hospedagem.setDiaInicio(dataSQL);
        hospedagem.setDiaFim(dataSQL);
        hospedagem.setSituacao('E');
        hospedagem.setComentario("Teste");
        hospedagem.setHospedaria(hospedaria);
        hospedagem.setUsuario(usuario);
                
        // Avaliação Tipo 1 = Hóspede avalia Hospedagem
        AvaliacaoVO avaliacao = new AvaliacaoVO();
        avaliacao.setComentario("Ótimo cliente");
        avaliacao.setAvaliado('U');  // U=usuário / H=hospedaria
        avaliacao.setNota(5); // 1-Péssimo/ 2-Ruim/ 3-Regular/ 4-Bom/ 5-Ótimo
        avaliacao.setStatus('A');  // A-avaliação / C-censurado
        avaliacao.setHospedagem(hospedagem);
        
        // Incluir o Usuário
        UsuarioDAO usuarioDao = new UsuarioDAO();
        try {
            usuarioDao.iniciarTransacao();
            usuarioDao.incluir(usuario);
            usuarioDao.confirmarTransacao();
        } catch (PersistenciaException ex) {
            ex.getMessage();
        }

        // Incluir Cidade
        CidadeDAO cidadeDao = new CidadeDAO();
        try {
            cidadeDao.iniciarTransacao();
            cidadeDao.incluir(cidade);
            cidadeDao.confirmarTransacao();
        } catch (PersistenciaException ex) {
            ex.getMessage();
        }
        
        
        HospedariaDAO hospedariaDao = new HospedariaDAO();
        try {
            hospedariaDao.iniciarTransacao();
            hospedariaDao.incluir(hospedaria);
            hospedariaDao.confirmarTransacao();
        } catch (PersistenciaException ex) {
            ex.getMessage();
        }

        HospedagemDAO hospedagemDao = new HospedagemDAO();
        try {
            hospedagemDao.iniciarTransacao();
            hospedagemDao.incluir(hospedagem);
            hospedagemDao.confirmarTransacao();
        } catch (PersistenciaException ex) {
            ex.getMessage();
        }
        
        AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
        try {
            avaliacaoDao.iniciarTransacao();
            avaliacaoDao.incluir(avaliacao);
            avaliacaoDao.confirmarTransacao();
        } catch (PersistenciaException ex) {
            ex.getMessage();
        }
                
    }
    
    public static java.sql.Date converteData(String dataString) throws Exception {
        java.sql.Date retorno = null;
        try {
            DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            retorno = new java.sql.Date(((java.util.Date) formatador.parse(dataString)).getTime());
        } catch (ParseException e) {
            throw new Exception("Data inválida");
        }
        return retorno;
    }
}
