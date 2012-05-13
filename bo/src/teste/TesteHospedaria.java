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
        
        
        //Rotina para inserção um registro
        CidadeVO c=new CidadeVO();
        c.setNome("Cuiabá");
        c.setUf("MT");
        new Cidade().inserir(c);
        
        HospedariaVO ho = new HospedariaVO();
        ho.setBairro("Jardim Primavera");
        ho.setCelular("6592440865");
        ho.setCep("78055484");
        ho.setCidade(c);
        ho.setEndereco("Rua Doutor Lima Avelino");
        ho.setLocalizacaoGeografica("teste");
        ho.setNome("Casa dos sonhos");
        ho.setTelefone("3624-3333");
        ho.setCelular("");
        ho.setValorDiaria(100);
        
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO = new Usuario().buscarPorCodigo(10);
        ho.setUsuarioVO(usuarioVO);
        
        new Hospedaria().inserir(ho);
        
        
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println( ho.getId() + " - " + ho.getNome() +" - "+ho.getCidade().getNome());
        System.out.println("----------------------------------");
    }
}
