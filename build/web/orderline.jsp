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
        <a href="index"><button  style="background-color: green" type="button" class="btn btn-primary">Back to home</button></a>
        <div class="container">
            <div class="row">
                <div class="col-12 mb-3 mb-lg-5">
                    <div class="overflow-hidden card table-nowrap table-card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Order Line</h5>

                        </div>
                        <div class="table-responsive">
                            <table class="table mb-0">
                                <thead class="small text-uppercase bg-body text-muted">
                                    <tr>
                                        <th>No</th>
                                        <th>Name</th>
                                        <th>Order Date</th>
                                        <th>Latest delivery time</th>
                                        <th>Totalmoney</th>
                                        <th class="text-end">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                    <c:forEach items="${listO}" var="o">
                                        
                                            <tr class="align-middle">
                                                <td>
                                                    <div class="d-flex align-items-center">

                                                        <div>
                                                            <div class="h6 mb-0 lh-1">${o.id}</div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>${sessionScope.acc.name}</td>
                                            <td> <span class="d-inline-block align-middle">${o.date}</span></td>
                                            <td><span>${o.shipdate}</span></td>
                                            <td>${o.totalmoney}</td>
                                            <td class="text-end">

                                                <a href="" class="dropdown-item">View Details</a>
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
    </body>
</html>
