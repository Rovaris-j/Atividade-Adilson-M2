<%-- 
    Document   : listar
    Created on : 24 de nov. de 2025, 20:52:53
    Author     : João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolita
--%>

<%@page import="dao.SetorDAO"%>
<%@page import="model.Setor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    SetorDAO dao = new SetorDAO();
    List<Setor> lista = dao.listar();
%>

<!DOCTYPE html>

<html>
<head>
    <title>Lista de Setores</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
</head>

<body class="gradient-bg">

<h2 class="mb-4 text-white">Gerenciar Setores</h2>

<a href="novo.jsp" class="btn-add">+ Novo Setor</a>

<div class="table-card">
<table class="table custom-table table-striped align-middle">
    <thead>
    <tr>
        <th>Foto</th>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Responsável</th>
        <th>Ações</th>
    </tr>
    </thead>
    
    <tbody>

    <% for (Setor s : lista) { %>
    <tr>
        <td>
            <% if (s.getFoto_base64() != null) { %>
                <img src="data:image/png;base64,<%= s.getFoto_base64() %>" width="60">
            <% } else { %>
                <img src="../assets/img/semfoto.png" width="60">
            <% } %>
        </td>

        <td><%= s.getId() %></td>
        <td><%= s.getNome() %></td>
        <td><%= s.getDescricao() %></td>
        <td><%= s.getResponsavel() %></td>

        <td>
            <a href="editar.jsp?id=<%= s.getId() %>" class="btn btn-primary btn-sm">Editar</a>
            <a href="../SetorServlet?acao=excluir&id=<%= s.getId() %>" class="btn btn-danger btn-sm"
            accesskey=""onclick="return confirm('Deseja excluir este setor?')">
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

