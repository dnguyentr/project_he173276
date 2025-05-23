<%-- 
    Document   : signup
    Created on : Oct 22, 2023, 9:04:36 PM
    Author     : PCMSI
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!---Coding By CoderGirl | www.codinglabweb.com--->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <!---Custom CSS File--->
  <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <a href="index"><button style="background-color: peachpuff" type="button" class="btn btn-primary">Back to home</button></a>
  <div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
      <header>Forgot password</header>
      <form action="forgot">
          <p style="color: #db4566;">${mess1}${mess2}</p>
        <input name="user" type="text" placeholder="Enter your user">

        <input name="phone" type="text" placeholder="Phone number">
        <p>Security Question:</p>
        <select name="sq">
            <option>--select your question--</option>
            <c:forEach items="${listSQ}" var="o">
                
            <option value="${o.id}" >${o.qs}</option>
            
            </c:forEach>
            
        </select>
        <input name="ans" type="text" placeholder="Enter your answer" required="">
        <input name="newpass" type="text" placeholder="Enter your new password" required="">

      
        <input type="submit" class="button" value="Submit">
      </form>
      <div class="signup">
        <span class="signup">Already have an account?
            <a style="color: #db4566;" href="login.jsp">Login</a>
        </span>
      </div>
    </div>
    
  </div>
</body>
</html>
