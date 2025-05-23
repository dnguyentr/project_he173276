<%-- 
    Document   : loginnsignup
    Created on : Oct 22, 2023, 3:25:37 PM
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
    <a href="index"><button  style="background-color: peachpuff" type="button" class="btn btn-primary">Back to home</button></a>
  <div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
      <header>Login</header>
      <form action="login">
          <p style="color: #db4566;">${mess}</p>
        <input name="user" type="text" placeholder="Enter your user">
        <input name="pass" type="password" placeholder="Enter your password">
        <a style="color: #db4566;" href="forgotload">Forgot password?</a>
        <input type="submit" class="button" value="Login">
      </form>
      <div class="signup">
        <span class="signup">Don't have an account?
            <a style="color: #db4566;" href="signupload">Signup</a>
        </span>
          
      </div>
      
    </div>
    
  </div>
</body>
</html>