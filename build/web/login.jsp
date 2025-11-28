<%-- 
    Document   : login
    Created on : 24 de nov. de 2025, 21:19:59
    Author     : PICHAU
--%>    

<%-- 
    Document   : login
    Created on : 24 de nov. de 2025, 21:19:59
    Author     : João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login - Sistema de Produção</title>
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
        <!-- CSS Externo-->
            <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body class="index-bg">
        <div class="container">
            <div class="container d-flex justify-content-center align-items-center vh-100">
                <div class="card p-4 shadow" style="width: 360px;">
                    <div class="logo">Sistema de Produção</div>
                
                <%
                    if (request.getParameter("erro") != null) {
                %>
                <div class="alert alert-danger text-center">
                    Usuário ou senha incorretos!
                </div>
                <%
                    }
                %>
                
                <form action="LoginServlet" method="post">
                    
                    <div class="mb-3">
                        <label class="form-label">E-mail</label>
                        <input type="email" name="email" class="form-control"
                            placeholder="Digite seu e-mail" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Senha</label>
                        <input type="password" name="senha" class="form-control"
                            placeholder="Digite sua senha" required>
                    </div>
                    
                        <button type="submit" class="btn btn-primary w-100">
                            Entrar
                        </button>
                </form>
            </div>
        </div>
        
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>