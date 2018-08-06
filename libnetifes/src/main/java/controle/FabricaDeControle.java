package controle;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.Filme;
import modelo.Locacao;

public class FabricaDeControle {

    public enum EstretegiaPersistencia {
        HIBERNATE, JDBC
    };
    private  EstretegiaPersistencia estrategia = EstretegiaPersistencia.HIBERNATE;

    public EstretegiaPersistencia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstretegiaPersistencia estrategia) {
        this.estrategia = estrategia;
    }

    /*
      M�todo static responsavel por instanciar a classe de controle  dado o 
    tipo do controle que deve ser isntanciado. Esse m�todo � a implmenta��o do 
    padr�o m�todo f�brica dos padr�es GOF.
     */
    public IControle getControle(String nomeControle) {
        IControle controle = null;
        try {
            if (nomeControle.equals("locacao")) {
                controle = new ControleLocacao<Locacao>();
                if (this.estrategia == EstretegiaPersistencia.HIBERNATE) {
                    controle.setDAO(new modelo.persistencia.hibernate.LocacaoDAOImpl());
                }
            } else if (nomeControle.equals("cliente")) {
                controle = new ControleCliente<Cliente>();
                controle.setDAO(new modelo.persistencia.hibernate.ClienteDAOImpl());
            } else if (nomeControle.equals("filme")) {
                controle = new ControleFilme<Filme>();
                if (this.estrategia == EstretegiaPersistencia.HIBERNATE) {
                    controle.setDAO(new modelo.persistencia.hibernate.FilmeDAOImpl());
                } else {
                    controle.setDAO(new modelo.persistencia.jdbc.FilmeDAOImpl());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(FabricaDeControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return controle;
    }
}
