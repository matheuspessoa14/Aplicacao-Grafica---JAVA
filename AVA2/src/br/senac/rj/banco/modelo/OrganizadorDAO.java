package br.senac.rj.banco.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizadorDAO {

    private int id_organizador;
    private String nome;
    private String email;
    private String telefone;
    private String empresa;

    public int getIdOrganizador() {
        return id_organizador;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmpresa() {
        return empresa;
    }

    // Consulta pelo ID
    public boolean consultarOrganizador(int id) {
        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "SELECT * FROM organizador WHERE id_organizador = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.id_organizador = rs.getInt("id_organizador");
                this.nome = rs.getString("nome");
                this.email = rs.getString("email");
                this.telefone = rs.getString("telefone");
                this.empresa = rs.getString("empresa");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar organizador: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }

    // Cadastrar sem inserir o id (auto-increment)
    public boolean cadastrarOrganizador(String nome, String email, String telefone, String empresa) {
        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "INSERT INTO organizador (nome, email, telefone, empresa) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, telefone);
            ps.setString(4, empresa);
            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar organizador: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }

    // Atualizar pelo id
    public boolean atualizarOrganizador(int id, String nome, String email, String telefone, String empresa) {
        if (!consultarOrganizador(id))
            return false;
        Connection conexao = null;
        try {
            conexao = Conexao.conectaBanco();
            String sql = "UPDATE organizador SET nome=?, email=?, telefone=?, empresa=? WHERE id_organizador=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, telefone);
            ps.setString(4, empresa);
            ps.setInt(5, id);
            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar organizador: " + e.getMessage());
            return false;
        } finally {
            Conexao.fechaConexao(conexao);
        }
    }
}

