<%-- 
    Document   : listar
    Created on : 26 de nov. de 2025, 22:58:17
    Author     : João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>

<%@page import="dao.FuncionarioDAO"%>
<%@page import="model.Funcionario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    FuncionarioDAO dao = new FuncionarioDAO();
    List<Funcionario> lista = dao.listar();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Funcionários</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
</head>

<body class="gradient-bg">

<h2 class="mb-4 text-white">Gerenciar Funcionários</h2>

<a href="novo.jsp" class="btn-add">+ Novo Funcionário</a>


<div class="table-card">
<table class="table custom-table table-striped align-middle">
    <thead>
        <tr>
            <th>Foto</th>
            <th>ID</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Cargo</th>
            <th>Ações</th>
        </tr>
    </thead>

    <tbody>
    <% for (Funcionario f : lista) { %>
        <tr>
            <td>
                <% if (f.getFoto() != null) { %>
                    <img src="../assets/uploads/<%= f.getFoto() %>" width="50" height="50" class="rounded">
                <% } else { %>
                    <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" width="50" height="50">
                <% } %>
            </td>

            <td><%= f.getId() %></td>
            <td><%= f.getNome() %></td>
            <td><%= f.getCpf() %></td>
            <td><%= f.getEmail() %></td>
            <td><%= f.getTelefone() %></td>
            <td><%= f.getCargo() %></td>

            <td>
                <a href="editar.jsp?id=<%= f.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                <a href="../FuncionarioServlet?acao=excluir&id=<%= f.getId() %>"
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('Excluir funcionário?')">
                   Excluir
                </a>
            </td>
        </tr>
    <% } %>
    </tbody>
</table>
</div>
    
</body>
</html>

