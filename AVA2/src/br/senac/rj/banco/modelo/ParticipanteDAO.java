package br.senac.rj.banco.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipanteDAO extends Participante {

    public boolean consultarParticipante(int id) {
        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "SELECT * FROM participante WHERE id_participante=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                System.out.println("Participante não encontrado!");
                return false;
            } else {
                while (rs.next()) {
                    this.setId(rs.getInt("id_participante"));
                    this.setNome(rs.getString("nome"));
                    this.setEmail(rs.getString("email"));
                    this.setTelefone(rs.getString("telefone"));
                    this.setTipoIngresso(rs.getString("tipo_ingresso"));
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar participante: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }

    public boolean cadastrarParticipante(String nome, String email, String telefone, String tipoIngresso) {
        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "INSERT INTO participante (nome, email, telefone, tipo_ingresso) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, telefone);
            ps.setString(4, tipoIngresso);
            int linhas = ps.executeUpdate();
            return linhas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar participante: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }

    public boolean atualizarParticipante(int id, String nome, String email, String telefone, String tipoIngresso) {
        if (!consultarParticipante(id))
            return false;

        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "UPDATE participante SET nome=?, email=?, telefone=?, tipo_ingresso=? WHERE id_participante=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, telefone);
            ps.setString(4, tipoIngresso);
            ps.setInt(5, id);
            int linhas = ps.executeUpdate();
            return linhas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar participante: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }
}
