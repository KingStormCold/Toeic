<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  Date: 9/2/2017
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chào mừng bạn đến với Danh sách sinh viên</h1>
<%
    List<String> listStudent =new ArrayList<String>();
    listStudent.add("Tuấn");
    listStudent.add("Tuấn 2 ");
    listStudent.add("Tuấn 3 ");

%>
<table>
    <tr>
        <td>Name</td>
    </tr>
    <%
        for(String item:listStudent) {
    %>
    <tr>
        <td>
            <%=item%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
