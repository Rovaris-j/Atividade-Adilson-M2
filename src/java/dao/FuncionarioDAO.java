/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
/*
* João Pedro Rovaris
* Gustavo Figueredo
* Guilherme Napolitano
*/
import model.Funcionario;
import java.sql.*;
import java.util.*;

public class FuncionarioDAO {

    private Connection con;

    public FuncionarioDAO() {
        try {
            con = Conexao.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CADASTRAR
    public void cadastrar(Funcionario f) {
        try {
            String sql = "INSERT INTO funcionarios (nome, cpf, email, telefone, cargo, foto, foto_base64) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getCargo());
            stmt.setString(6, f.getFoto());
            stmt.setString(7, f.getFoto_base64());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // LISTAR
    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();

                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setCargo(rs.getString("cargo"));
                f.setFoto(rs.getString("foto"));
                f.setFoto_base64(rs.getString("foto_base64"));

                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // ATUALIZAR
    public void atualizar(Funcionario f) {
        try {
            String sql = "UPDATE funcionarios SET nome=?, cpf=?, email=?, telefone=?, cargo=?, foto=?, foto_base64=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getCargo());
            stmt.setString(6, f.getFoto());
            stmt.setString(7, f.getFoto_base64());
            stmt.setInt(8, f.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // EXCLUIR
    public void excluir(int id) {
        try {
            String sql = "DELETE FROM funcionarios WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // BUSCAR POR ID
    public Funcionario buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM funcionarios WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario f = new Funcionario();

                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setCargo(rs.getString("cargo"));
                f.setFoto(rs.getString("foto"));
                f.setFoto_base64(rs.getString("foto_base64"));

                return f;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

