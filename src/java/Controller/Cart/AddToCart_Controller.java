/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Cart;

import DAL.ProductDAO;
import Model.Cart.Cart;
import Model.Cart.Item;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author phanh
 */
public class AddToCart_Controller extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCart_Controller</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCart_Controller at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ProductDAO pd = new ProductDAO();
        List<Product> prods = pd.getAll();
        Cookie arr[] = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie item : arr) {
                if (item.getName().equals("cart")) {
                    txt += item.getValue();
                    item.setMaxAge(0);
                    response.addCookie(item);
                }
            }
        }
        
        String quantity_raw = request.getParameter("quantity");
        String productID = request.getParameter("id");
        int id = 0, quantity = 1;
        try {
            id = Integer.parseInt(productID);
            quantity = Integer.parseInt(quantity_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
            id = 0;
        }
        
        String color = request.getParameter("color");
        if (color == null || color.equals("")) {
            color = "";
        }
        
        String size = request.getParameter("size");
        if (size == null || size.equals("")) {
            size = "";
        }
        
        Cart cartCheck = new Cart(txt, prods);
        Product pcheckQuan = pd.getProductByID(id);
        
        if (txt.isEmpty()) {
            if (quantity < pcheckQuan.getQuantity()) {
                txt = productID + "_" + quantity + "/" + size + ":" + color;
            }

        } else if (cartCheck.getItemByProductID(id) == null) {
            if (quantity < pcheckQuan.getQuantity()) {
                txt += "-" + productID + "_" + quantity + "/" + size + ":" + color ;
            }

        } else if ((cartCheck.getQuantityByProductID(id) + quantity) >= pcheckQuan.getQuantity()) {

        } else {
            txt += "-" + productID + "_" + quantity+ "/" + size + ":" + color ;
        }
        System.out.println(txt);

        Cart cart = new Cart(txt, prods);

        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(24 * 60 * 60);
        response.addCookie(c);
        List<Item> listI = cart.getItems();
        request.setAttribute("cart", cart);
        request.setAttribute("size", listI.size());
        response.sendRedirect("home");
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
