<%@ page import="java.util.List" %>
<%@ page import="Student.cn.bdqn.entity.Grade" %><%--
  Created by IntelliJ IDEA.
  User: 27225
  Date: 2020/1/14
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>分页查询</title>
  </head>
  <body>
  <%
    List<Grade> list=(List<Grade>)request.getAttribute("list");
    if (list==null){
      response.sendRedirect("grade.sv");
    }
  %>
  <table border="1px" width="500px">
    <tr>
      <td colspan="2">年级编号</td>
      <td colspan="2">年纪名称</td>
    </tr>
    <c:forEach items="${list}" var="list">
      <tr>
        <td colspan="2">${list.gradeid}</td>
        <td colspan="2">${list.gradename}</td>
      </tr>
    </c:forEach>
    <tr>
      <td><a href="grade.sv?Pageindex=1">首页</a> </td>
      <td><a href="grade.sv?Pageindex=${index-1}">上一页</a> </td>
      <td><a href="grade.sv?Pageindex=${index+1}">下一页</a></td>
      <td><a href="grade.sv?Pageindex=${count}">尾页</a></td>
    </tr>
  </table>
  </body>
</html>
