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
public class Peca {

    private int id;
    private String nome;
    private double peso;
    private String descricao;
    private String foto;
    private String foto_base64; // campo novo

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

    public double getPeso() { 
        return peso; 
    }
    public void setPeso(double peso) { 
        this.peso = peso; 
    }

    public String getDescricao() { 
        return descricao; 
    }
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public String getFoto_base64() { 
        return foto_base64; 
    }
    public void setFoto_base64(String foto_base64) { 
        this.foto_base64 = foto_base64; 
    }
}
