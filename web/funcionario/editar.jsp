<%-- 
    Document   : editar
    Created on : 26 de nov. de 2025, 22:58:39
    Author     : João Rovaris
                 Gustavo Figueredo
                 Guilherme Napolitano
--%>
<%@page import="dao.FuncionarioDAO"%>
<%@page import="model.Funcionario"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    FuncionarioDAO dao = new FuncionarioDAO();
    Funcionario f = dao.buscarPorId(id);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Funcionário</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/new.css">
</head>
<body class="gradient-bg">

    <div class="container">
        <h2>Editar Funcionário</h2>
        <form action="../FuncionarioServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="acao" value="atualizar">
            <input type="hidden" name="id" value="<%= f.getId() %>">
            
            <div class="form-group">
                <label>Nome</label>
                <input type="text" name="nome" class="form-control" value="<%= f.getNome() %>" required>
            </div>

            <div class="form-group">
                <label>CPF</label>
                <input type="text" name="cpf" class="form-control" value="<%= f.getCpf() %>" required>
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" class="form-control" value="<%= f.getEmail() %>" required>
            </div>

            <div class="form-group">
                <label>Telefone</label>
                <input type="text" name="telefone" class="form-control" value="<%= f.getTelefone() %>">
            </div>

            <div class="form-group">
                <label>Cargo</label>
                <input type="text" name="cargo" class="form-control" value="<%= f.getCargo() %>">
            </div>

            <div class="form-group">
                <label>Foto Atual</label><br>
                    <% if (f.getFoto_base64() != null) { %>
                        <img src="data:image/*;base64,<%= f.getFoto_base64() %>" width="90">
                    <% } else { %>
                        <span>Sem foto</span>
                    <% } %>
            </div>

            <div class="form-group">
                <label>Nova Foto</label>
                <input type="file" name="foto" class="form-control">
            </div>
            <button class="btn-add">Salvar</button>
            <a href="listar.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
