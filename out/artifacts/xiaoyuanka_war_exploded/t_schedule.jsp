<%@ page import="java.util.List" %>
<%@ page import="com.user.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: Eltanin
  Date: 2022/7/9
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<style>
    body{
        font-family: 隶书;
        font-size: 30px;
        font-style: italic;
        letter-spacing: 10px;
        line-height: 30px;
        background-image: url("/2.jpg");
    }
    table{
        margin: auto;
        margin-top: 50px;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>课表</title>
</head>
<body>
<h1 style="text-align: center; font-family: 隶书; font-size: 40px">&nbsp;教师课表</h1>
<table border="1" cellpadding="20" cellspacing="0" style="font-size: 25px">
    <thead>
    <tr>
        <td></td>
        <td>星期一</td>
        <td>星期二</td>
        <td>星期三</td>
        <td>星期四</td>
        <td>星期五</td>
    </tr>
    </thead>
    <tbody id="contain"></tbody>
<%
    List<Course> arr = (List<Course>) request.getSession().getAttribute("couList");
    for (int i = 1; i <= 6; i++) {
        out.print("<tr>");
        out.print("<td>第"+i+"节</td>");
        for (int j = 1; j <= 5; j++){
            out.print("<td>");
            for (int z = 0; z < arr.size(); z++){
                if(arr.get(z).getNode()==i && arr.get(z).getWeek()==j){
                    out.print(arr.get(z).getCourse_name());
                }
            }
            out.print("</td>");
        }
        out.print("</tr>");
    }
%>
</table>
<p style="text-align: center; font-family: 隶书; font-size: 25px">
    <a href="teacher_port.html">返回</a>
</p>
</body>
</html>
