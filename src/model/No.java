package model;

import java.util.HashSet;

/**
 *
 * @author Geam
 */
public class No {

    private int idNo;
    private final HashSet<Integer> conexao = new HashSet<>();

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public void setConexao(int conexao) {
        this.conexao.add(conexao);
    }

    public HashSet<Integer> getConexao() {
        return conexao;
    }

}
