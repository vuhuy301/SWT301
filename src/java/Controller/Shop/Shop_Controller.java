/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Shop;

import DAL.CategoryDAO;
import DAL.ProductDAO;
import Model.Category;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author phanh
 */
public class Shop_Controller extends HttpServlet {

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
            out.println("<title>Servlet Shop_Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Shop_Controller at " + request.getContextPath() + "</h1>");
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

        ProductDAO pd = new ProductDAO();
        CategoryDAO cd = new CategoryDAO();
        List<Product> list = pd.getAll();

        String[] categoryID_raw = request.getParameterValues("cid");
        int[] categoryID = null;
        if (categoryID_raw != null && Integer.parseInt(categoryID_raw[0]) != 0) {
            categoryID = new int[categoryID_raw.length];
            for (int i = 0; i < categoryID.length; i++) {
                categoryID[i] = Integer.parseInt(categoryID_raw[i]);
            }

            list = pd.getProductByCid(categoryID);
            List<Category> listC = cd.getAll();
            boolean[] categoryCheck = new boolean[listC.size()];
            for (int i = 0; i < categoryCheck.length; i++) {
                if (ischeckCategory(listC.get(i).getId(), categoryID)) {
                    categoryCheck[i] = true;
                } else {
                    categoryCheck[i] = false;
                }
            }
            request.setAttribute("categoryCheck", categoryCheck);

            String categoryS = "";
            for (int i = 0; i < categoryID.length; i++) {
                if (i == categoryID.length - 1) {
                    categoryS += categoryID[i];
                } else {
                    categoryS += categoryID[i] + "&cid=";
                }
            }
            request.setAttribute("categoryS", categoryS);
        }

        int page, numberPerPage = 6;
        String xpage = request.getParameter("page");
        int size;
        if (list.isEmpty()) {
            size = 0;
        } else {
            size = list.size();
        }

        int numberOfPage = ((size % numberPerPage == 0) ? (size / numberPerPage) : (size / numberPerPage + 1));
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numberPerPage;
        end = Math.min(page * numberPerPage, size);

        List<Product> listByPage = pd.getListByPage(list, start, end);
        request.setAttribute("listByPage", listByPage);
        request.setAttribute("page", page);
        request.setAttribute("numberPage", numberOfPage);
        request.setAttribute("start", start + 1);
        request.setAttribute("end", end);
        request.setAttribute("totalItem", list.size());

        request.setAttribute("data", listByPage);
        request.getRequestDispatcher("views/shop.jsp").forward(request, response);
    }

    private boolean ischeckCategory(int categoryID, int[] list) {
        if (list == null) {
            return false;
        } else {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == categoryID) {
                    return true;
                }
            }
        }
        return false;
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
        processRequest(request, response);
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
