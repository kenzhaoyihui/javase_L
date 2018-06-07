<%--
  Created by IntelliJ IDEA.
  User: yzhao_sherry
  Date: 6/3/18
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Ajax request to select, then the server will response the json string data to the browser, js to resolve json and use dom to CRUD-->

<%--<jsp:forward page="/emps"></jsp:forward>--%>

<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Employee List</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <%--//jquery should before the bootstrap--%>
    <%--// OR: throw new Error("Bootstrap's JavaScript requires jQuery")--%>

    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


</head>
<body>



<!-- Add Modal -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add Employee</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="email_add_input" placeholder="email@redhat.com">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> Man
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="F"> Woman
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="dId" id="dept_add_select">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">Save</button>
            </div>
        </div>
    </div>
</div>


<!-- Update Modal -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >Update Employee</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <%--<input type="text" name="empName" class="form-control" id="empName_update_input" placeholder="empName">--%>
                            <p class="form-control-static" id="empName_update_static"></p>
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="email_update_input" placeholder="email@redhat.com">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> Man
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_update_input" value="F"> Woman
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="dId" id="dept_update_select">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">Save</button>
            </div>
        </div>
    </div>
</div>

<!-- Page display-->
    <div class="container">
    <!--Title-->
        <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>

    <!--Button-->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="emp_add_modal_btn">ADD</button>
            <button class="btn btn-danger" id="emp_delete_all_btn">DELETE</button>
        </div>
    </div>

    <!--Data-->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                    <tr>
                        <th>
                            <input type="checkbox" id="check_all"/>
                        </th>
                        <th>#</th>
                        <th>EmpName</th>
                        <th>Gender</th>
                        <th>Email</th>
                        <th>DeptName</th>
                        <th>Operations</th>
                    </tr>
                </thead>

                <tbody>

                </tbody>

                <%--<c:forEach items="${pageInfo.list}" var="emp">--%>
                    <%--<tr>--%>
                        <%--<th>${emp.empId}</th>--%>
                        <%--<th>${emp.empName}</th>--%>
                        <%--<th>${emp.gender=="M"?"Man":"Woman"}</th>--%>
                        <%--<th>${emp.email}</th>--%>
                        <%--<th>${emp.department.deptName}</th>--%>
                        <%--<th>--%>
                            <%--<button class="btn btn-primary btn-sm">--%>
                                <%--<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>--%>
                                <%--Edit--%>
                            <%--</button>--%>
                            <%--<button class="btn btn-danger btn-sm">--%>
                                <%--<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>--%>
                                <%--Delete--%>
                            <%--</button>--%>
                        <%--</th>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>

            </table>
        </div>
    </div>

    <!--page info-->
    <div class="row">
        <div class="col-md-6" id="page_info_area">

        </div>
        <div class="col-md-6" id="page_nav_area">
            <%--<nav aria-label="Page navigation">--%>
                <%--<ul class="pagination">--%>
                    <%--<li><a href="${APP_PATH}/emps?pn=1"> First</a> </li>--%>
                    <%--<c:if test="${pageInfo.hasPreviousPage}">--%>
                        <%--<li>--%>
                            <%--<a href="${APP_PATH}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">--%>
                                <%--<span aria-hidden="true">&laquo;</span>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    <%--</c:if>--%>


                    <%--<c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">--%>
                        <%--<c:if test="${page_Num == pageInfo.pageNum}">--%>
                            <%--<li class="active"><a href="#">${page_Num}</a> </li>--%>
                        <%--</c:if>--%>

                        <%--<c:if test="${page_Num != pageInfo.pageNum}">--%>
                            <%--<li><a href="${APP_PATH}/emps?pn=${page_Num}">${page_Num}</a> </li>--%>
                        <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--<li><a href="#">1</a></li>--%>
                    <%--<li><a href="#">2</a></li>--%>
                    <%--<li><a href="#">3</a></li>--%>
                    <%--<li><a href="#">4</a></li>--%>
                    <%--<li><a href="#">5</a></li>--%>

                    <%--<c:if test="${pageInfo.hasNextPage}">--%>
                        <%--<li>--%>
                            <%--<a href="${APP_PATH}/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">--%>
                                <%--<span aria-hidden="true">&raquo;</span>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    <%--</c:if>--%>

                    <%--<li><a href="${APP_PATH}/emps?pn=${pageInfo.pages}">Last</a> </li>--%>
                <%--</ul>--%>
            <%--</nav>--%>

        </div>
    </div>
</div>


<script type="text/javascript">
    //Ajax request

    var totalRecord, currentPage;
    $(function () {
        to_page(1);
    });

    function to_page(pn) {
        $.ajax({
            url: "${APP_PATH}/emps",
            data: "pn=" + pn,
            type: "GET",
            success: function(result) {
                //console.log(result);

                //1. Resolve and display the Employee info
                //2. Resolve and display the pageInfo
                build_emps_table(result);

                build_page_info(result);

                build_page_nav(result);
            }
        });
    }


    function build_emps_table(result) {

        $("#emps_table tbody").empty();
        var emps = result.extend.pageInfo.list;
        $.each(emps, function (index, item) {

            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");

            //alert(item.empName);
            var empIdTd = $("<td></td>").append(item.empId);
            var empNameTd = $("<td></td>").append(item.empName);
            //var gender = item.gender== "M"?"Male":"Female";
            var genderTd = $("<td></td>").append(item.gender== "M"?"Male":"Female");
            var emailTd = $("<td></td>").append(item.email);
            var deptNameTd = $("<td></td>").append(item.department.deptName);

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("Edit");

            editBtn.attr("edit-id", item.empId);

            var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("Delete");

            deleteBtn.attr("del-id", item.empId);


            var btnId = $("<td></td>").append(editBtn).append(" ").append(deleteBtn);

            $("<tr></tr>").append(checkBoxTd)
                .append(empIdTd)
                .append(empNameTd)
                .append(genderTd)
                .append(emailTd)
                .append(deptNameTd)
                .append(btnId)
                .appendTo("#emps_table tbody");

        });
    }

    //page info
    function build_page_info(result) {

        $("#page_info_area").empty();
        $("#page_info_area").append("Now Page: " + result.extend.pageInfo.pageNum + " page , Total Pages: " + result.extend.pageInfo.pages + " , Total Records: " +  result.extend.pageInfo.total)

        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }
    function build_page_nav(result) {

        $("#page_nav_area").empty();

        var ul = $("<ul></ul>").addClass("pagination");

        var firstPage = $("<li></li>").append($("<a></a>").append("First").attr("href", "#"));

        var prevPage = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage == false){
            firstPage.addClass("disabled");
            prevPage.addClass("disabled");
        }else{
            firstPage.click(function () {
                to_page(1);
            });

            prevPage.click(function () {
                to_page(result.extend.pageInfo.pageNum-1);
            });
        }


        var nextPage = $("<li></li>").append($("<a></a>").append("&raquo;"));

        var lastPage = $("<li></li>").append($("<a></a>").append("Last").attr("href", "#"));

        if(result.extend.pageInfo.hasNextPage  == false){
            nextPage.addClass("disabled");
            lastPage.addClass("disabled");
        }else {
            nextPage.click(function () {
                to_page(result.extend.pageInfo.pageNum+1);
            });

            lastPage.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }

        //Click things



        ul.append(firstPage).append(prevPage);

        // travel 1,2,3,4,5
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum == item){
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);

            });

            ul.append(numLi);

        });

        ul.append(nextPage).append(lastPage);

        //ul add to nav
        var navEle = $("<nav></nav>").append(ul);

        navEle.appendTo("#page_nav_area");
    }


    //Clear the content of form
    function reset_form(ele) {
        $(ele)[0].reset();

        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");


    }

    $("#emp_add_modal_btn").click(function () {
        //reset the form, due to the jquery has no reset method, so, use the DOM reset
        reset_form("#empAddModal form");

        //$("#empAddModal form")[0].reset();

        //get the deptname info
        getDepts("#empAddModal select");

        $("#empAddModal").modal({
            backdrop: "static"
        });
    });


    //Get the dept info and
    function getDepts(ele) {
        $(ele).empty();
        $.ajax({
            url: "${APP_PATH}/depts",
            type: "GET",
            success: function (result) {
                //console.log(result);
                //$("#empAddModal select").append("")
                //{"code":200,"msg":"Success","extend":{"depts":[{"deptId":1,"deptName":"Dev"},{"deptId":2,"deptName":"Test"}]}}
                $.each(result.extend.depts, function () {
                    var optionEle = $("<option></option>").append(this.deptName).attr("value", this.deptId);
                    optionEle.appendTo(ele);
                })
            }
        })
    }


    function validate_add_form() {
        // validate data, use regex
        var empName = $("#empName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16})|(^[\u2E80-\u9FFF]{2,5})/;

        var email = $("#email_add_input").val();
        var regeamil = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

        if (!regName.test(empName)){
            //alert("empName should be 2-5 Chinese or 6-16 Engish");

            show_validate_msg("#empName_add_input", "error", "empName should be 2-5 Chinese or 6-16 Engish");
            //$("#empName_add_input").parent().addClass("has-error");
            //$("#empName_add_input").next("span").text("empName should be 2-5 Chinese or 6-16 Engish");
            return false;
        }else {
            show_validate_msg("#empName_add_input", "success", "")
            //$("#empName_add_input").parent().addClass("has-success");
            //$("#empName_add_input").next("span").text("");
        };

        if(!regeamil.test(email)){
            //alert("Email is invalid")
            show_validate_msg("#email_add_input", "error", "Email is invalid");
            //$("#email_add_input").parent().addClass("has-error");
            //$("#email_add_input").next("span").text("Email is invalid");

            return false;
        }else{
            show_validate_msg("email_add-input", "success", "");
            //$("#email_add_input").parent().addClass("has-success");
            //$("#email_add_input").next("span").text("");
        }

        return true;
    }

    function show_validate_msg(ele, status, msg) {
        //Clean the data ele validate status
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if("success"==status){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if("error"==status){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }

    }


    $("#empName_add_input").change(function () {
        // validate the user name is available
        var empName = this.value;
        $.ajax({
            url: "${APP_PATH}/checkuser",
            data: "empName="+empName,
            type: "POST",
            success: function (result) {
                if (result.code == 200){
                    show_validate_msg("#empName_add_input", "success", "EmpName is available");
                    $("#emp_save_btn").attr("ajax-va", "success");
                }else{
                    show_validate_msg("#empName_add_input", "error", result.extend.va_msg);
                    $("#emp_save_btn").attr("ajax-va", "error");
                }

            }
        })

    })

    $("#emp_save_btn").click(function () {
        //Submit the data to server and save
        // Send the Ajax to save employee

        // alert($("#empAddModal form").serialize());

        //validate the input data
        if (!validate_add_form()){
            return false;
        }

        // ajax empName validate result
        if($(this).attr("ajax-va")=="error"){
            return false;
        }
        $.ajax({
            url: "${APP_PATH}/emp",
            type: "POST",
            data: $("#empAddModal form").serialize(),
            success: function (result) {
                //1. Close the modal
                if(result.code == 200){
                    $("#empAddModal").modal('hide');
                    //2. check the database data
                    to_page(totalRecord);
                }else{
                    //Error fields
                    if(undefined != result.extend.errorFields.email){
                        show_validate_msg("#email_add_input", "error", result.extend.errorFields.email);
                    }

                    if(undefined != result.extend.errorFields.empName){
                        show_validate_msg("empName_add_input", "error", result.extend.errorFields.empName);
                    }

                    // alert(result.extend.errorFields.email);
                    // alert(result.extend.errorFields.empName);
                }


            }
        });
    });


    //bind the "click" event before the button creating, so binding failed
    //Solution: 1) bind the "click" event when creating the button 2)bind the click "on"

    $(document).on("click", ".edit_btn", function () {
        getDepts("#empUpdateModal select");

        getEmp($(this).attr("edit-id"));

        // transfer the emdId to the "Update/Save" button
        $("#emp_update_btn").attr("edit-id", $(this).attr("edit-id"));
        $("#empUpdateModal").modal({
            backdrop: "static"
        });
    });

    function getEmp(id) {
        $.ajax({
            url: "${APP_PATH}/emp/"+id,
            type: "GET",
            success:function (result) {
                //console.log(result);

                var empData = result.extend.emp;
                $("#empName_update_static").text(empData.empName);

                $("#email_update_input").val(empData.email);

                $("#empUpdateModal input[name=gender]").val([empData.gender]);

                $("#empUpdateModal select").val([empData.dId]);
                //$("#dept_update_select").val([empData.dId]);
            }
        });
    }


    $("#emp_update_btn").click(function () {
        var email = $("#email_update_input").val();
        var regeamil = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

        if(!regeamil.test(email)){
            //alert("Email is invalid")
            show_validate_msg("#email_update_input", "error", "Email is invalid");
            //$("#email_add_input").parent().addClass("has-error");
            //$("#email_add_input").next("span").text("Email is invalid");

            return false;
        }else{
            show_validate_msg("email_update_input", "success", "");
            //$("#email_add_input").parent().addClass("has-success");
            //$("#email_add_input").next("span").text("");
        }

        // send the ajax request and save the data --> POST
        <%--$.ajax({--%>
            <%--url: "${APP_PATH}/emp/"+$(this).attr("edit-id"),--%>
            <%--type: "POST",--%>
            <%--data: $("#empUpdateModal form").serialize()+"&_method=PUT",--%>
            <%--success: function (result) {--%>
                <%--alert(result.msg);--%>
            <%--}--%>
        <%--})--%>


        // send the ajax and save the data --> PUT,   need "HttpPutFormContentFilter" filter
        $.ajax({
            url: "${APP_PATH}/emp/"+$(this).attr("edit-id"),
            type: "PUT",
            data: $("#empUpdateModal form").serialize(),
            success: function (result) {
                //alert(result.msg);
                $("#empUpdateModal").modal("hide");
                to_page(currentPage);
            }
        });
    });

    $(document).on("click", ".delete_btn", function () {
        //alert($(this).parents("tr").find("td:eq(1)").text());
        var empName = $(this).parents("tr").find("td:eq(1)").text();
        var empId = $(this).attr("del-id")
        if(confirm("Confirm Delete: [" + empName + "] ?")){
            //Confirm , send ajax request to delete
            $.ajax({
                url: "${APP_PATH}/emp/"+empId,
                type: "DELETE",
                success: function (result) {
                    //alert(result.msg);

                    to_page(currentPage);
                }
            });
        }
    });


    //Check all

    $("#check_all").click(function () {

        //"attr" received checked is undefined
        //here is use "prop" to received the dom ,   "atrr" is use to received the value which self-defined
       //alert($(this).attr("checked"));
        //alert($(this).prop("checked"));

        //$(this).prop("checked");
        $(".check_item").prop("checked", $(this).prop("checked"));
    });


    $(document).on("click", ".check_item", function () {
        var flag = $(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked", flag);
    });


    $("#emp_delete_all_btn").click(function () {
        //$(".check_item:checked")

        var empNames ="";
        var del_idstr = "";
        $.each($(".check_item:checked"), function () {
            empNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
            del_idstr += $(this).parents("tr").find("td:eq(1)").text() + "-";
        });

        empNames = empNames.substring(0, empNames.length-1);
        del_idstr = del_idstr.substring(0, del_idstr.length-1);

        if(confirm("Confirm delete [" + empNames + "]?")){
            $.ajax({
                url: "${APP_PATH}/emp/"+del_idstr,
                type: "DELETE",
                success: function (result) {

                    alert(result);
                    to_page(currentPage);
                }
            })
        }
    });

</script>

</body>
</html>