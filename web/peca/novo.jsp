<%-- 
    Document   : novo
    Created on : 24 de nov. de 2025, 20:39:27
    Author     : João Pedro Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Nova Peça</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/new.css">
</head>

 <body class="gradient-bg">
    <div class="container">
        <h2>Nova Peça</h2>
        <form action="../PecaServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="acao" value="cadastrar">
            <div class="form-group">
                Nome:<br>
                <input type="text" name="nome" class="form-control" required><br>
            </div>
            
            <div class="form-group">
                Peso (KG):<br>
                <input type="number" step="0.01" name="peso" class="form-control" required><br>
            </div>

            <div class="form-group">
                Descrição: <br>
                <textarea name="descricao" class="form-control"></textarea><br>
            </div>
            
            <div class="form-group">
                Foto:<br>
                <input type="file" name="foto" class="form-control" accept="image/*"><br>
            </div>
            <button class="btn-add">Salvar</button>
            <a href="listar.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
