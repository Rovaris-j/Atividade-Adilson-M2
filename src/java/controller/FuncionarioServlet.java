/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/*
 João Pedro Ventura Rovaris
 Gustavo Figueredo
 Guilherma Napolitano
 */

import dao.FuncionarioDAO;
import model.Funcionario;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.*;
import java.io.*;
import java.util.Base64;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig
@WebServlet("/FuncionarioServlet")
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response); // para excluir via GET
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String acao = request.getParameter("acao");
        FuncionarioDAO dao = new FuncionarioDAO();

        // ========= CADASTRAR =========
        if ("cadastrar".equals(acao)) {

            Funcionario f = new Funcionario();

            f.setNome(request.getParameter("nome"));
            f.setCpf(request.getParameter("cpf"));
            f.setEmail(request.getParameter("email"));
            f.setTelefone(request.getParameter("telefone"));
            f.setCargo(request.getParameter("cargo"));

            // Foto
            Part foto = request.getPart("foto");
            processarFoto(f, foto, request);

            dao.cadastrar(f);
            response.sendRedirect("funcionario/listar.jsp");
        }

        // ========= ATUALIZAR =========
        if ("atualizar".equals(acao)) {

            Funcionario f = new Funcionario();

            f.setId(Integer.parseInt(request.getParameter("id")));
            f.setNome(request.getParameter("nome"));
            f.setCpf(request.getParameter("cpf"));
            f.setEmail(request.getParameter("email"));
            f.setTelefone(request.getParameter("telefone"));
            f.setCargo(request.getParameter("cargo"));

            Part foto = request.getPart("foto");
            processarFoto(f, foto, request);

            dao.atualizar(f);
            response.sendRedirect("funcionario/listar.jsp");
        }

        // ========= EXCLUIR =========
        if ("excluir".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.excluir(id);
            response.sendRedirect("funcionario/listar.jsp");
        }
    }

    // PROCESSAMENTO DE FOTO
    private void processarFoto(Funcionario f, Part foto, HttpServletRequest request) throws IOException {

        if (foto != null && foto.getSize() > 0) {

            String nomeArquivo = Paths.get(foto.getSubmittedFileName()).getFileName().toString();

            // salva no servidor
            String caminho = request.getServletContext().getRealPath("/assets/uploads/");
            Files.createDirectories(Paths.get(caminho));
            foto.write(caminho + File.separator + nomeArquivo);

            f.setFoto(nomeArquivo);

            // Converte para Base64
            byte[] bytes = Files.readAllBytes(Paths.get(caminho + File.separator + nomeArquivo));
            String base64 = Base64.getEncoder().encodeToString(bytes);

            f.setFoto_base64(base64);
        }
    }
}
