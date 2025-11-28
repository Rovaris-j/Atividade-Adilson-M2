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

import dao.SetorDAO;
import model.Setor;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.*;
import java.util.Base64;

@WebServlet("/SetorServlet")
@MultipartConfig
public class SetorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");

        SetorDAO dao = new SetorDAO();

        try {

            // =============== CADASTRAR ===============
            if ("cadastrar".equals(acao)) {

                Setor s = new Setor();
                s.setNome(request.getParameter("nome"));
                s.setDescricao(request.getParameter("descricao"));
                s.setResponsavel(request.getParameter("responsavel"));

                Part foto = request.getPart("foto");
                processarFoto(s, foto, request);

                dao.cadastrar(s);
                response.sendRedirect("setor/listar.jsp");
                return;
            }

            // =============== ATUALIZAR ===============
            if ("atualizar".equals(acao)) {

                Setor s = new Setor();
                s.setId(Integer.parseInt(request.getParameter("id")));
                s.setNome(request.getParameter("nome"));
                s.setDescricao(request.getParameter("descricao"));
                s.setResponsavel(request.getParameter("responsavel"));

                Part foto = request.getPart("foto");
                processarFoto(s, foto, request);

                dao.atualizar(s);
                response.sendRedirect("setor/listar.jsp");
                return;
            }

            // =============== EXCLUIR ===============
            if ("excluir".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.excluir(id);
                response.sendRedirect("setor/listar.jsp");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Erro no SetorServlet:</h2><pre>" + e + "</pre>");
        }
    }

    private void processarFoto(Setor s, Part foto, HttpServletRequest request) throws IOException {

        if (foto == null || foto.getSize() == 0) return;

        String nomeArquivo = Paths.get(foto.getSubmittedFileName()).getFileName().toString();
        String caminho = request.getServletContext().getRealPath("/assets/uploads/");

        Files.createDirectories(Paths.get(caminho));

        foto.write(caminho + File.separator + nomeArquivo);
        s.setFoto(nomeArquivo);

        byte[] bytes = Files.readAllBytes(Paths.get(caminho + File.separator + nomeArquivo));
        s.setFoto_base64(Base64.getEncoder().encodeToString(bytes));
    }
}

