<%-- 
    Document   : index
    Created on : Nov 1, 2014, 10:44:52 PM
    Author     : imrul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medical Calculator</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <style>
            .myLoadingImage{
                position: fixed;
                width: 100%;
                left: 0;
                top: 285px;
                display: none;
                z-index: 900000;
            }
            .myOverlay{
                background-color: #f2f2f2;
                position: absolute;
                top: -286px;
                left: 0;
                width: 100%;
                opacity: 0.6;
                z-index: 2000;
            }
            .imageForLoading
            {
                width: 70px;
                margin: 0 auto;
                z-index: 3000;
                position: relative;
            }
        </style>
        <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
        <script type="text/javascript" src="js/jquery.form.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="myLoadingImage">
            <div class="myOverlay" style="height: 1519px"></div>
            <div class="imageForLoading">
                <img src="<c:url value="/images/ajax-loader.gif"/>" alt="Loading" height="60" />
            </div>
        </div>
        <div class="container">    
            <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Medical Calculator Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                        <form id="loginform" class="form-horizontal" role="form" method="post" action="/loginServlet">

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username or email">                                        
                            </div>

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                            </div>



                            <div class="input-group">
                                <div class="checkbox">
                                    <label>
                                        <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                    </label>
                                </div>
                            </div>


                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls">
                                    <a id="btn-login" href="#" class="btn btn-success">Login  </a>
                                    <a id="btn-fblogin" href="#" class="btn btn-primary">Login with Facebook</a>

                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-12 control">
                                    <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                        Don't have an account! 
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Sign Up Here
                                        </a>
                                    </div>
                                </div>
                            </div>    
                        </form>     
                    </div>                     
                </div>  
            </div>
            <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Medical Calculator Sign Up</div>
                        <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                    </div>  
                    <div class="panel-body" >
                        <form id="signupform" class="form-horizontal" role="form" method="POST" action="/registrationServlet">

                            <div id="signupalert" style="display:none" class="alert alert-danger">
                                <p>Error:</p>
                                <span></span>
                            </div>

                            <div class="form-group">
                                <label for="email" class="col-md-3 control-label">Email</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="email" placeholder="Email Address">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="firstname" class="col-md-3 control-label">First Name</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="firstname" placeholder="First Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="lastname" placeholder="Last Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Password</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="password" placeholder="Password">
                                </div>
                            </div>

                            <!--                            <div class="form-group">
                                                            <label for="icode" class="col-md-3 control-label">Invitation Code</label>
                                                            <div class="col-md-9">
                                                                <input type="text" class="form-control" name="icode" placeholder="">
                                                            </div>
                                                        </div>-->

                            <div class="form-group">
                                <!-- Button -->                                        
                                <div class="col-md-offset-3 col-md-9">
                                    <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                    <span style="margin-left:8px;">or</span>  
                                </div>
                            </div>

                            <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">

                                <div class="col-md-offset-3 col-md-9">
                                    <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>   Sign Up with Facebook</button>
                                </div>                                           

                            </div>
                        </form>
                    </div>
                </div>
            </div> 
        </div>
    </body>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#btn-login").on("click", function(){
                var url = "./loginServlet";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: $('#loginform').serialize(),
                    success:function(data){
                        if(data.trim() == 503){
                            alert("Invalid Username Password");
                        }else{
                            window.location.href = "./userCalculationArea";
                        }
                    }
                });
                return false;
            });
                
            $("#btn-signup").on("click",function(){
                var url ="./registrationServlet";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: $('#signupform').serialize(),
                    success:function(data){
                        if(data.toString() == 200){
                            $('#signupform')[0].reset();
                            $("#signinlink").click();
                            alert("Registration Successfull");
                        }else{
                            alert("Registration Failed");
                            $('#signupform')[0].reset();
                        }
                    }
                });
                return false;
            });
            $(document).ajaxStart(function(){
                $(".myLoadingImage").show();
            });
            $(document).ajaxStop(function(){
                $(".myLoadingImage").hide();
            });
        })
    </script>
</html>
