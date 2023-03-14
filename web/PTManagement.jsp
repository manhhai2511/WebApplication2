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
                                    <h2 style="font-family: Brush Script MT; text-align: center; font-size: 60px">Patients Management</h2>
                                    <br>
                                    <div class="d-flex justify-content-lg-start h-100">
                                        <div class="searchbar">
                                            <input class="search_input" type="text" id="search_Account" maxlength="50" placeholder="Search by user name...">
                                            <button onclick="search();" class="search_icon"><i class="fas fa-search"></i></button>
                                        </div>
                                    </div>
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>Patient ID</th>
                                                <th>Patient Name</th>						
                                                <th>Doctor In Charge </th>
                                                <th>Room Number</th>
                                                <th>Bed Number</th>
                                                <th>Date In</th>
                                                <th>Date Out</th>
                                                <th>Cost</th>
                                                <th>Note</th>
                                                <th>Health Record</th>
                                                <th>Health History</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${patientList}" var="p">
                                                <tr>
                                                    <td>${p.getAccountID()}</td>
                                                    <c:forEach items="${accountList}" var="a"> 
                                                        <c:if test="${a.getAccountID() == p.getAccountID()}"> 
                                                            <td>${a.getAccountName()}</td>
                                                        </c:if>
                                                        <c:if test="${a.getAccountID() == p.getDoctorID()}"> 
                                                            <td>${a.getAccountName()}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                    <td>${p.getRoomNumber()}</td>
                                                    <td>${p.getBedNumber()}</td>
                                                    <td>${p.getDate_in()}</td>
                                                    <td>${p.getDate_out()}</td>
                                                    <td>${p.getCost()}</td>
                                                    <td>${p.getNote()}</td>
                                                    <td>
                                                        <!-- Button trigger modal -->
                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter${p.getAccountID()}">
                                                            View
                                                        </button>
                                                    </td>
                                                    <td>
                                                        <!-- Button trigger modal -->
                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter${p.getAccountID()}">
                                                            View
                                                        </button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>  
            </div>
        </div>
        <c:forEach items="${medicalRecord}" var="z">
            <!-- Modal Medical Record-->
            <div class="modal fade" id="exampleModalCenter${z.getPtID()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Medical Record ${z.getPtID()}</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body" >
                            Date In: <h3 id="recordID">${z.getDate_in()}</h3>
                            Date Out: <h3 id="recordID">${z.getDate_out()}</h3>
                            Date In: <h3 id="recordID">${z.getContent()}</h3>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>

    </body>

</html>
