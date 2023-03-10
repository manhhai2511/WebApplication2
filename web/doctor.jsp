<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Management Doctor</title>
        <link href="css/Dashboard.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <link href="css/AccountManager.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    </head>
    <body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-10">
                    <div class="container">

                        <div class="row">
                            <div class="table-responsive">
                                <div class="table-wrapper">
                                    <h2 style="font-family: Brush Script MT; text-align: center; font-size: 60px">Doctor manager</h2>
                                    <br>
                                    <table class="table table-striped table-hover">
                                        <div class="d-flex justify-content-center h-100">
                                            <div class="searchbar">
                                                <input class="search_input" type="text" id="search_Account" maxlength="50" placeholder="Search by user name..." value="${txt}">
                                                <button onclick="search();" class="search_icon"><i class="fas fa-search"></i></button>
                                            </div>
                                        </div>
                                        <div><a style="padding-left: 88%;" href="addDoctor.jsp"><button type="button" class="btn btn-outline-info  btn-sm">Add New Doctor</button></a></div>
                                        <thead>
                                            <tr>
                                                <th>AccountID</th>
                                                <th>Name</th>
                                                <th>DepartmentID</th>	
                                                <th>PositionDoctor</th>
                                                <th>DateIn</th>
                                                <th>DateOut</th>
                                                <th>Salary</th>
                                                <th>Experience</th>
                                                <th>Certificate</th>
                                                <th>Action</th>
                                            </tr>

                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="o">
                                                <tr>
                                                    <td>${o.getAccountID()}</td>
                                                     <td>${o.getFullName()}</td>
                                                    <td>${o.getDepartmentID()}</td>
                                                    <td>${o.getPositionDoctor()}</td>
                                                    <td>${o.getDateIn()}</td>
                                                    <td>${o.getDateOut()}</td>
                                                    <td>${o.getSalary()}</td>
                                                    <td>${o.getExperience()}</td>
                                                    <td>${o.getCertificate()}</td>
                                                    
                                                <%--<c:if test="${sessionScope.user.getIsAdmin() == 1}">--%>
                                                        <td>
<!--                                                            <a href=""  ><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>-->
                                                            
                                                            <a href="loadDoctorToEdit?AccountID=${o.getAccountID()}"><button type="button" class="btn btn-outline-info  btn-sm">Edit</button></a>
                                                            
                                                                <a href="deleteDoctor?AccountID=${o.getAccountID()}"> <input type="submit" class="btn btn-outline-danger btn-sm" value="Delete" onclick="if (confirm('Are you sure you want to delete?'))
                                                                            form.action = '';
                                                                        else
                                                                            return false;"/>  
                                                                </a>   
                                                            
                                                        </td>
                                                
                                            <%--</c:if>--%>
                                                    
                                            </tr>
                                        </c:forEach>
                        </div>
                    </div>

                </div> 
                   
            </div>
        </div>
    </body>
</html>
