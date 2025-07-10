package br.senac.rj.banco.teste;

import java.sql.Connection;
import br.senac.rj.banco.modelo.Conexao;

public class TestaConexao {
    public static void main(String[] args) {
        Connection con = Conexao.conectaBanco();
        if (con != null) {
            System.out.println("Conexão OK!");
            Conexao.fechaConexao(con);
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}
