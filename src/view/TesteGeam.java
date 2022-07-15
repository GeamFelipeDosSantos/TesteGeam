package view;

import controller.Network;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;

/**
 *
 * @author Geam
 */
public class TesteGeam {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        try {
            Network ntw;
            int quantidade = Util.lerEntradaInteiro("\nQuantos elementos? ", false);
            int qtdConexoes = 0;
            ntw = new Network(quantidade);
            boolean continuar = true;
            do {
                int noConexao = Util.lerEntradaInteiro("\nInforme o elemento que deseja conectar:\n1º elemento: ", false) - 1;
                int noConexao2 = Util.lerEntradaInteiro("2º elemento: ", false) - 1;
                ntw.connect(noConexao, noConexao2);
                int escolha = Util.lerEntradaInteiro("\nVerificar conexoes? (1-Sim) (2-Não)", true);
                if (escolha == 1) {

                    int noVerificar = Util.lerEntradaInteiro("1º elemento: ", false) - 1;
                    int noVerificar2 = Util.lerEntradaInteiro("2º elemento: ", false) - 1;
                    ntw.verificarConexao(ntw, noVerificar, noVerificar2);
                }
                escolha = Util.lerEntradaInteiro("\nDeseja conectar mais elementos? (1-Sim) (2-Não)", true);
                if (escolha == 2) {
                    continuar = false;
                }
                qtdConexoes++;
            } while (continuar);

        } catch (Exception ex) {
            Logger.getLogger(TesteGeam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
