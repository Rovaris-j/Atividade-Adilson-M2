<%-- 
    Document   : novo
    Created on : 24 de nov. de 2025, 21:15:04
    Author     : João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Novo Usuário</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/new.css">
</head>

<body class="gradient-bg">
    <div class="container">
        <h2>Cadastrar Usuário</h2>
        <form action="../UsuarioServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="acao" value="cadastrar">

            <div class="form-group">
                Nome:<br>
                <input type="text" name="nome" class="form-control" required><br>
            </div>
            
            <div class="form-group">
                Email:<br>
                <input type="email" name="email" class="form-control" required><br>
            </div>
            
            <div class="form-group">
                Senha:<br>
                <input type="password" name="senha" class="form-control" required><br>
            </div>
            
            <div class="form-group">
                Cargo:<br>
                <input type="text" name="cargo" class="form-control" required><br>
            </div>
            
            <div class="form-group">
                Foto de Perfil:<br>
                <input type="file" name="foto" class="form-control"><br><br>
            </div>
                <button class="btn-add">Cadastrar</button>
                <a href="listar.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
