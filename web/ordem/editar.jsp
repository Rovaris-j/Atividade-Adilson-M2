<%-- 
    Document   : editar
    Created on : 24 de nov. de 2025, 20:59:23
    Author     : João Pedro Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>

<%@page import="dao.OrdemDAO"%>
<%@page import="dao.SetorDAO"%>
<%@page import="dao.PecaDAO"%>
<%@page import="model.Ordem"%>
<%@page import="model.Setor"%>
<%@page import="model.Peca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    OrdemDAO odao = new OrdemDAO();
    SetorDAO sdao = new SetorDAO();
    PecaDAO pdao = new PecaDAO();

    Ordem ordem = odao.buscarPorId(id);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Ordem</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/new.css">
</head>
<body class="gradient-bg">
    
    <div class="container">
        <h2>Editar Ordem de Produção</h2>
        <form method="post" action="../OrdemServlet">
            <input type="hidden" name="acao" value="atualizar">
            <input type="hidden" name="id" value="<%= ordem.getId() %>">
            
            <div class="form-group">
                Número:<br>
                <input type="text" class="form-control" name="numero" value="<%= ordem.getNumero() %>" required><br>
            </div>
            
            <div class="form-group">
                Setor:<br>
                <select name="id_setor" class="form-control">
                    <% for (Setor s : sdao.listar()) { %>
                    <option value="<%= s.getId() %>"
                        <%= (s.getId() == ordem.getId_setor() ? "selected" : "") %>>
                        <%= s.getNome() %>
                    </option>
                    <% } %>
                </select><br>
            </div>
                
            <div class="form-group">    
                Peça:<br>
                <select name="id_peca" class="form-control">
                    <% for (Peca p : pdao.listar()) { %>
                    <option value="<%= p.getId() %>"
                        <%= (p.getId() == ordem.getId_peca() ? "selected" : "") %>>
                        <%= p.getNome() %>
                    </option>
                    <% } %>
                </select><br>
            </div>

            <div class="form-group">
                Quantidade:<br>
                <input type="number" name="quantidade" class="form-control" value="<%= ordem.getQuantidade() %>" required><br>
            </div>
          
            <div class="form-group">
                Status:<br>
                <select name="status" class="form-control">
                    <option <%= ordem.getStatus().equals("Aguardando") ? "selected" : "" %>>Aguardando</option>
                    <option <%= ordem.getStatus().equals("Produção") ? "selected" : "" %>>Produção</option>
                    <option <%= ordem.getStatus().equals("Finalizado") ? "selected" : "" %>>Finalizado</option>
                </select><br>
            </div>

            <div class="form-group">
                Data:<br>
                <input type="date" class="form-control" name="data" value="<%= ordem.getData() %>" required><br><br>
            </div>
            <button class="btn-add">Salvar Alterações</button>
            <a href="listar.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
