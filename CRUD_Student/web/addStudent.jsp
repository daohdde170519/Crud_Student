<%-- 
    Document   : student
    Created on : Jan 30, 2024, 3:31:31 PM
    Author     : DAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Student</title>
    </head>
    <body>
        <form action="confirm.jsp" method="post">
            <div>
                <label>Name:</label>
                <input type="text" name="name" />
            </div>
            <div>
                <label>Gender:</label>
                <input type="radio" name="gender" value="M" id="male" />
                <label for="male">Male</label>
                
                <input type="radio" name="gender" value="F" id="female" />
                <label for="female">Female</label>
                
                <input type="radio" name="gender" value="L" id="lgbt" />
                <label for="lgbt">LGBT</label>
            </div>
            <div>
                <label>Date of Birth:</label>
                <input type="text" name="dob" />
            </div>
            <div>
                <input type="submit" value="Add Student" />
            </div>
        </form>
    </body>
</html>

