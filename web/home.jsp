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

                            <form class="navbar-form navbar-right" id="logoutForm" role="form" method="POST" action="./logoutServlet">
                                <button  type="submit" disabled="disabled" class="btn btn-default">${SessionEmail}</button>
                                <button type="submit" class="btn btn-danger" id="logoutBtn">Log out</button>
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
                            <div class ="row" id="allForm" style="display: none">
                                <div class ="row" id="eGFR">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form class="form-horizontal" action="" method="post">
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
                                                        <label class="col-md-4 control-label" for="age">Age (years):</label>  
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
                                                                <input type="checkbox" name="black" value="NO"> African-American</input>
                                                                <input id="method" name="method" type="hidden" value="eGFR">
                                                                <input id="eGFR_result" name="result" type="hidden" class="form-control input-md">
                                                                <input id="eGFR_email" name="email" type="hidden" value="${SessionEmail}" class="form-control input-md">
                                                            </span>    									
                                                        </div>
                                                    </div>
                                                </fieldset>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- Intravenous Infusion Rate-->
                                <div class ="row" id="IV">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form class="form-horizontal" action="" method="post">
                                                <fieldset>
                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="Dose">Dose (mg/hr):</label>  
                                                        <div class="col-md-4">
                                                            <input id="dose" name="dose" type="text" placeholder="Enter Dose" class="form-control input-md">
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
                                                        <label class="col-md-4 control-label" for="ml">Total Volume (mL):</label>  
                                                        <div class="col-md-4">
                                                            <input id="ml" name="ml" type="text" placeholder="Enter Total Volume" class="form-control input-md">
                                                            <input id="method" name="method" type="hidden" value="IV">
                                                            <input id="IV_result" name="result" type="hidden" class="form-control input-md">
                                                            <input id="IV_email" name="email" type="hidden" value="${SessionEmail}" class="form-control input-md">
                                                        </div>                              
                                                    </div>

                                                </fieldset>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- Anion-Gap Calculator-->
                                <div class ="row" id="anion">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form class="form-horizontal" action="" method="post">
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
                                                            <input id="method" name="method" type="hidden" value="anion">
                                                            <input id="anion_result" name="result" type="hidden" class="form-control input-md">
                                                            <input id="anion_email" name="email" type="hidden" value="${SessionEmail}" class="form-control input-md">
                                                        </div>								
                                                    </div>
                                                </fieldset>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!--Body Surface Area Calculator-->
                                <div class="row" id="BSA">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form class="form-horizontal" action="" method="post">
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
                                                            <input id="method" name="method" type="hidden" value="BSA">
                                                            <input id="BSA_result" name="result" type="hidden" class="form-control input-md">
                                                            <input id="BSA_email" name="email" type="hidden" value="${SessionEmail}" class="form-control input-md">
                                                        </div>                                
                                                    </div>
                                                </fieldset>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!--Body Mass Index Calculator-->
                                <div class="row" id="BMI">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form class="form-horizontal" action=""method="post">
                                                <fieldset>
                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="wt">Weight (kg):</label>  
                                                        <div class="col-md-4">
                                                            <input id="wt" name="wt" type="text" placeholder="Enter weight" class="form-control input-md" value="">

                                                        </div>

                                                    </div>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="ht">Height (cm):</label>  
                                                        <div class="col-md-4">
                                                            <input id="ht" name="ht" type="text" placeholder="Enter height" class="form-control input-md" value="">
                                                            <input id="method" name="method" type="hidden" value="BMI">
                                                            <input id="BMI_result" name="result" type="hidden" class="form-control input-md">
                                                            <input id="BMI_email" name="email" type="hidden" value="${SessionEmail}" class="form-control input-md">
                                                        </div>                               
                                                    </div>
                                                </fieldset>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" id="formButton" style="display: none">
                                <div class="form-group">								
                                    <div class="col-md-4 col-md-offset-5">
                                        <button id="calc" name="calc" class="btn btn-primary">Calculate</button>                                            
                                        <button id="btn-save" name="save" class="btn btn-success">Save</button>
                                        <button id="clear" name="clear" class="btn btn-danger">Clear</button>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-info">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne"  >
                                        Calculation History
                                    </a>>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne" id="myCollapsible">
                                <div class="panel-body">
                                    <div class="container">                                
                                        <div role="tabpanel">
                                            <!-- Nav tabs -->
                                            <ul class="nav nav-tabs" role="tablist">
                                                <li role="presentation" class="active"><a href="#eGFR_History" aria-controls="eGFR_History" role="tab" data-toggle="tab">eGFR</a></li>
                                                <li role="presentation"><a href="#IV_History" aria-controls="IV_History" role="tab" data-toggle="tab">Intravenouse Infusion Rate</a></li>
                                                <li role="presentation"><a href="#anion_History" aria-controls="anion_History" role="tab" data-toggle="tab">Anion Gap</a></li>
                                                <li role="presentation"><a href="#BSA_History" aria-controls="BSA_History" role="tab" data-toggle="tab">BSA</a></li>
                                                <li role="presentation"><a href="#BMI_History" aria-controls="BMI_History" role="tab" data-toggle="tab">BMI</a></li>
                                            </ul>

                                            <!-- Tab panes -->
                                            <div class="tab-content">

                                                <div role="tabpanel" class="tab-pane active"  id="eGFR_History">
                                                    <div class="panel-body">
                                                        <div class="row">
                                                            <h3 class="text" style="text-align: center;">eGFR</h3>
                                                            <table class="table table-striped">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>sCr (mg/dL)</th>
                                                                        <th>Age (years)</th>
                                                                        <th>Sex</th>
                                                                        <th>African</th>
                                                                        <th>eGFR (mL/min/1.73<sup>2</sup>)</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody id="eGFR_Table">
                                                                    <tr></tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div role="tabpanel" class="tab-pane" id="IV_History">
                                                    <div class="panel-body">
                                                        <div class="row">
                                                            <h3 class="text" style="text-align: center;">Intravenous Infusion Rate</h3>
                                                            <table class="table table-striped">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Dose (mg/hr)</th>
                                                                        <th>Total Dose in Solution (mg)</th>
                                                                        <th>Total Volume (mL)</th>                                           
                                                                        <th>Infusion Rate (mL/hr)</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody id="IV_Table">
                                                                    <tr></tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div role="tabpanel" class="tab-pane" id="anion_History">
                                                    <div class="panel-body">
                                                        <div class="row">
                                                            <h3 class="text" style="text-align: center;">Anion Gap</h3>
                                                            <table class="table table-striped">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Na (mEq/L)</th>
                                                                        <th>Cl (mEq/L)</th>
                                                                        <th>Bicarb (mEq/L)</th>                                           
                                                                        <th>Anion Gap (mEq/L)</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody id="anion_Table">
                                                                    <tr></tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div role="tabpanel" class="tab-pane" id="BSA_History">
                                                    <div class="panel-body">
                                                        <div class="row">
                                                            <h3 class="text" style="text-align: center;">BSA</h3>
                                                            <table class="table table-striped">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Weight (kg)</th>
                                                                        <th>Height (cm)</th>                                          
                                                                        <th>BSA (m<sup>2</sup>)</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody id="BSA_Table">
                                                                    <tr></tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div role="tabpanel" class="tab-pane" id="BMI_History">
                                                    <div class="panel-body">
                                                        <div class="row">
                                                            <h3 class="text" style="text-align: center;">BMI</h3>
                                                            <table class="table table-striped">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Weight (kg)</th>
                                                                        <th>Height (cm)</th>                                          
                                                                        <th>BMI</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody id="BMI_Table">
                                                                    <tr></tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>                                

                <div class="modal fade bs-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-md">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h3 class="modal-title" id="myModalLabel" style="color: blue;">Modal title</h3>
                            </div>
                            <div class="modal-body">
                                <div class="row well" >
                                    <div class="col-md-2 inputLabel" style="font-size: 18px;">Input data</div>
                                    <div class="col-md-10" id="input" style="font-size: 20px; color: green"></div>
                                </div>
                                <div class="row well">
                                    <div class="col-md-3 inputLabel" style="font-size: 18px;">Result</div>
                                    <div class="col-md-9" id="output" style="font-size: 22px; font-weight: bold; color: red;" ></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <script type="text/javascript" src="<c:url value="js/jquery-1.11.0.js"/>"></script>
            <script type="text/javascript" src="<c:url value="js/jquery.form.js"/>"></script>
            <script type="text/javascript" src="<c:url value="js/jquery.cookie.js"/>"></script>
            <script type="text/javascript" src="<c:url value="js/bootstrap.min.js"/>"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    var idleTime = 0;
                    var form1 = ["eGFR", "IV", "anion", "BSA", "BMI"];
                    for (i = 0; i < form1.length; i++) { 
                        fetchData(form1[i]);
                    }
                    
                    logoutWhenSessionExpires();
                    var $menu = "";
                    var form1 = "";
                    $("li").click(function () {
                        $menu = $(this).attr("id");
                        form1 = $menu.substring(2);
                        $result = ""
                        hideAll();
                        $("#allForm").show();
                        $("#" + form1).show(1000);
                        $("#menuTitle").text($(this).text());
                        $("#formButton").show();
//                            resetAllExcept(form1);

                        $("#clear").on("click", function () {
                            resetForm(form1);
                        })
                    });

                    $("#calc").on("click", function () {

                        if (!isBlankInput(form1)) {
                            var url = "./CalculationServlet";
                            $.ajax({
                                type: "POST",
                                url: url,
                                data: $("form", "#" + form1).serialize(),
                                
                                success: function (data) {
                                    console.log(data);
                                    if (data != 503) {
                                        $(".modal").modal("show");
                                        $(".modal-title").html(data.title);
                                        $("#input", ".modal-body").html(data.input);
                                        $("#" + form1 + "_result").val(data.output);
                                        $("#output", ".modal-body").html(data.output + data.unit);
                                    } else {
                                        alert("Session Expired");
                                        $("#logoutForm").submit();
                                    }

                                }
                            });

                        } else {
                            alert("All Fields are required");
                        }
                        return false;
                    });

                    $("#btn-save").on("click", function () {
                        if (!isBlankInput(form1) && $("#" + form1 + "_result").val() !== "") {
                            var url = "./insertRecordServlet";
                            $.ajax({
                                type: "POST",
                                url: url,
                                data: $("form", "#" + form1).serialize(),
                                success: function (data) {
                                    if (data.toString() == 500) {
                                        alert("Save Unsuccessful");
                                    } else {
                                        $("#" + form1 + "_Table tr").remove();
                                        $("#" + form1 + "_Table").html("<tr></tr>");
                                        alert("Save Successful");
                                        $.each(data, function (index, value) {
                                            $("#" + form1 + "_Table tr:last").after("<tr>" + value + "</tr>");
                                        });
                                    }
                                }
                            });
                        }
                    })
                    $("#logoutBtn").on("click", function () {
                        logoutAction();
                    });
                });

                function logoutAction() {
                    alert("Session Expired");
                    $.removeCookie('cookie_email', {path: '/MedicalCalculator'});
                    $("#logoutForm").submit();
                }


                function isBlankInput(id) {
                    var flag = false;
                    $(":text", "#" + id).each(function () {
                        if ($(this).val() == "" && ($(this).attr(name) == "result")) {
                            flag = true;
                        }
                    })
                    if (flag) {
                        return true;
                    }
                }
                function resetForm(id) {
                    $("input", "#" + id).each(function () {
                        if ($(this).val() !== "") {
                            $(this).val("");
                        }
                    });
                    $("input[name='method']", "#" + id).val(id);
                    $("input[name='email']", "#" + id).val("${SessionEmail}");
                }

                function hideAll() {
                    $("#eGFR").hide();
                    $("#IV").hide();
                    $("#anion").hide();
                    $("#BSA").hide();
                    $("#BMI").hide();
                }
                ;

                function fetchData(method) {  
//                    alert(method);
                     var url = "./fetchServlet";
                        $.ajax({
                            type: "POST",
                            url: url,
                            data: "email="+"${SessionEmail}" + "&method=" + method,
                            success: function (data) {
//                                alert(method);
                                $.each(data, function (index, value) {
                                    $("#" + method + "_Table tr:last").after("<tr>" + value + "</tr>");
                                });
                            }
                        });  
                };

                function logoutWhenSessionExpires() {
                    var idleInterval = setInterval(timerIncrement, 60000); // 1 minute
                    $(this).mousemove(function (e) {
                        idleTime = 0;
                    });
                    $(this).keypress(function (e) {
                        idleTime = 0;
                    });
                    $(this).click(function (e) {
                        idleTime = 0;
                    });
                    function timerIncrement() {
                        idleTime = idleTime + 1;
                        if (idleTime > 2) { // 10 minutes
                            logoutAction();
                        }
                    }
                }
            </script>
        </c:when>
        <c:otherwise>
            <c:redirect url="/"/>
        </c:otherwise>
    </c:choose>
</body>
</html>