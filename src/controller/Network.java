package controller;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.No;
import util.Util;
import view.TesteGeam;

/**
 *
 * @author Geam
 */
public class Network {

    private final No[] elementos;
    private final int qtdElementos;

    public Network(int qtdElementos) throws Exception {

        this.elementos = new No[qtdElementos];
        this.qtdElementos = qtdElementos;
        for (int i = 0; i < qtdElementos; i++) {
            this.elementos[i] = new No();
        }
    }

    /**
     * Realiza conexão dos nós da estrutura
     *
     * @param con1
     * @param con2
     * @throws Exception
     */
    public void connect(int con1, int con2) throws Exception {

        if (verificarNoValido(con1) && verificarNoValido(con2)) {
            this.elementos[con1].setConexao(con2);
            this.elementos[con2].setConexao(con1);
        } else {
            System.out.println("Elemento inexistente!");
        }

    }

    /**
     * Busca conexões
     *
     * @param noOrigem
     * @param noDestino
     * @return boolean
     * @throws Exception
     */
    public boolean query(int noOrigem, int noDestino) throws Exception {
        if (verificarNoValido(noOrigem) && verificarNoValido(noDestino)) {
            if (elementos[noOrigem].getConexao().isEmpty()) {
                throw new Exception("O elemento/nó inicial não está conectado");
            }
            if (elementos[noOrigem].getConexao().contains(noDestino)) {
                return true;
            }
            HashSet<Integer> nosPercorridos = new HashSet<>();
            nosPercorridos.add(noOrigem);
            return buscarConexoesIndiretas(noOrigem, noDestino, nosPercorridos);
        } else {
            System.out.println("Nó inválido");
            return false;
        }
    }

    /**
     * Busca conexões indiretas
     *
     * @param noOrigem
     * @param noDestino
     * @param nosPercorridos
     * @return boolean
     */
    private boolean buscarConexoesIndiretas(int noOrigem, int noDestino, HashSet<Integer> nosPercorridos) {
        for (int noAtual : elementos[noOrigem].getConexao()) {
            if (!nosPercorridos.contains(noAtual)) {
                nosPercorridos.add(noAtual);
                if (noAtual == noDestino) {
                    return true;
                } else {
                    return buscarConexoesIndiretas(noAtual, noDestino, nosPercorridos);

                }
            }
        }
        return false;
    }

    public void verificarConexao(Network ntw, int no1, int no2) {
        try {
            System.out.println(this.query(no1, no2) ? "Existe conexão entre os elementos" : "Não existe conexão entre os elementos");
        } catch (Exception ex) {
            Logger.getLogger(TesteGeam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verificarNoValido(int numeroNo) {
        if (numeroNo < 0) {
            return false;
        }

        if (numeroNo > elementos.length) {
            return false;
        }

        return true;
    }
}
