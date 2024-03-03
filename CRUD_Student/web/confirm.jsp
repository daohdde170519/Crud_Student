<%-- 
    Document   : cònirm
    Created on : Jan 30, 2024, 6:51:03 PM
    Author     : DAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sv" class="model.Student" scope="session" />
<jsp:setProperty name="sv" property="*" />
<!-- start the middle column -->
<html>
<header>
    <h1>Confirm Student </h1>
</header>
<body>
    <form action="SaveServlet" method="POST">
        <LI>Student Name: ${sv.name}
        <LI>Student Gender: ${sv.gender}
        <LI>Student DOB: ${sv.dob}
            <hr>    
        <input type="submit" value="Confirm" />
        <input type="button" value="Back" onclick="javascript:history.go(-1);" />
    </form>
</body>
</html>
