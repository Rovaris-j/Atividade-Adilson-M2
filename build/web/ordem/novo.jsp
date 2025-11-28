<%-- 
    Document   : novo
    Created on : 24 de nov. de 2025, 20:59:16
    Author     : João Pedro Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>
<%@page import="dao.SetorDAO"%>
<%@page import="dao.PecaDAO"%>
<%@page import="model.Setor"%>
<%@page import="model.Peca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    SetorDAO sdao = new SetorDAO();
    PecaDAO pdao = new PecaDAO();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Nova Ordem</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/new.css">
</head>

<body class="gradient-bg">
    <div class="container">
        <h2>Criar Nova Ordem de Produção</h2>
        <form action="../OrdemServlet" method="post">
            <input type="hidden" name="acao" value="cadastrar">
            
            <div class="form-group">
                Número:<br>
                <input type="text" name="numero" class="form-control" required><br>
            </div>
            
            <div class="form-group">
                Setor:<br>
                <select name="id_setor" class="form-control">
                    <% for (Setor s : sdao.listar()) { %>
                        <option value="<%= s.getId() %>"><%= s.getNome() %></option>
                    <% } %>
                </select><br>
            </div>
            
            <div class="form-group">
                Peça:<br>
                <select name="id_peca" class="form-control">
                    <% for (Peca p : pdao.listar()) { %>
                        <option value="<%= p.getId() %>"><%= p.getNome() %></option>
                    <% } %>
                </select><br>
            </div>
                
            <div class="form-group">
                Quantidade:<br>
                <input type="number" name="quantidade" class="form-control" required><br>
            </div>
                
            <div class="form-group">
                Data:<br>
                <input type="date" name="data" class="form-control" required><br>
            </div>
                
            <div class="form-group">
                Status:<br>
                <select name="status" class="form-control">
                    <option>Aguardando</option>
                    <option>Produção</option>
                    <option>Finalizado</option>
                </select>
                <br>
            </div>
                <button class="btn-add">Salvar</button>
                <a href="listar.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
