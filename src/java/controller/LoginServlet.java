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
import model.Usuario;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.buscarPorEmail(email);
        // LOGIN SEM CRIPTOGRAFIA 🔓
        if (u != null && senha.equals(u.getSenha())) {
            request.getSession().setAttribute("usuario", u);
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp?erro=1");
        }
    }
}
