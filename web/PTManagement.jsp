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
<!--        <div class="container-fluid">
            <div class="row">
                <div class="col-10">-->
                    <div class="container">
                        <div class="row">
                            <div class="table-responsive">
                                <div class="table-wrapper">
                                    <h2 style="font-family: Brush Script MT; text-align: center; font-size: 60px">Patients Management</h2>
                                    <br>
                                    <h6 style="color: green">${message}</h6>
                                    <table class="table table-hover">
                                        <thead class="thead-dark">
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
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
<!--                </div>
            </div>  
        </div>-->
        <c:forEach items="${medicalRecord}" var="z">
            <!-- Modal Medical Record-->
            <div class="modal fade" id="exampleModalCenter${z.getPtID()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header ">
                            <c:forEach items="${accountList}" var="a">
                                <c:if test="${a.getAccountID()==z.getPtID()}">
                                    <h5 class="modal-title" id="exampleModalLongTitle">${a.getAccountName()} Medical Record</h5>
                                </c:if>
                            </c:forEach>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="DoctorController" method="POST">
                            <div class="modal-body " >
                                <input type="hidden" name="recordId" value="${z.getMedical_ID()}"/>

                                <c:forEach items="${accountList}" var="a">
                                    <c:if test="${a.getAccountID()==z.getPtID()}">
                                        <h5> Patient Name: ${a.getAccountName()} </h5>
                                    </c:if>
                                    <c:if test="${a.getAccountID()==z.getDoctorID()}">
                                    <h5> Doctor Name: ${a.getAccountName()}</h5>
                                    </c:if>
                                </c:forEach>
                                <h5 id="recordID">Date In: ${z.getDate_in()}</h5>
                                <h5 id="recordID">Date Out: ${z.getDate_out()}</h5>
                                <h5 >Content</h5>
                                <!--<label for="exampleFormControlTextarea1">Content</label>-->
                                <textarea name="content" class="form-control" id="exampleFormControlTextarea1" rows="3">${z.getContent()}</textarea>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" onclick="this.form.submit()" class="btn btn-primary">Save changes</button>
                            </div> 
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </body>

</html>
