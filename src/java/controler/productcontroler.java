/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import entity.hiber_data;
import entity.items;
import java.io.IOException;
import java.io.PrintWriter;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MuHamd Gomaa
 */
@WebServlet(name = "productcontroler", urlPatterns = {"/productcontroler"})
public class productcontroler extends HttpServlet {

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
        PrintWriter out = response.getWriter();
  
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

    String action = request.getParameter("action");
        
   hiber_data pm=new hiber_data();
   
        HttpSession session = request.getSession();
        if(action.equals("ordernow")){
        if(session.getAttribute("att")==null){
        List <items> cart= new ArrayList<items>();
        cart.add(new items(pm.find(Integer.parseInt(request.getParameter("id"))), 1));
                        session.setAttribute("att", cart);

        }else{
        List <items> list=(List <items>)session.getAttribute("att");
        int index=isexsist(Integer.parseInt(request.getParameter("id")), list);
        if(index== -1){
        
                            list.add(new items(pm.find(Integer.parseInt(request.getParameter("id"))), 1));

        }else{
        int qu =list.get(index).getQuantity()+1;
        list.get(index).setQuantity(qu);
        
        }
                        session.setAttribute("att", list);

        }}else if(request.getParameter("action").equals("delete")){
            List<items> list =(List<items>) session.getAttribute("att");
        int index=isexsist(Integer.parseInt(request.getParameter("id")), list);
        list.remove(index);
        session.setAttribute("att", list);
        
        
        }

   


           request.getRequestDispatcher("cart.jsp").forward(request, response);
 
    }
public int isexsist(int id,List<items> list){
for(int i=0;i<list.size();i++){
if(list.get(i).getP().getId()==id){

return i;
}

}

return -1;
}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }

    
