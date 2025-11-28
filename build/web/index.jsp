
<!--
    Document   : index
    Created on : 11 de nov. de 2015, 22:21:31
    Author     :  João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lan="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Login - Sistema de Produção</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body class="index-bg">
        <div class="container d-flex justify-content-center align-items-center vh-100">
            <div class="card p-4 shadow" style="width: 360px;">
                <h4 class="text-center mb-4">Acesso ao Sistema</h4>
                
                <form method="post" action="LoginServlet">
                    <div class="mb-3">
                        <label for="email" class="form-label">E-mail</label>
                        <input type="text" class="form-control" id="email" name="email" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="senha" class="form-label">Senha</label>
                        <input type="password" class="form-control" id="senha" name="senha" required>
                    </div>
                    
                    <button type="submit" class="btn btn-primary w-100">Entrar</button>
                </form>
                <% if (request.getParameter("erro") != null) { %>
                <div class="alert alert-danger mt-3 text-center">
                    Usuário ou senha inválidos!
                </div>
                <%} %>
            </div>
        </div>
    </body>
</html>