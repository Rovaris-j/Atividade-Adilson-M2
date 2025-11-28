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
import model.Ordem;
import java.sql.*;
import java.util.*;

public class OrdemDAO {

    private Connection con;

    public OrdemDAO() {
        try {
            con = Conexao.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================================
    // CADASTRAR
    // ================================
    public void cadastrar(Ordem o) {
        try {
            String sql = "INSERT INTO ordens (numero, id_setor, id_peca, quantidade, status, data) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, o.getNumero());
            stmt.setInt(2, o.getId_setor());
            stmt.setInt(3, o.getId_peca());
            stmt.setInt(4, o.getQuantidade());
            stmt.setString(5, o.getStatus());
            stmt.setString(6, o.getData());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================================
    // LISTAR COM JOIN
    // ================================
    public List<Ordem> listar() {
        List<Ordem> lista = new ArrayList<>();

        try {
            String sql =
                "SELECT o.*, s.nome AS setorNome, p.nome AS pecaNome " +
                "FROM ordens o " +
                "JOIN setores s ON o.id_setor = s.id " +     // <-- CORRIGIDO
                "JOIN pecas p ON o.id_peca = p.id";           // <-- CORRIGIDO

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ordem o = new Ordem();

                o.setId(rs.getInt("id"));
                o.setNumero(rs.getString("numero"));
                o.setId_setor(rs.getInt("id_setor"));
                o.setId_peca(rs.getInt("id_peca"));
                o.setQuantidade(rs.getInt("quantidade"));
                o.setStatus(rs.getString("status"));
                o.setData(rs.getString("data"));

                // nomes trazidos pelo JOIN
                o.setSetorNome(rs.getString("setorNome"));
                o.setPecaNome(rs.getString("pecaNome"));

                lista.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // ================================
    // ATUALIZAR
    // ================================
    public void atualizar(Ordem o) {
        try {
            String sql = "UPDATE ordens SET numero=?, id_setor=?, id_peca=?, quantidade=?, status=?, data=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, o.getNumero());
            stmt.setInt(2, o.getId_setor());
            stmt.setInt(3, o.getId_peca());
            stmt.setInt(4, o.getQuantidade());
            stmt.setString(5, o.getStatus());
            stmt.setString(6, o.getData());
            stmt.setInt(7, o.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================================
    // EXCLUIR
    // ================================
    public void excluir(int id) {
        try {
            String sql = "DELETE FROM ordens WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================================
    // BUSCAR POR ID (para editar.jsp)
    // ================================
    public Ordem buscarPorId(int id) {
        try {
            String sql =
                "SELECT o.*, s.nome AS setorNome, p.nome AS pecaNome " +
                "FROM ordens o " +
                "JOIN setores s ON o.id_setor = s.id " +   // <-- CORRIGIDO
                "JOIN pecas p ON o.id_peca = p.id " +       // <-- CORRIGIDO
                "WHERE o.id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Ordem o = new Ordem();

                o.setId(rs.getInt("id"));
                o.setNumero(rs.getString("numero"));
                o.setId_setor(rs.getInt("id_setor"));
                o.setId_peca(rs.getInt("id_peca"));
                o.setQuantidade(rs.getInt("quantidade"));
                o.setStatus(rs.getString("status"));
                o.setData(rs.getString("data"));

                o.setSetorNome(rs.getString("setorNome"));
                o.setPecaNome(rs.getString("pecaNome"));

                return o;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
