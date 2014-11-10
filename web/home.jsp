<!DOCTYPE html>
<html>
    <head>
        <title>Medical Calculator</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="<c:url value="css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="css/ajaxOverlayStyle.css"/>"/>
    </head>
    <body>
        <c:choose>
            <c:when test="${SessionEmail!=null}">
                <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#">Medical Calculator</a>
                        </div>
                        <div class="navbar-collapse collapse">	  
                            <form class="navbar-form navbar-left" role="form">
                                <div class="dropdown">
                                    <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
                                        Please choose calculation menu
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                        <li role="presentation" id="m_eGFR" ><a role="menuitem" tabindex="-1" href="#">estimated Glomerular Filtration Rate: eGFR</a></li>
                                        <li role="presentation" id="m_IV"><a role="menuitem" tabindex="-1" href="#">Intravenous Infusion Rate</a></li>
                                        <li role="presentation" id="m_anion"><a role="menuitem" tabindex="-1" href="#">Anion Gap</a></li>
                                        <li role="presentation" id="m_BSA"><a role="menuitem" tabindex="-1" href="#">Body Surface Area: BSA</a></li>
                                        <li role="presentation" id="m_BMI"><a role="menuitem" tabindex="-1" href="#">Body Mass Index: BMI</a></li>
                                    </ul>
                                </div>
                            </form>

                            <form class="navbar-form navbar-right" role="form" method="post" action="./logoutServlet">
                                <button type="submit" disabled="disabled" class="btn btn-default">${SessionEmail}</button>
                                <button type="submit" class="btn btn-danger">Log out</button>
                            </form>
                        </div><!--/.nav-collapse -->
                    </div>
                </nav>
                <br></br>
                <br></br>


                <div class="container">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">Medical Calculator</h3>
                        </div>
                        <div class="panel-body" >
                            <div class="row">
                                <div class="col-md-12"></div>
                                <h1 class="text" style="text-align: center;" id="menuTitle">Please choose dropdown menu</h1>
                            </div>
                            <br></br>
                            <form class="form-horizontal" action="" method="post">
                                <div class ="row" id="allForm" style="display: none">
                                    <div class ="row" id="eGFR">
                                        <div class="row">
                                            <div class="col-md-12">

                                                <fieldset>                            
                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="sCr">serum Creatinine (mg/dL):</label>  
                                                        <div class="col-md-4">
                                                            <input id="sCr" name="sCr" type="text" placeholder="Enter serum creatinine" class="form-control input-md">
                                                        </div>                                
                                                    </div>
                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="age">age (years):</label>  
                                                        <div class="col-md-4">
                                                            <input id="age" name="age" type="text" placeholder="Enter age" class="form-control input-md">

                                                        </div>
                                                    </div>
                                                    <!-- Select Basic -->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="sex">Sex:</label>
                                                        <div class="col-md-4">
                                                            <select id="sex" name="sex" class="form-control">
                                                                <option value="1">Male</option>
                                                                <option value="2">Female</option>

                                                            </select>
                                                        </div>
                                                    </div>
                                                    <!-- /input-group -->
                                                    <div class="form-group">
                                                        <div class="col-md-4 col-md-offset-4">
                                                            <span class="input-group-addon" >
                                                                <input type="checkbox"> African-American</input>
                                                            </span>    									
                                                        </div>
                                                    </div>
                                            </div>
                                            </fieldset>

                                        </div>
                                    </div>
                                    <!-- Intravenous Infusion Rate-->
                                    <div class ="row" id="IV">
                                        <div class="row">
                                            <div class="col-md-12">

                                                <fieldset>
                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="Dose">Dose (mg/hr):</label>  
                                                        <div class="col-md-4">
                                                            <input id="Dose" name="Dose" type="text" placeholder="Enter Dose" class="form-control input-md">
                                                        </div>                             
                                                    </div>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="mg">Total Dose in Solution (mg):</label>  
                                                        <div class="col-md-4">
                                                            <input id="mg" name="mg" type="text" placeholder="Enter Dose in Solution" class="form-control input-md">
                                                        </div>                                
                                                    </div>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="mL">Total Volume (mL):</label>  
                                                        <div class="col-md-4">
                                                            <input id="mL" name="mL" type="text" placeholder="Enter Total Volume" class="form-control input-md">
                                                        </div>                              
                                                    </div>

                                                </fieldset>

                                            </div>
                                        </div>
                                    </div>
                                    <!-- Anion-Gap Calculator-->
                                    <div class ="row" id="anion">
                                        <div class="row">
                                            <div class="col-md-12">

                                                <fieldset>
                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="Sodium">Sodium (mEq/L):</label>  
                                                        <div class="col-md-4">
                                                            <input id="Sodium" name="Sodium" type="text" placeholder="Enter Sodium level" class="form-control input-md">
                                                        </div>									
                                                    </div>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="Chloride">Chloride (mEq/L):</label>  
                                                        <div class="col-md-4">
                                                            <input id="Chloride" name="Chloride" type="text" placeholder="Enter Chloride level" class="form-control input-md">
                                                        </div>									
                                                    </div>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="Bicarb">Bicarbonate (mEq/L):</label>  
                                                        <div class="col-md-4">
                                                            <input id="Bicarb" name="Bicarb" type="text" placeholder="Enter Bicarb level" class="form-control input-md">
                                                        </div>								
                                                    </div>
                                                </fieldset>

                                            </div>
                                        </div>
                                    </div>
                                    <!--Body Surface Area Calculator-->
                                    <div class="row" id="BSA">
                                        <div class="row">
                                            <div class="col-md-12">

                                                <fieldset>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="wt">Weight (kg):</label>  
                                                        <div class="col-md-4">
                                                            <input id="wt" name="wt" type="text" placeholder="Enter weight" class="form-control input-md">
                                                        </div>                                
                                                    </div>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="ht">Height (cm):</label>  
                                                        <div class="col-md-4">
                                                            <input id="ht" name="ht" type="text" placeholder="Enter height" class="form-control input-md">
                                                        </div>                                
                                                    </div>
                                                </fieldset>

                                            </div>
                                        </div>
                                    </div>
                                    <!--Body Mass Index Calculator-->
                                    <div class="row" id="BMI">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <fieldset>
                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="wt">Weight (kg):</label>  
                                                        <div class="col-md-4">
                                                            <input id="wt" name="wt" type="text" placeholder="Enter weight" class="form-control input-md">
                                                        </div>
                                                    </div>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="ht">Height (cm):</label>  
                                                        <div class="col-md-4">
                                                            <input id="ht" name="ht" type="text" placeholder="Enter height" class="form-control input-md">
                                                        </div>                               
                                                    </div>
                                                </fieldset>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" id="formButton" style="display: none">
                                    <div class="form-group">								
                                        <div class="col-md-4 col-md-offset-5">
                                            <button id="clear" name="clear" type="reset" class="btn btn-danger">Clear</button>
                                            <button id="calc" name="calc" type="submit" class="btn btn-primary">Calculate</button>
                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript" src="<c:url value="js/jquery-1.11.0.js"/>"></script>
            <script type="text/javascript" src="<c:url value="js/jquery.form.js"/>"></script>
            <script type="text/javascript" src="<c:url value="js/bootstrap.min.js"/>"></script>
            <script type="text/javascript">
                $(document).ready(function(){
                    $("li").click(function(){
                        var $menu = $(this).attr("id");
                        var form1 = $menu.substring(2);
                        hideAll();
                        $("#allForm").show();
                        $("#"+form1).show(1000);
                        $("#menuTitle").text($(this).text());
                        $("#formButton").show();
                    });
                });
                function hideAll (){
                    $("#eGFR").hide();
                    $("#IV").hide();
                    $("#anion").hide();
                    $("#BSA").hide();
                    $("#BMI").hide();
                };
            </script>
            <!-- JavaScript placed at the end of the document so the pages load faster -->
            <!-- Optional: Include the jQuery library -->
            <!-- Optional: Incorporate the Bootstrap JavaScript plugins -->
        </c:when>
        <c:otherwise>
            <c:redirect url="/"/>
        </c:otherwise>
    </c:choose>
</body>
</html>