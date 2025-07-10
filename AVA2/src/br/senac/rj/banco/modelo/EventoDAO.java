package br.senac.rj.banco.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventoDAO extends Evento {

    public boolean consultarEvento(int id) {
        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "SELECT * FROM evento WHERE id_evento=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                System.out.println("Evento não encontrado!");
                return false;
            } else {
                while (rs.next()) {
                    this.setId(rs.getInt("id_evento"));
                    this.setNome(rs.getString("nome"));
                    this.setData(rs.getString("data_evento"));
                    this.setLocal(rs.getString("local"));
                    this.setDescricao(rs.getString("descricao"));
                    this.setIdOrganizador(rs.getInt("id_organizador")); // novo campo
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar evento: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }

    public boolean cadastrarEvento(String nome, String data, String local, String descricao, int idOrganizador) {
        // Valida se organizador existe antes de inserir
        if (!existeOrganizador(idOrganizador)) {
            System.out.println("ID do organizador não existe.");
            return false;
        }

        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "INSERT INTO evento (nome, data_evento, local, descricao, id_organizador) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, data);
            ps.setString(3, local);
            ps.setString(4, descricao);
            ps.setInt(5, idOrganizador);
            int linhas = ps.executeUpdate();
            return linhas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar evento: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }

    public boolean atualizarEvento(int id, String nome, String data, String local, String descricao, int idOrganizador) {
        if (!consultarEvento(id))
            return false;

        // Valida se organizador existe antes de atualizar
        if (!existeOrganizador(idOrganizador)) {
            System.out.println("ID do organizador não existe.");
            return false;
        }

        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "UPDATE evento SET nome=?, data_evento=?, local=?, descricao=?, id_organizador=? WHERE id_evento=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, data);
            ps.setString(3, local);
            ps.setString(4, descricao);
            ps.setInt(5, idOrganizador);
            ps.setInt(6, id);
            int linhas = ps.executeUpdate();
            return linhas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar evento: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }

    public boolean existeOrganizador(int idOrganizador) {
        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "SELECT 1 FROM organizador WHERE id_organizador = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idOrganizador);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao verificar organizador: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }
}
