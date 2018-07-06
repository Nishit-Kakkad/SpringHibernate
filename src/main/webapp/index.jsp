<%-- 
    Document   : index
    Created on : 6 Jul, 2018, 2:56:10 PM
    Author     : Nishit-TCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tusk</title>
    </head>
    <body>
        <form action="AddFeedback" method="post">
            <label>Name : </label>
            <input type="text" name="name" placeholder="Enter your name"> <br>
            <label>Email : </label>
            <input type="email" name="email" placeholder="Enter email address"> <br>
            <label>Regarding : </label>
            <select name="regarding">
                <option value="1">Youtube</option>
                <option value="2">Premium Tutorials</option>
            </select> <br>
            <label>Message : </label>
            <textarea name="message" placeholder="Enter message"></textarea>
            <label>Code : </label>
            <input type="text" name="code" placeholder="Enter code"> <br>
            <label>Rating : </label>
            <select name="rating">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select> <br>
            <input type="submit" value="Submit">
        </form>
        <%= request.getAttribute("result") %>
    </body>
</html>
