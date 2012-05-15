package teste;

import br.bo.bo.NegocioException;
import br.dao.vo.*;
import br.bo.bo.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Odenor
 */
public class TesteHospedaria {
        public static void main(String[] args) throws NegocioException, ParseException
    {
        
        CidadeVO cid = new CidadeVO();
        cid.setNome("Cuiaba");
        cid.setUf("MT");
        
        Cidade c = new Cidade();
        c.inserir(cid);
        
        CidadeVO cid2 = new CidadeVO();
        cid2.setNome("Sao Paulo");
        cid2.setUf("SP");
        
        c.inserir(cid2);
        
        UsuarioVO us = new UsuarioVO();
        us.setBairro("Bairro Teste");
        us.setCelular("9999999");
        us.setCep("78080000");
        us.setCidadeVO(c.buscarTodos().get(0));
        us.setEmail("teste");
        us.setEndereco("Endereco Teste");
        us.setFoto("img1.jpg");
        us.setNome("Usuario Teste");
        us.setSenha("202cb962ac59075b964b07152d234b70");
        us.setTelefone("33333333");
        
        new Usuario().inserir(us);
        
        UsuarioVO us2 = new UsuarioVO();
        us2.setBairro("Bairro Teste");
        us2.setCelular("9999999");
        us2.setCep("78080000");
        us2.setCidadeVO(c.buscarTodos().get(0));
        us2.setEmail("dono");
        us2.setEndereco("Endereco Teste");
        us2.setFoto("img1.jpg");
        us2.setNome("Dono Teste");
        us2.setSenha("202cb962ac59075b964b07152d234b70");
        us2.setTelefone("33333333");
        us2.setCidadeVO(c.buscarTodos().get(1));
        
        new Usuario().inserir(us2);
                
        HospedariaVO ho = new HospedariaVO();
        ho.setBairro("Jardim Primavera");
        ho.setCelular("6592440865");
        ho.setCep("78055484");
        ho.setCidade(c.buscarTodos().get(1));
        ho.setEndereco("Rua Doutor Lima Tersas");
        ho.setLocalizacaoGeografica("teste");
        ho.setNome("Hospedaria Teste");
        ho.setTelefone("3624-3333");
        ho.setCelular("99999999");
        ho.setValorDiaria(100);
                
        ho.setUsuarioVO(new Usuario().buscarTodos().get(1));
        
        new Hospedaria().inserir(ho);        
        
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println( ho.getId() + " - " + ho.getNome() +" - "+ho.getCidade().getNome());
        System.out.println("----------------------------------");
    }
}
