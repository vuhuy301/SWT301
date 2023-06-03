package Controller;

import DAL.AccountDAO;
import DAL.Common;
import DAL.SuportForMail;
import DAL.SuportMessage;
import Model.Account;
import Model.Role;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Register_Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register_Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register_Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("views/register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();

        AccountDAO ad = new AccountDAO();

        if (!ad.checkExist(userName)) {
            boolean flag = ad.register(new Account(-1, userName, password, email, "", "", "", "", Common.getCurrentDate(), Common.getCurrentDate(), false, false, new Role()));

            if (flag) {
                SuportMessage.sendToast(session, 3, "A Code Has Send To Your Email !");
                SuportForMail.sendMail(email, 1);
            } else {
                boolean checkMail = ad.checkEmailExit(email);

                if (checkMail) {
                    SuportMessage.sendToast(session, 2, "Email Này Đã Tồn Tại !");
                } else {
                    SuportMessage.sendToast(session, 0, "Có Lỗi Xảy Ra. Thử Lại Sau !");
                }

            }
        } else {
            SuportMessage.sendToast(session, 2, "Tài Khoản Này Đã Tồn Tại !");

        }
        request.getRequestDispatcher("views/register.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
