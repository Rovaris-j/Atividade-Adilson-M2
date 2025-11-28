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

import dao.OrdemDAO;
import model.Ordem;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

@WebServlet("/OrdemServlet")
public class OrdemServlet extends HttpServlet {

    // --- Permite usar GET (excluir pelo link)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // redireciona para o doPost
    }

    // --- Trata todas as ações
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String acao = request.getParameter("acao");
        OrdemDAO dao = new OrdemDAO();

        try {

            // --- CADASTRAR NOVA ORDEM ---
            if ("cadastrar".equals(acao)) {

                Ordem o = new Ordem();
                o.setNumero(request.getParameter("numero"));
                o.setId_setor(Integer.parseInt(request.getParameter("id_setor")));
                o.setId_peca(Integer.parseInt(request.getParameter("id_peca")));
                o.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                o.setStatus(request.getParameter("status"));
                o.setData(request.getParameter("data"));

                dao.cadastrar(o);
                response.sendRedirect("ordem/listar.jsp");
                return;
            }


            // --- EXCLUIR ---
            if ("excluir".equals(acao)) {

                int id = Integer.parseInt(request.getParameter("id"));

                dao.excluir(id);

                response.sendRedirect("ordem/listar.jsp");
                return;
            }


            // --- ATUALIZAR ---
            if ("atualizar".equals(acao)) {

                Ordem o = new Ordem();

                o.setId(Integer.parseInt(request.getParameter("id")));
                o.setNumero(request.getParameter("numero"));
                o.setId_setor(Integer.parseInt(request.getParameter("id_setor")));
                o.setId_peca(Integer.parseInt(request.getParameter("id_peca")));
                o.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                o.setStatus(request.getParameter("status"));
                o.setData(request.getParameter("data"));

                dao.atualizar(o);

                response.sendRedirect("ordem/listar.jsp");
                return;
            }


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Erro no OrdemServlet:</h2>");
            response.getWriter().println(e.getMessage());
        }
    }
}
