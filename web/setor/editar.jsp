<%-- 
    Document   : editar
    Created on : 24 de nov. de 2025, 20:57:21
    Author     : João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolito
--%>

<%@page import="dao.SetorDAO"%>
<%@page import="model.Setor"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    SetorDAO dao = new SetorDAO();
    Setor s = dao.buscarPorId(id);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Setor</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/new.css">
</head>
<body class="gradient-bg">

    <div class="container">
    <h2>Editar Setor</h2>
        <form action="../SetorServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="acao" value="atualizar">
            <input type="hidden" name="id" value="<%= s.getId() %>">

            <div class="form-group">
                Nome:<br>
                <input type="text" name="nome" class="form-control" value="<%= s.getNome() %>" required><br>
            </div>
                
            <div class="form-group">
                Descrição:<br>
                <textarea name="descricao" class="form-control"><%= s.getDescricao() %></textarea><br>
            </div>  
             
            <div class="form-group">
                Responsável:<br>
                <input type="text" name="responsavel" class="form-control" value="<%= s.getResponsavel() %>"><br>
            </div>
                
            <div class="form-group">
                Foto Atual:<br>
                <% if (s.getFoto_base64() != null) { %>
                    <img src="data:image/png;base64,<%= s.getFoto_base64() %>" width="80">
                <% } else { %>
                    <img src="../assets/img/semfoto.png" width="80">
                <% } %>
                <br><br>
            </div>
            
            <div class="form-group">
                Nova Foto:<br>
                <input type="file" name="foto" class="form-control"><br>
            </div>
            <button class="btn-add">Salvar</button>
            <a href="listar.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
