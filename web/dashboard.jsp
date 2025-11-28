<%-- 
    Document   : dashboard
    Created on : 11 de nov. de 2025, 22:26:17
    Author     : João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>

<%@ page import="model.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Painel - Sistema de Produção</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- CSS Externo -->
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body class="index-bg">


<nav class="navbar custom-navbar">
    <span class="navbar-brand">Sistema Produção</span>
    <div>
        <a href="perfil.jsp" class="btn nav-btn-outline">Perfil</a>
        <a href="LogoutServlet" class="btn nav-btn-danger">Sair</a>
    </div>
</nav>

<div class="dashboard-wrapper">
    <div class="dashboard-card">
        <h3>Bem-vindo, <%= usuario.getCargo() %> <%= usuario.getNome() %>!</h3>
        <p class="cargo-text">Cargo: <%= usuario.getCargo() %></p>

        <div class="dashboard-buttons">
            <a href="peca/listar.jsp" class="dashboard-btn">Gerenciar Peças</a>
            <a href="setor/listar.jsp" class="dashboard-btn">Gerenciar Setores</a>
            <a href="funcionario/listar.jsp" class="dashboard-btn">Funcionários</a>
            <a href="ordem/listar.jsp" class="dashboard-btn">Ordens de Produção</a>
        </div>
    </div>
</div>


</body>
</html>
