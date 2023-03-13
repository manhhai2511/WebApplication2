<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
<!--            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Cập nhật<b> Sản phẩm</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>-->
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editDoctor" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Doctor</h4>
<!--                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>AccountID</label>
                                    <input value="${list.getAccountID()}" name="AccountID" type="text" class="form-control" readonly required >
                                </div>
                                <div class="form-group">
                                    <label>FullName</label>
                                    <input value="${list.getFullName()}" name="FullName" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>DepartmentID</label>
                                    <input value="${list.getDepartmentID()}" name="DepartmentID" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>PositionDoctor</label>
                                    <input value="${list.getPositionDoctor()}" name="PositionDoctor" type="text" class="form-control" required>
                                </div>
                                
                                <div class="form-group">
                                    <label>DateIn</label>
                                    <input value="${list.getDateIn()}" name="DateIn" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>DateOut</label>
                                    <input value="${list.getDateOut()}" name="DateOut" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Salary</label>
                                    <input value="${list.getSalary()}" name="Salary" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Experience</label>
                                    <input value="${list.getExperience()}" name="Experience" type="text" class="form-control" required>
                                </div>
                               <div class="form-group">
                                    <label>Certificate</label>
                                    <input value="${list.getCertificate()}" name="Certificate" type="text" class="form-control" required>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <a href="doctorManager"><button type="button" class="btn btn-success">Back</button></a>
                                <input type="submit" class="btn btn-success" value="Cập Nhật">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>