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

import dao.UsuarioDAO;
import java.io.File;
import model.Usuario;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.Base64;

@WebServlet("/UsuarioServlet")
@MultipartConfig
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Usuario logado = (Usuario) sessao.getAttribute("usuario");

        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");

        Part foto = request.getPart("foto");
        String nomeArquivo = null;
        String base64 = null;

        if (foto != null && foto.getSize() > 0) {

            nomeArquivo = Paths.get(foto.getSubmittedFileName()).getFileName().toString();
            String caminhoUpload = getServletContext().getRealPath("/assets/uploads/");
            Files.createDirectories(Paths.get(caminhoUpload));
            Path destino = Paths.get(caminhoUpload + File.separator + nomeArquivo);
            foto.write(destino.toString());

            byte[] bytes = Files.readAllBytes(destino);
            base64 = Base64.getEncoder().encodeToString(bytes);

            logado.setFoto(nomeArquivo);
            logado.setFoto_base64(base64);
        }

        logado.setNome(nome);

        if (senha != null && !senha.isEmpty()) {
            logado.setSenha(senha);
        }

        UsuarioDAO dao = new UsuarioDAO();
        dao.atualizar(logado);

        sessao.setAttribute("usuario", logado);

        response.sendRedirect("perfil.jsp?ok=1");
    }
}
