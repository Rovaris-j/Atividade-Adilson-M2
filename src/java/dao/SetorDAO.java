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
import model.Setor;
import java.sql.*;
import java.util.*;

public class SetorDAO {

    private Connection con;

    public SetorDAO() {
        try {
            con = Conexao.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CADASTRAR
    public void cadastrar(Setor s) {
        try {
            String sql = "INSERT INTO setores (nome, descricao, responsavel, foto, foto_base64) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getNome());
            stmt.setString(2, s.getDescricao());
            stmt.setString(3, s.getResponsavel());
            stmt.setString(4, s.getFoto());
            stmt.setString(5, s.getFoto_base64());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // LISTAR
    public List<Setor> listar() {
        List<Setor> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM setores ORDER BY id";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Setor s = new Setor();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setDescricao(rs.getString("descricao"));
                s.setResponsavel(rs.getString("responsavel"));
                s.setFoto(rs.getString("foto"));
                s.setFoto_base64(rs.getString("foto_base64"));
                lista.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // BUSCAR POR ID
    public Setor buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM setores WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Setor s = new Setor();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setDescricao(rs.getString("descricao"));
                s.setResponsavel(rs.getString("responsavel"));
                s.setFoto(rs.getString("foto"));
                s.setFoto_base64(rs.getString("foto_base64"));
                return s;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ATUALIZAR
    public void atualizar(Setor s) {
        try {
            String sql = "UPDATE setores SET nome=?, descricao=?, responsavel=?, foto=?, foto_base64=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getNome());
            stmt.setString(2, s.getDescricao());
            stmt.setString(3, s.getResponsavel());
            stmt.setString(4, s.getFoto());
            stmt.setString(5, s.getFoto_base64());
            stmt.setInt(6, s.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // EXCLUIR
    public void excluir(int id) {
        try {
            String sql = "DELETE FROM setores WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
