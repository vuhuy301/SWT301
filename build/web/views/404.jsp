
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>404</title>
    </head>
    <body>

        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp" />
            <!--// Header \\-->

            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content sportsmagazine-error-page">
                <span class="sportsmagazine-error-transparent"></span>

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section sportsmagazine-error-pagefull">
                    <div class="container">
                        <div class="row">

                            <div class="col-md-12">
                                <div class="sportsmagazine-error-wrap">
                                    <div class="sportsmagazine-error-heading">
                                        <span class="error-shape-one">4</span>
                                        <span class="error-shape-two"><small></small>0</span>
                                        <span class="error-shape-three">4</span>
                                    </div>
                                    <h3>NOT FOUND</h3>
                                    <span>The requested page cannot be found</span>
                                    <p>Can't find what you need? Take a moment and do a search below.</p>
                                    <form>
                                        <input type="text" value="Type here" >
                                        <label>
                                            <input type="submit" value="Search">
                                        </label>
                                    </form>
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
