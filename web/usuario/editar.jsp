<%-- 
    Document   : editar
    Created on : 24 de nov. de 2025, 21:15:15
    Author     : João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>

<%@page import="model.Usuario"%>
<%@page import="dao.UsuarioDAO"%>

<%
    Usuario u = (Usuario) request.getSession().getAttribute("usuario");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Perfil</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/new.css">
</head>
<body class="gradient-bg">

    <div class="container">
    <h2>Editar Perfil</h2>
        <form action="../UsuarioServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%= u.getId() %>">
            
            <div class="form-group">
                Nome:<br>
                <input type="text" class="form-control" name="nome" value="<%= u.getNome() %>" required><br>
            </div>
                
            <div class="form-group">
                Email:<br>
                <input type="email" class="form-control" value="<%= u.getEmail() %>" disabled><br>
            </div>
             
            <div class="form-group">
                Nova senha (opcional):<br>
                <input type="password" name="senha" class="form-control"><br>
            </div>
             
            <div class="form-group">
                Cargo:<br>
                <input type="text" name="cargo" class="form-control" value="<%= u.getCargo() %>" required><br>
            </div>
            
            <div class="form-group">
                Foto atual:<br>
                <% if (u.getFoto() != null) { %>
                    <img src="../assets/uploads/<%= u.getFoto() %>" width="100"><br><br>
                <% } %>
            </div>
            
            <div class="form-group">
                Alterar foto:<br>
                <input type="file" name="foto" class="form-control"><br><br>
            </div>
            <button class="btn-add">Salvar</button>
            <a href="listar.jsp" class="btn btn-secondary">Voltar</a>
        </form>
    </div>
</body>
</html>
