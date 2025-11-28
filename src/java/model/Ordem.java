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
public class Ordem {
    
     private int id;
    private String numero;
    private int id_setor;
    private int id_peca;
    private int quantidade;
    private String status;
    private String data;
    private String pecaNome;
    private String setorNome;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public int getId_setor() { return id_setor; }
    public void setId_setor(int id_setor) { this.id_setor = id_setor; }

    public int getId_peca() { return id_peca; }
    public void setId_peca(int id_peca) { this.id_peca = id_peca; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

public String getPecaNome() { return pecaNome; }
public void setPecaNome(String pecaNome) { this.pecaNome = pecaNome; }

public String getSetorNome() { return setorNome; }
public void setSetorNome(String setorNome) { this.setorNome = setorNome; }
}
