<%-- 
    Document    : perfil 
    Created on  : 11 de nov. de 2025, 22:44:15 
    Author      : João Rovaris
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
    <title>Meu Perfil - Sistema de Produção</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body class="gradient-bg">

<nav class="navbar custom-navbar">
    <div class="container-fluid">
        <span class="navbar-brand" href="dashboard.jsp">Sistema Produção</span>
        <div>
            <a href="dashboard.jsp" class="btn btn-outline-light btn-sm me-2">Voltar</a>
            <a href="LogoutServlet" class="btn btn-danger btn-sm">Sair</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="card shadow p-4 mx-auto" style="max-width: 600px;">
        <h4 class="mb-4 text-center">Meu Perfil</h4>

        <form method="post" action="UsuarioServlet" enctype="multipart/form-data">
            <input type="hidden" name="acao" value="atualizar">
            <input type="hidden" name="id" value="<%= usuario.getId() %>">

            <div class="text-center mb-3">
                <%
                    String fotoURL;
                    if (usuario.getFoto_base64() != null && !usuario.getFoto_base64().isEmpty()) {
                        fotoURL = "data:image/*;base64," + usuario.getFoto_base64();
                    } else if (usuario.getFoto() != null && !usuario.getFoto().isEmpty()) {
                        fotoURL = "assets/uploads/" + usuario.getFoto();
                    } else {
                        fotoURL = "https://cdn-icons-png.flaticon.com/512/149/149071.png";
                    }
                %>

                <img src="<%= fotoURL %>"
                     class="rounded-circle mb-3 shadow"
                     width="130" height="130" alt="Foto de perfil">

                <div>
                    <input type="file" class="form-control mt-2" name="foto">
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label">Nome</label>
                <input type="text" class="form-control" name="nome" value="<%= usuario.getNome() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">E-mail</label>
                <input type="email" class="form-control" value="<%= usuario.getEmail() %>" readonly>
            </div>

            <div class="mb-3">
                <label class="form-label">Nova Senha</label>
                <input type="password" class="form-control" name="senha"
                       placeholder="Digite uma nova senha (opcional)">
            </div>

            <button type="submit" class="btn btn-primary w-100">Salvar Alterações</button>

            <% if (request.getParameter("ok") != null) { %>
                <div class="alert alert-success mt-3 text-center">
                    Perfil atualizado com sucesso!
                </div>
            <% } %>
        </form>
    </div>
</div>

</body>
</html>

