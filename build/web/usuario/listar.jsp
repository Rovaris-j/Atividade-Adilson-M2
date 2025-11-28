<%-- 
    Document   : listar
    Created on : 24 de nov. de 2025, 21:14:51
    Author     : João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>

<%@page import="java.util.List"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="model.Usuario"%>

<%
    UsuarioDAO dao = new UsuarioDAO();
    List<Usuario> lista = dao.listar();
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Usuários - Sistema Produção</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css"> 
</head>

<body class="gradient-bg">

<!-- NAVBAR PADRÃO DO TEMA -->
<nav class="navbar custom-navbar">
    <span class="navbar-brand">Sistema Produção</span>
    <div>
        <a href="../dashboard.jsp" class="btn nav-btn-outline me-2">Dashboard</a>
        <a href="../LogoutServlet" class="btn nav-btn-danger">Sair</a>
    </div>
</nav>

<div class="container listar-container">

    <div class="table-card">
        <h2 class="table-title">Lista de Usuários</h2>

        <table class="table custom-table table-hover align-middle">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Cargo</th>
                    <th>Foto</th>
                </tr>
            </thead>

            <tbody>
                <% for (Usuario u : lista) { %>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getNome() %></td>
                    <td><%= u.getEmail() %></td>
                    <td><%= u.getCargo() %></td>

                    <td>
                        <% if (u.getFoto() != null) { %>
                            <img src="../assets/uploads/<%= u.getFoto() %>" width="60" class="rounded shadow-sm">
                        <% } else { %>
                            <span class="text-muted">?</span>
                        <% } %>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>
