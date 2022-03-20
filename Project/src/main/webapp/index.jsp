<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="css/Project.css">
    <link rel="stylesheet" href="css/Home.css">
    <script src="https://kit.fontawesome.com/fc7ebf84d2.js" crossorigin="anonymous"></script>
</head>
<body>
    <%@ include file="guide_bar.jsp"%>
    <main id="main">
        <div id="main_wrap">
            <div id="main_contents">
                <div class="container">
                    <div class="item">
                        <div class="two_box_row">
                            <div class="home1 home_content" style="background-image: url(Image/playstation.jpg);">
                                <div class="home_content_link">
                                    <a href="Playstation.do">Playstation</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="two_box_column">
                            <div class="home2 home_content" style="background-image: url(Image/xbox.jpg);">
                                <div class="home_content_link">
                                    <a href="Xbox.do">Xbox</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="two_box_row">
                            <div class="home3 home_content" style="background-image: url(Image/nintendo.png);">
                                <div class="home_content_link">
                                    <a href="Nintendo.do">Nintendo</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="one_box">
                            <div class="home4 home_content" style="background-image: url(Image/PC.jpg);">
                                <div class="home_content_link">
                                    <a href="PC.do">PC</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="one_box">
                            <div class="home5 home_content" style="background-image: url(Image/Arcade.png);">
                                <div class="home_content_link">
                                    <a href="Arcade.do">Arcade/Retro</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="one_box">
                            <div class="home6 home_content" style="background-image: url(Image/mobile.jpg)">
                                <div class="home_content_link">
                                    <a href="Mobile.do">Mobile</a>
                                </div>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>
    </main>
    <footer id="footer">
        <div id="footer_wrap">
            <h1>Portfolio project K.A.R</h1>
        </div>
    </footer>
    <script src="js/Basic.js"></script>
</body>

</html>