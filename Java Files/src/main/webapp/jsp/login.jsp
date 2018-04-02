<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flashcard App: Login</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <style>
            
            #login-div {
                border-style: solid;
                border-color: rgba(54,100,139);
                display: block;
                margin: auto;
                width: 38%;
                background-color: rgba(184,206,217);
                margin-top: 2%;

            }
            
            #login-form-div {
                margin-top: 3%;
            }

            #search-button {
                background-color: rgba(236,253,255);
                margin-left: 68%;
                margin-bottom: 3%;
            }
            
            #search-button:hover {
                background-color: rgba(54,100,139);
            }

            h1, h2, h3 {
                text-align: center;
            }

            
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <h1>Flashcard App</h1>
            <hr/>
            <h2> Login Page </h2>
            <c:if test="${param.login_error ==1}">
                <h3>Wrong id or password!</h3>
            </c:if>
            <div class="row" id="login-div">
                <div class="col-md-12" id="login-form-div">
                    <form class="form-horizontal"
                          role="form"
                          method="post"
                          action="j_spring_security_check">
                        <div class="form-group">
                            <label for="j_username" class="col-md-4 control-label">Username:</label>
                            <div class="col-md-8">
                                <input type="text" 
                                       class="form-control" 
                                       name="j_username" 
                                       placeholder="Username"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="j_password" class="col-md-4 control-label">Password:</label>
                            <div class="col-md-8">
                                <input type="text" 
                                       class="form-control" 
                                       name="j_password" 
                                       placeholder="Password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" 
                                       class="btn btn-default" 
                                       id="search-button" 
                                       value="Login"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

