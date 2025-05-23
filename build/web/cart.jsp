<%-- 
    Document   : cart
    Created on : Oct 24, 2023, 1:09:48 PM
    Author     : PCMSI
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Shopping Cart</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" rel="stylesheet" />
        <link href="css/cartstyle.css" rel="stylesheet">
    </head>

    <body>
        <a href="index"><button  style="background-color: green" type="button" class="btn btn-primary">Back to home</button></a>
        <section>
            <div class="container">
                <h2 class="px-5 p-2">My shopping cart</h2>
                <div class="cart">
                    <div class="col-md-12 col-lg-10 mx-auto">
                        <c:set value="${sessionScope.cart}" var="o"/>
                        <c:forEach items="${o.items}"  var="i">
                            <div class="cart-item">
                                <div class="row">
                                    <div class="col-md-7 center-item">
                                        <img src="${i.product.img}" alt="">
                                        <h5>${i.product.name}</h5>
                                    </div>

                                    <div class="col-md-5 center-item">
                                        <div >
                                            <button  class="btn btn-default"><a href="process?num=-1&id=${i.product.id}">-</a></button>
                                            <input width="70%" type="text" readonly value="${i.quantity}"/>
                                            <button  class="btn btn-default"><a href="process?num=1&id=${i.product.id}">+</a></button>
                                        </div>

                                        <h5>${i.quantity*i.price} </h5>
                                        <form action="process" method="post">
                                            <input type="hidden" name="id" value="${i.product.id}"/>
                                            <input type="submit" value="Remove"/>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="cart-item">
                                <div class="row g-2">

                                    <div class="col-6">
                                        
                                        <h5>Total:</h5>
                                    </div>

                                    <div class="col-6 status">
                                       
                                        <h5><span >${sessionScope.cart.getTotalMoney()}</span></h5>
                                    </div>

                                </div>
                            </div>
                        </c:forEach>



                        <form action="checkout" method="post">
                            <button type="submit" class="btn btn-success check-out">Check Out</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>

    </body>
</html>