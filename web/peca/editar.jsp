<%-- 
    Document   : editar
    Created on : 24 de nov. de 2025, 20:39:46
    Author     : João Pedro Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>
<%@page import="dao.PecaDAO"%>
<%@page import="model.Peca"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    PecaDAO dao = new PecaDAO();
    Peca p = dao.buscarPorId(id);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Peça</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/new.css">
</head>
<body class="gradient-bg">

    <div class="container">
    <h2>Editar Peça</h2>
        <form action="../PecaServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="acao" value="atualizar">
            <input type="hidden" name="id" value="<%= p.getId() %>">
            
            <div class="form-group">
                Nome:
                <input type="text" name="nome" class="form-control" value="<%= p.getNome() %>" required><br>
            </div>
                
            <div class="form-group">
                Peso (KG):
                <input type="number" step="0.01" name="peso" class="form-control" value="<%= p.getPeso() %>" required><br>
            </div>
                
            <div class="form-group">
                Descrição:<br>
                <textarea name="descricao" class="form-control"><%= p.getDescricao() %></textarea><br>
            </div>
                
            <div class="form-group">
                Foto atual:<br>
                <% if (p.getFoto_base64() != null) { %>
                    <img src="data:image/*;base64,<%= p.getFoto_base64() %>" width="120">
                <% } else { %>
                    <img src="../assets/img/semfoto.png" width="120">
                <% } %>
                <br><br>
            </div>
                
            <div class="form-group">
                Alterar foto:
                <input type="file" name="foto" class="form-control" accept="image/*"><br>
            </div>
            <button class="btn-add">Salvar Alterações</button>
            <a href="listar.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>

