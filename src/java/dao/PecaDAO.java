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
import model.Peca;
import java.sql.*;
import java.util.*;

public class PecaDAO {

    private Connection con;

    public PecaDAO() {
        try {
            con = Conexao.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CADASTRAR
    public void cadastrar(Peca p) {
        try {
            String sql = "INSERT INTO pecas (nome, peso, descricao, foto_base64) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPeso());
            stmt.setString(3, p.getDescricao());
            stmt.setString(4, p.getFoto_base64());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // LISTAR
    public List<Peca> listar() {
        List<Peca> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pecas";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Peca p = new Peca();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPeso(rs.getDouble("peso"));
                p.setDescricao(rs.getString("descricao"));
                p.setFoto_base64(rs.getString("foto_base64"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // BUSCAR POR ID
    public Peca buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM pecas WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Peca p = new Peca();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPeso(rs.getDouble("peso"));
                p.setDescricao(rs.getString("descricao"));
                p.setFoto_base64(rs.getString("foto_base64"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ATUALIZAR
    public void atualizar(Peca p) {
        try {
            String sql = "UPDATE pecas SET nome=?, peso=?, descricao=?, foto_base64=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPeso());
            stmt.setString(3, p.getDescricao());
            stmt.setString(4, p.getFoto_base64());
            stmt.setInt(5, p.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // EXCLUIR
    public void excluir(int id) {
        try {
            String sql = "DELETE FROM pecas WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    

