<%-- 
    Document   : listar
    Created on : 24 de nov. de 2025, 20:59:07
    Author     : João Pedro Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>

<%@page import="dao.OrdemDAO"%>
<%@page import="model.Ordem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    OrdemDAO dao = new OrdemDAO();
    List<Ordem> lista = dao.listar();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Ordens de Produção</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
</head>

<body class="gradient-bg">

<h2 class="mb-4 text-white">Ordens de Produção</h2>

<a href="novo.jsp" class="btn-add">+ Nova Ordem</a>

<div class="table-card">
<table class="table custom-table table-striped align-middle">
    <thead>
        <tr>
            <th>ID</th>
            <th>Número</th>
            <th>Setor</th>
            <th>Peça</th>
            <th>Qtd</th>
            <th>Status</th>
            <th>Data</th>
            <th>Ações</th>
        </tr>
    </thead>
        <tbody>
         <% for (Ordem o : lista) { %>
         <tr>
             <td><%= o.getId() %></td>
             <td><%= o.getNumero() %></td>
             <td><%= o.getSetorNome() %></td>   <!-- AGORA MOSTRA O NOME DO SETOR -->
             <td><%= o.getPecaNome() %></td>    <!-- AGORA MOSTRA O NOME DA PEÇA -->
             <td><%= o.getQuantidade() %></td>
             <td><%= o.getStatus() %></td>
             <td><%= o.getData() %></td>
             <td>
                 <a href="editar.jsp?id=<%= o.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                 <a href="../OrdemServlet?acao=excluir&id=<%= o.getId() %>" class="btn btn-danger btn-sm">Excluir</a>
             </td>
         </tr>
         <% } %>
     </tbody>
</table>
</div>

</body>
</html>
