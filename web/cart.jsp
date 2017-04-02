<%-- 
    Document   : cart
    Created on : Oct 3, 2016, 12:13:45 AM
    Author     : MuHamd Gomaa
--%>

<%@page import="entity.items"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>your data</title>
    </head>
    <body>
<% List <items> list = (List<items>) session.getAttribute("att");%>
    
    
        <form method="get" action="productcontroller">
                        <a href="index.jsp">Continue shopping</a>

            <table border="1">
                <caption>u order</caption>
                <tr>
                    <th>option</th>
                                <th>id</th>
                <th>name</th>
                <th>price</th>
                <th>quantity</th>
                <th>total</th>
                </tr>
      <%
        int num = 0;
                 for(items it:list)  {           
                  num +=( it.getQuantity() * it.getP().getPrice());
                              
                              
                 %>
                 <tr>
              <td ><a href="productcontroler?id=<%=it.getP().getId()%>&action=delete" onclick="return confirm('Are you sure')">Delete</a></td>
              <td><%=it.getP().getId()%></td>
                                   <td><%=it.getP().getName()%></td>
              <td><%=it.getP().getPrice()%></td>
              <td><%=it.getQuantity()%></td>
              <td><%=it.getP().getPrice()*it.getQuantity()%></td>

                     
                                     </tr>
 
                     
                 <%}%>  
                 <Tr>
                 <td colspan="5"> sum is :<%=num%></td> 
                     </Tr>
                 
                 
                
            </table>       
            
            
            
            
        </form>
    
    
    
    
    
    
    
    
    
    
    
    
    



    </body>
</html>
