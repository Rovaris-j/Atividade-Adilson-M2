/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import dao.Conexao;
import model.Usuario;
import util.BCryptUtil;
import java.sql.*;
import java.util.*;
/*
* João Pedro Rovaris
* Gustavo Figueredo
* Guilherme Napolitano
*/
public class UsuarioDAO {
    private Connection con;

    public UsuarioDAO() {
        try {
            con = Conexao.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔑 LOGIN
    public Usuario buscarPorEmail(String email) {
        try {
            String sql = "SELECT * FROM usuarios WHERE email=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setCargo(rs.getString("cargo"));
                u.setFoto(rs.getString("foto"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 🔒 CADASTRAR (com senha criptografada)
    public void cadastrar(Usuario u) {
        try {
            String sql = "INSERT INTO usuarios (nome, email, senha, cargo, foto) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, BCryptUtil.hash(u.getSenha()));
            stmt.setString(4, u.getCargo());
            stmt.setString(5, u.getFoto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔍 LISTAR TODOS
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM usuarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setCargo(rs.getString("cargo"));
                u.setFoto(rs.getString("foto"));
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // ✏️ EDITAR PERFIL
    public void atualizar(Usuario u) {
        try {
            String sql = "UPDATE usuarios SET nome=?, email=?, senha=?, cargo=?, foto=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCargo());
            stmt.setString(5, u.getFoto());
            stmt.setInt(6, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🗑️ EXCLUIR
    public void excluir(int id) {
        try {
            String sql = "DELETE FROM usuarios WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // 🔎 BUSCAR POR ID
public Usuario buscarPorId(int id) {
    try {
        String sql = "SELECT * FROM usuarios WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));
            u.setCargo(rs.getString("cargo"));
            u.setFoto(rs.getString("foto"));
            return u;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

}
    
