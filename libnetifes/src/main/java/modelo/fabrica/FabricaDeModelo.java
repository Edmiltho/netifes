package modelo.fabrica;

import controle.ControleCliente;
import controle.ControleLocacao;
import controle.IControle;
import java.util.Map;
import modelo.Cliente;
import modelo.Locacao;

/**
 * Recebe um mapa de parametros e preenche as informa�oes para a cria��o da classe de
 * modelo especifica.
 * @author felipe
 */
public class FabricaDeModelo {

    Map parametros = null;

    public FabricaDeModelo(Map parametros) {
        this.parametros = parametros;
    }

    public Object getModelo(String nomeModelo) {
        Object objModelo = null;
        if (nomeModelo.equals("locacao")) {
            objModelo = new Locacao();
            Locacao locacao = (Locacao) objModelo;
            //tratar quando esta vazio
            String [] arg = (String [])parametros.get("nome");
            locacao.setNome(arg[0]);
        } else if (nomeModelo.equals("cliente")) {
            objModelo = new Cliente();
            Cliente cliente = (Cliente) objModelo;            
            //tratar quando esta vazio
            String [] arg = (String [])parametros.get("nome");
            cliente.setNome((String) arg[0]);
        }
        return objModelo;
    }

}
