<%-- 
    Document   : taskbar
    Created on : Oct 22, 2023, 12:39:38 PM
    Author     : PCMSI
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header_section">
    <nav class="navbar navbar-expand-lg custom_nav-container ">
        <a class="navbar-brand" href="index">
            <span>
                LVSHOP
            </span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class=""></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav  ">
                <li class="nav-item active">
                    <a class="nav-link" href="index">Home <span class="sr-only">(current)</span></a>
                </li>
                <c:if test="${sessionScope.acc.rollnum!=0}">
                    <li class="nav-item">
                        <a class="nav-link" href="why.jsp">
                            Why Us
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="contact.jsp">Contact Us</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc.rollnum==0}">
                    <li class="nav-item">
                        <a class="nav-link" href="acc">Account</a>
                    </li>                            
                    <li class="nav-item">
                        <a class="nav-link" href="manager">Manager Product</a>
                    </li>
                </c:if>
            </ul>
            <div class="user_option">
                <c:if test="${sessionScope.acc!=null}">

                    <a class="nav-link" href="user.jsp">Hello ${sessionScope.acc.user} </a>

                    <a href="logout">
                        <i class="fa fa-user" aria-hidden="true"></i>
                        <span>
                            Logout
                        </span>
                    </a>
                </c:if>
                <c:if test="${sessionScope.acc==null}">
                    <a href="login.jsp">
                        <i class="fa fa-user" aria-hidden="true"></i>
                        <span>
                            Login
                        </span>
                    </a>
                </c:if>
                    <c:if test="${sessionScope.acc.rollnum!=0}">
                <a href="cart.jsp">
                    <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                </a>
                    </c:if>
                <form action="search" method="post" class="form-inline my-2 my-lg-0">
                    <div class="input-group input-group-sm">
                        <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-secondary btn-number">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </nav>
</header>