/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bo.util;
import br.dao.dao.*;
import br.dao.utils.PersistenciaException;
import br.dao.vo.*;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.bo.util.Util;

/**
 *
 * @author jivago
 */
public class PopularBD {
    public PopularBD() throws PersistenciaException{
         // Usuário Hóspede
        //
        UsuarioVO usuario = new UsuarioVO();
        usuario.setNome("João Paulo");
        usuario.setEmail("joao@ufmt.br");
        String senha="123456";
        try {
                senha = Util.gerarHashMD5(senha);
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex.getMessage());
            }
        usuario.setSenha(senha);
        usuario.setEndereco("Av. Fernando Correia, 222");
        usuario.setBairro("Coxipó");
        usuario.setCep("78000-000");
        usuario.setFoto("usuario-0001.jpg");
        usuario.setTelefone("(65)3322.1234");
        usuario.setCelular("(65)9922.1234");
        
        // Cidade
        //
        CidadeVO cidade = new CidadeVO();
        cidade.setNome("Cuiabá");
        cidade.setUf("MT");

        CidadeVO cidade2 = new CidadeVO();
        cidade2.setNome("Chapada dos Guimarães");
        cidade2.setUf("MT");
        
        
        // Hospedaria
        //
        HospedariaVO hospedaria1 = new HospedariaVO();
        hospedaria1.setNome("Hospedaria do João");
        hospedaria1.setEndereco("Av. Fernando Correia, 222");
        hospedaria1.setBairro("Coxipó");
        hospedaria1.setCep("78000-000");
        hospedaria1.setCelular("(65)9922.3344");
        hospedaria1.setTelefone("(65)3312.4567");
        hospedaria1.setValorDiaria(550);
        hospedaria1.setLocalizacaoGeografica("123456,654321");
        hospedaria1.setCidade(cidade);
        hospedaria1.setFoto("hospedaria-0001.jpg");
        hospedaria1.setDescricao("Um paraíso situado no espaço rural do município de Chapada dos Guimarães em Mato Grosso. Está localizada no caminho que leva às montanhas,cercada pela exuberante vegetação nativa, aqui você encontra conforto, tranquilidade e atendimento personalizado.");

        HospedariaVO hospedaria2 = new HospedariaVO();
        hospedaria2.setNome("Hospedaria do Ricardo");
        hospedaria2.setEndereco("Av. do CPA, 123");
        hospedaria2.setBairro("Santa Rosa");
        hospedaria2.setCep("78000-000");
        hospedaria2.setCelular("(65)9922.3344");
        hospedaria2.setTelefone("1234");
        hospedaria2.setValorDiaria(850);
        hospedaria2.setLocalizacaoGeografica("123456,654321");
        hospedaria2.setCidade(cidade);
        hospedaria2.setFoto("hospedaria-0002.jpg");
        hospedaria2.setDescricao("A hospedaria do Ricardo tem o objetivo de hospedar visitantes e turistas que queira assitir a copa do mundo e descançar ou curtir os maravilhoso Mato Grosso.");
        
        HospedariaVO hospedaria3 = new HospedariaVO();
        hospedaria3.setNome("Chácara Bom Pastor");
        hospedaria3.setEndereco("Estrada da Chapada dos Guimarães");
        hospedaria3.setBairro("Ribeirinho");
        hospedaria3.setCep("78000-000");
        hospedaria3.setCelular("(65)9922.3344");
        hospedaria3.setTelefone("(65)3312.4567");
        hospedaria3.setValorDiaria(850);
        hospedaria3.setLocalizacaoGeografica("123456,654321");
        hospedaria3.setCidade(cidade2);
        hospedaria3.setFoto("hospedaria-0002.jpg");
        hospedaria3.setDescricao("A hospedaria do Ricardo tem o objetivo de hospedar visitantes e turistas que queira assitir a copa do mundo e descançar ou curtir os maravilhoso Mato Grosso.");
        
        // Hospedagem
        //
        HospedagemVO hospedagem = new HospedagemVO();
        java.sql.Date dataSQL = null;
        try {
            dataSQL = converteData("01/01/2012");
        } catch (Exception ex) {
            Logger.getLogger(PopularBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        hospedagem.setDiaInicio(dataSQL);
        hospedagem.setDiaFim(dataSQL);
        hospedagem.setSituacao('E');
        hospedagem.setComentario("Teste");
        hospedagem.setHospedaria(hospedaria1);
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
            cidadeDao.incluir(cidade2);
            cidadeDao.confirmarTransacao();
        } catch (PersistenciaException ex) {
            ex.getMessage();
        }
        
        
        HospedariaDAO hospedariaDao = new HospedariaDAO();
        try {
            hospedariaDao.iniciarTransacao();
            hospedariaDao.incluir(hospedaria1);
            hospedariaDao.incluir(hospedaria2);
            hospedariaDao.incluir(hospedaria3);
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
