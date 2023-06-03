<%-- 
    Document   : cart
    Created on : 23-05-2023, 22:14:29
    Author     : phanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>Cart</title>

    </head>
    <body>

        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp" />
            <!--// Header \\-->
            
            <jsp:useBean class="DAL.CommonForJSP" id="common" />

            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content">

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section sportsmagazine-shopping-cartfull">
                    <div class="container">
                        <div class="row">

                            <div class="col-md-8">
                                <div class="sportsmagazine-shopping-cart">
                                    <h4>Your Shopping cart</h4>
                                    <table class="sportsmagazine-client-detail">
                                        <tr>
                                            <th>Product Info</th>
                                            <th>Price</th>
                                            <th>Size</th>
                                            <th>Color</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                        </tr>
                                        <c:forEach items="${cart.items}" var="item">
                                            <tr>
                                                <td>
                                                    <figure><img src="" alt="Ảnh SP? Lười Thêm"></figure>
                                                    <div class="player-stats-text">
                                                        <h6>${item.product.name}</h6>
                                                        <div>${item.product.category.title}</div>
                                                    </div>
                                                </td>
                                                <td>${common.getFormatPrice(item.product.price)} VND</td>
                                                <td>${item.size} </td>
                                                <td><a class="color-change one" href="#">${item.color}</a></td>
                                                <td><input name="quantity" min="01" max="10" type="number" value="${item.quantity}"></td>
                                                <td>${common.getFormatPrice(item.subTotal)}<a class="remove-line" href="#"><i class="fa fa-times"></i></a></td>
                                            </tr>
                                        </c:forEach>

                                    </table>

                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="sportsmagazine-cart-total sportsmagazine-shopping-cart-total">
                                    <h4>Cart Totals</h4>
                                    <ul>
                                        <li>
                                            <h6>Cart Subtotal</h6>
                                            <span>${common.getFormatPrice(cart.totalMoney)} VND</span>
                                        </li>
                                        
                                        
                                        <li class="total-cart">
                                            <h6>Cart Total</h6>
                                            <span>${common.getFormatPrice(cart.totalMoney)} VND</span>
                                        </li>
                                    </ul>
                                    <span><a href="checkout" class="cart-checkout-btn">Place Your Order Now</a></span>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
                <!--// Main Section \\-->

            </div>
            <!--// Main Content \\-->

            <!--// Footer \\-->
            <jsp:include page="common/footer/footer.jsp" />
            <!--// Footer \\-->

            <div class="clearfix"></div>
        </div>
        <!--// Main Wrapper \\-->

        <jsp:include page="common/plugins/link.jsp" />

    </body>

</html>
