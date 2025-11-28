/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author João Rovaris
 *         Gustavo Figueredo
 *         Guilherme Napolitano
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cargo;
    private String foto;         // nome do arquivo salvo
    private String foto_base64;  // imagem convertida para Base64

    public Usuario() {}

    public Usuario(String nome, String email, String senha, String cargo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    // Getters e Setters
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getSenha() { 
        return senha; 
    }
    public void setSenha(String senha) { 
        this.senha = senha; 
    }

    public String getCargo() { 
        return cargo; 
    }
    public void setCargo(String cargo) { 
        this.cargo = cargo; 
    }

    public String getFoto() { 
        return foto; 
    }
    public void setFoto(String foto) { 
        this.foto = foto; 
    }

    public String getFoto_base64() { 
        return foto_base64; 
    }
    public void setFoto_base64(String foto_base64) { 
        this.foto_base64 = foto_base64; 
    }
}
