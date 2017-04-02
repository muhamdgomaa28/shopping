<%-- 
    Document   : index
    Created on : Oct 2, 2016, 11:10:25 PM
    Author     : MuHamd Gomaa
--%>

<%@page import="entity.hiber_data"%>
<%@page import="java.util.List"%>
<%@page import="entity.product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>shoppingg cart </title>
    </head>
    <body>
        <form method="get" action="productcontroler">
        <table border="1">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>price</th>
                <th>puy</th>

            </tr>
            <%hiber_data pm = new hiber_data();%>
            <%List <product> products = pm.findall();%>
            

         <%for(product p:products){%>
                <tr>
                    <td><%=p.getId()%></td>
                                        <td> <%=p.getName()%></td>
                                        <td> <%=p.getPrice()%></td>
                                        <td><a href="productcontroler?id=<%=p.getId()%>&action=ordernow"> order now</a> </td>

                </tr>
                <%}%>
                
        </table>
        
        </form>
    </body>
</html>
