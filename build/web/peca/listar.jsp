<%-- 
    Document   : listar
    Created on : 24 de nov. de 2025, 20:39:56
    Author     : João Pedro Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>

<%@page import="dao.PecaDAO"%>
<%@page import="model.Peca"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    PecaDAO dao = new PecaDAO();
    List<Peca> lista = dao.listar();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Peças</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
</head>

<body class="gradient-bg">

<h2 class="mb-4 text-white">Lista de Peças</h2>

<a href="novo.jsp" class="btn-add">+ Nova Peça</a>


<div class="table-card">
<table class="table custom-table table-striped align-middle">
    <thead>
        <tr>
            <th>Foto</th>
            <th>ID</th>
            <th>Nome</th>
            <th>Peso</th>
            <th>Descrição</th>
            <th>Ações</th>
        </tr>
    </thead>

    <tbody>
        <% for (Peca p : lista) { %>
        <tr>
            <td>
                <% if (p.getFoto_base64() != null) { %>
                    <img src="data:image/*;base64,<%= p.getFoto_base64() %>" class="rounded-circle mb-3 shadow" width="80" height="80">
                <% } else { %>
                    <img src="../assets/img/semfoto.png" class="rounded-circle mb-3 shadow" width="80" height="80">
                <% } %>
            </td>

            <td><%= p.getId() %></td>
            <td><%= p.getNome() %></td>
            <td><%= p.getPeso() %></td>
            <td><%= p.getDescricao() %></td>

            <td>
                <a href="editar.jsp?id=<%= p.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                <a href="../PecaServlet?acao=excluir&id=<%= p.getId() %>" class="btn btn-danger btn-sm">Excluir</a>
            </td>
        </tr>
        <% } %>
    </tbody>
</table>
</div>

</body>
</html>
