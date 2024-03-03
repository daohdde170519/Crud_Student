<%-- 
    Document   : update
    Created on : Feb 25, 2024, 4:32:14 PM
    Author     : DAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Update Student</title>
</head>
<body>
    <h1>Update Student</h1>
    <form action="EditServlet2" method="post">
        <table>
            <tr>
                <td><input type='hidden' name='id' value="${student.id}"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${student.name}"/></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><input type="text" name="gender" value="${student.gender}"/></td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><input type="text" name="dob" value="${student.dob}"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Edit & Save "/></td>
            </tr>
        </table>
    </form>
</body>
</html>

