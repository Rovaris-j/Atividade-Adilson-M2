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

import dao.PecaDAO;
import model.Peca;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.*;
import java.util.Base64;

@WebServlet("/PecaServlet")
@MultipartConfig
public class PecaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");

        PecaDAO dao = new PecaDAO();

        try {

            // =============== CADASTRAR ===============
            if ("cadastrar".equals(acao)) {

                Peca p = new Peca();
                p.setNome(request.getParameter("nome"));
                p.setPeso(Double.parseDouble(request.getParameter("peso")));
                p.setDescricao(request.getParameter("descricao"));

                Part foto = request.getPart("foto");
                processarFoto(p, foto, request);

                dao.cadastrar(p);
                response.sendRedirect("peca/listar.jsp");
                return;
            }

            // =============== ATUALIZAR ===============
            if ("atualizar".equals(acao)) {

                Peca p = new Peca();
                p.setId(Integer.parseInt(request.getParameter("id")));
                p.setNome(request.getParameter("nome"));
                p.setPeso(Double.parseDouble(request.getParameter("peso")));
                p.setDescricao(request.getParameter("descricao"));

                Part foto = request.getPart("foto");
                processarFoto(p, foto, request);

                dao.atualizar(p);
                response.sendRedirect("peca/listar.jsp");
                return;
            }

            // =============== EXCLUIR ===============
            if ("excluir".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.excluir(id);
                response.sendRedirect("peca/listar.jsp");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Erro no PecaServlet:</h2><pre>" + e + "</pre>");
        }
    }

    private void processarFoto(Peca p, Part foto, HttpServletRequest request) throws IOException {

        if (foto == null || foto.getSize() == 0) return;

        String nomeArquivo = Paths.get(foto.getSubmittedFileName()).getFileName().toString();
        String caminho = request.getServletContext().getRealPath("/assets/uploads/");

        Files.createDirectories(Paths.get(caminho));

        foto.write(caminho + File.separator + nomeArquivo);
        p.setFoto(nomeArquivo);

        byte[] bytes = Files.readAllBytes(Paths.get(caminho + File.separator + nomeArquivo));
        p.setFoto_base64(Base64.getEncoder().encodeToString(bytes));
    }
}
