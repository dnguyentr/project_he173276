<%-- 
    Document   : acc
    Created on : Oct 29, 2023, 11:22:19 PM
    Author     : PCMSI
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>


        <link href="css/accstyle.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.acc.rollnum==0}">
        <a href="index"><button  style="background-color: green" type="button" class="btn btn-primary">Back to home</button></a>
        <div class="container">
            <div class="row">
                <div class="col-12 mb-3 mb-lg-5">
                    <div class="overflow-hidden card table-nowrap table-card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Account</h5>

                        </div>
                        <div class="table-responsive">
                            <table class="table mb-0">
                                <thead class="small text-uppercase bg-body text-muted">
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Address</th>
                                        <th>Phone</th>
                                        <th>Rollnum</th>
                                        <th class="text-end">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listA}" var="o">
                                        <tr class="align-middle">
                                            <td>
                                                <div class="d-flex align-items-center">

                                                    <div>
                                                        <div class="h6 mb-0 lh-1">${o.uid}</div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>${o.name}</td>
                                            <td> <span class="d-inline-block align-middle">${o.address}</span></td>
                                            <td><span>${o.phone}</span></td>
                                            <td>${o.rollnum}</td>
                                            <td class="text-end">

                                                <a href="#!" class="dropdown-item">View Details</a>
                                                <c:if test="${o.rollnum!=0}">
                                                <a href="deletea?id=${o.uid}" class="dropdown-item">Delete user</a>
                                            </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:if>
        <c:if test="${sessionScope.acc.rollnum!=0}">
        <p >You must login to Admin account to manage account</p>
        <p><a href="login.jsp" style="color: #db4566;">Login</a>here</p>
        </c:if>
    </body>
</html>
