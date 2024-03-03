<%-- 
    Document   : studentList
    Created on : Feb 25, 2024, 3:54:19 PM
    Author     : DAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student List</title>
</head>
<body>
    <a href='addStudent.jsp'>Add New Student</a>
    <h1>Students List</h1>
    <table border='1' width='100%'>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Date of Birth</th>
            <th>Action</th>
        </tr>
        <c:if test="${not empty studentList}">
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.gender}</td>
                    <td>${student.dob}</td>
                    <td>
                        <a href='EditServlet?id=${student.id}'>update</a> | 
                        <a href='DeleteServlet?id=${student.id}' onclick="return confirm('Are you sure you want to delete this student?');">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <%-- Pagination links --%>
    <c:if test="${totalPages > 1}">
        <div>
            <c:if test="${currentPage > 1}">
                <a href='ViewServlet?page=${currentPage - 1}'>Previous</a> | 
            </c:if>
            <c:forEach begin="${currentPage - 1}" end="${currentPage + 3}" varStatus="page">
                <c:if test="${page.index > 0 && page.index <= totalPages}">
                    <c:choose>
                        <c:when test="${page.index == currentPage}">
                            <strong>${page.index}</strong> | 
                        </c:when>
                        <c:otherwise>
                            <a href='ViewServlet?page=${page.index}'>${page.index}</a> | 
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </c:forEach>
            <c:if test="${currentPage < totalPages - 1}">
                <a href='ViewServlet?page=${currentPage + 1}'>Next</a>
            </c:if>
        </div>
    </c:if>

</body>
</html>

