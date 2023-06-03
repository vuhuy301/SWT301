<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sportsmagazine-topstrip">
    <jsp:useBean class="DAL.CommonForJSP" id="parse" />
    <div class="container">
        <div class="row">
            <aside class="col-md-4">
                <ul class="sportsmagazine-social-network">
                    <li><a href="#" class="sportsmagazine-colorhover fa fa-facebook-official"></a></li>
                    <li><a href="#" class="sportsmagazine-colorhover fa fa-twitter-square"></a></li>
                    <li><a href="#" class="sportsmagazine-colorhover fa fa-linkedin-square"></a></li>
                    <li><a href="#" class="sportsmagazine-colorhover fa fa-google-plus-square"></a></li>
                </ul>
            </aside>
            <aside class="col-md-8">
                <ul class="sportsmagazine-user-section">
                    <li><i class="fa fa-globe"></i> <a href="#">Support</a></li>
                    <li><i class="fa fa-shopping-cart"></i> <a href="#" class="sportsmagazine-open-cart">Cart (${size})</a>
                        <div class="sportsmagazine-cart-box">
                            <h2>You have ${size} items in the cart</h2>
                            <ul>
                                <c:forEach items="${cart.items}" var="item">
                                    <li>
                                        <figure>
                                            <a href="#"><img style='max-height: 70px; max-width: 70px' src="" alt="Ảnh SP:> Cơ mà lười thêm"></a>
                                        </figure>
                                        <div class="sportsmagazine-cartbox-text">
                                            <h6><a href="#">${item.product.name} x ${item.quantity}</a></h6>
                                            <div >${item.product.category.title}</div>
                                            <span class="sportsmagazine-cartbox-price sportsmagazine-color">${parse.getFormatPrice(item.product.price)} VND</span>
                                        </div>
                                    </li>
                                </c:forEach>

                            </ul>
                            <h5>Subtotal <span class="sportsmagazine-color">${parse.getFormatPrice(cart.totalMoney)}</span></h5>
                            <div class="sportsmagazine-cart-link">
                                <a href="cart" class="sportsmagazine-cartbox-btn sportsmagazine-bgcolorhover">
                                    <i class="flaticon-tool"></i> Go Cart
                                </a>
                                <a href="checkout" class="sportsmagazine-cartbox-btn sportsmagazine-bgcolorhover">
                                    <i class="flaticon-tool"></i> Go to Checkout

                                </a>

                            </div>
                        </div>
                    </li>
                    <c:if test="${account != null}">
                        <li><i class="fa fa-user"></i> <a href="profiles" >Hello, ${account.userName}</a></li>
                        <li><i class="fa fa-unlock-alt"></i> <a href="changePass">Change Password</a></li>
                        <li><i class="fa fa-shopping-bag"></i> <a href="myorder">My Order</a></li>
                        <li><i class="fa fa-sign-out"></i> <a href="logout">Logout</a></li>
                        </c:if>

                    <c:if test="${account == null}">
                        <li><i class="fa fa-user"></i> <a href="login" >Login</a></li>
                        <li><i class="fa fa-user-plus"></i> <a href="register">Register</a></li>
                        </c:if>

                </ul>
            </aside>
        </div>
    </div>
</div>