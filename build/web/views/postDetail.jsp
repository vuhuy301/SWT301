<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>${post.title}</title>
    </head>
    <body>

        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp" />
            <!--// Header \\-->


            <jsp:useBean class="DAL.CommonForJSP" id="common" />
            <jsp:useBean class="DAL.AccountDAO" id="ad" />
            <jsp:useBean class="DAL.PostDAO" id="pd"/>

            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content sportsmagazine-main-contentminus">

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section sportsmagazine-thumb">
                    <span class="thumb-transparent"></span>
                    <div class="sportsmagazine-thumb-text">

                        <div class="container">
                            <div class="row">

                                <div class="col-md-12">
                                    <h2>${post.title}</h2>
                                    <ul class="sportsmagazine-thumb-option">
                                        <li><i class="fa fa-calendar-o"></i> ${common.formatDate(post.createDate, 'dd/MM/yyyy')}</li>
                                        <li><a href="404.html"><i class="fa fa-thumbs-o-up"></i> ${post.like}</a></li>
                                        <li><a href="404.html"><i class="fa fa-comments-o"></i> </a></li>
                                        <li><i class="fa fa-user"></i> ${ad.getAccountByID(post.ownerID).fullName}</li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <!--// Main Section \\-->

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section">
                    <div class="container">
                        <div class="row">

                            <div class="col-md-12">
                                <div class="sportsmagazine-rich-editor">
                                    <p>${post.detail}</p>

                                    <!--                                    <blockquote>Sed gravida, urna quis tempus sollicitudin, tellus urna suscipit nisl, id rhoncus ligula elit condi Suspendisse lacinia, risus et porta dignissim, elit tellus iaculis tellus, eget efficitur elit magna ellus tempor consectetur magna.
                                                                            <span></span>
                                                                        </blockquote>-->
                                    <div class="sportsmagazine-post-tags">
                                        <div class="sportsmagazine-tags">
                                            <a href="404.html">#Playoffs</a>
                                            <a href="404.html">#Injuries</a>
                                            <a href="404.html">#Teams</a>
                                            <a href="404.html">#Uniform</a>
                                        </div>
                                        <div class="sportsmagazine-blog-social">
                                            <ul>
                                                <li><a href="https://www.facebook.com/phanhieu000" class="color-one"><i class="fa fa-facebook"></i>facebook</a></li>
                                                <li><a href="#!" class="color-two"><i class="fa fa-twitter"></i>Twitter</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="sportsmagazine-prenxt-post">
                                    <ul>
                                        <li>
                                            <div class="sportsmagazine-prev-post">
                                                <figure><a href="404.html"><img src="views/extra-images/post-img1.jpg" alt=""></a></figure>
                                                <div class="sportsmagazine-prev-artical">
                                                    <h3><a href="404.html">The team is starting a new power breakfast regimen</a></h3>
                                                    <a href="404.html" class="sportsmagazine-post-arrow"><i class="fa fa-angle-double-left"></i> Previous Post</a>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="sportsmagazine-next-post">
                                                <figure><a href="404.html"><img src="views/extra-images/post-img2.jpg" alt=""></a></figure>
                                                <div class="sportsmagazine-next-artical">
                                                    <h3><a href="404.html">The team is starting a new power breakfast regimen</a></h3>
                                                    <a href="404.html" class="sportsmagazine-post-arrow">Next Post <i class="fa fa-angle-double-right"></i></a>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="sportsmagazine-section-heading"><h2>Related Articles</h2></div>
                                <div class="sportsmagazine-related-article sportsmagazine-blog-artical">
                                    <ul class="row">
                                        <li class="col-md-4">
                                            <figure><a href="blog-detail.html.html"><img src="views/extra-images/related-articel-img1.jpg" alt=""><i class="fa fa-link"></i></a></figure>
                                            <div class="sportsmagazine-article-text">
                                                <time datetime="2008-02-14 20:00">August 23rd, 2016</time>
                                                <h5><a href="blog-detail.html.html">Michael Bran as was chosen as best pl</a></h5>
                                            </div>
                                            <ul class="sportsmagazine-article-options">
                                                <li><a href="404.html"><i class="fa fa-thumbs-o-up"></i> 320</a></li>
                                                <li><a href="404.html"><i class="fa fa-eye"></i> 840</a></li>
                                                <li><a href="404.html"><i class="fa fa-share-alt"></i> 89</a></li>
                                            </ul>
                                        </li>
                                        <li class="col-md-4">
                                            <figure><a href="blog-detail.html.html"><img src="views/extra-images/related-articel-img2.jpg" alt=""><i class="fa fa-link"></i></a></figure>
                                            <div class="sportsmagazine-article-text">
                                                <time datetime="2008-02-14 20:00">August 23rd, 2016</time>
                                                <h5><a href="blog-detail.html.html">Michael Bran as was chosen as best pl</a></h5>
                                            </div>
                                            <ul class="sportsmagazine-article-options">
                                                <li><a href="404.html"><i class="fa fa-thumbs-o-up"></i> 320</a></li>
                                                <li><a href="404.html"><i class="fa fa-eye"></i> 840</a></li>
                                                <li><a href="404.html"><i class="fa fa-share-alt"></i> 89</a></li>
                                            </ul>
                                        </li>
                                        <li class="col-md-4">
                                            <figure><a href="blog-detail.html.html"><img src="views/extra-images/related-articel-img3.jpg" alt=""><i class="fa fa-link"></i></a></figure>
                                            <div class="sportsmagazine-article-text">
                                                <time datetime="2008-02-14 20:00">August 23rd, 2016</time>
                                                <h5><a href="blog-detail.html.html">Michael Bran as was chosen as best pl</a></h5>
                                            </div>
                                            <ul class="sportsmagazine-article-options">
                                                <li><a href="404.html"><i class="fa fa-thumbs-o-up"></i> 320</a></li>
                                                <li><a href="404.html"><i class="fa fa-eye"></i> 840</a></li>
                                                <li><a href="404.html"><i class="fa fa-share-alt"></i> 89</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                                <div class="comments-area">
                                    <!--// coments \\-->
                                    <div class="sportsmagazine-section-heading"><h2>Comments</h2></div>
                                    <ul class="comment-list">

                                        <c:forEach items="${pd.getCommentByPostID(post.id)}" var="item" >
                                            <c:set var="a" value="${ad.getAccountByID(item.aid)}"/>
                                            <li>
                                                <div class="thumb-list">
                                                    <figure><img alt="" src="views/extra-images/comment-img1.jpg"></figure>
                                                    <div class="text-holder">
                                                        <h6>${account.id == a.id ? 'You' : a.fullName == '' ? a.userName : a.fullName}</h6>
                                                        <time class="post-date" datetime="2008-02-14 20:00">${common.formatDate(item.createDate, 'dd/MM/yyyy')} </time>
                                                        <a class="comment-reply-link" href="#">Reply</a>
                                                    </div>
                                                    <p>${item.content}</p>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <!--// coments \\-->
                                    <!--// comment-respond \\-->
                                    <div class="comment-respond sportsmagazine-contact-form">
                                        <div class="sportsmagazine-section-heading"><h2>Write A Comment</h2></div>
                                        <c:if test="${account != null}">
                                            <form action="" method="POST">
                                                <input type="hidden" name="pid" value="${post.id}">
                                                <ul>
                                                    <li>
                                                        <label>Full Name:</label>
                                                        <p>
                                                            <input disabled value="${account.fullName == '' ? account.userName : account.fullName}" type="text">
                                                            <span><i class="fa fa-user"></i></span>
                                                        </p>
                                                    </li>
                                                    <li>
                                                        <label>Email:</label>
                                                        <p>
                                                            <input disabled value="${account.email}" type="text">

                                                            <span><i class="fa fa-envelope"></i></span>
                                                        </p>
                                                    </li>
                                                    <li class="full-input">
                                                        <label>Comment:</label>
                                                        <p>
                                                            <textarea name="content" placeholder="Viết Bình Luận Tại Đây !"></textarea>
                                                            <span><i class="fa fa-comment"></i></span>
                                                        </p>

                                                    </li>
                                                    <li>
                                                        <p><label><input value="Bình Luận" type="submit"></label></p>
                                                    </li>
                                                </ul>
                                            </form>
                                        </c:if>

                                        <c:if test="${account == null}">
                                            <h3 style="text-align: center">Đăng Nhập Để Có Thể Bình Luận. <a target="_blank" style="color: #078b4d" href="login">Here !</a></h3>
                                        </c:if>

                                    </div>
                                    <!--// comment-respond \\-->
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

        <jsp:include page="common/plugins/script.jsp" />

    </body>

</html>
