<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--Favicon-->
        <title>Edit Account</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- Edit Product -->
        <div id="editEmployeeModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="AddDepartmentController" method="POST">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Department</h4>
                            <a type="button" class="close" href="Departmentmanager" aria-hidden="true">&times;</a>                                                         
                        </div>
                        <div class="modal-body">	

<!--                            <div class="form-group">
                                <label>Department ID</label>
                                <input type="text" class="form-control" required name="departmentid" >
                            </div>-->

                            <div class="form-group">
                                <label>Department Name</label>
                                <input type="text" class="form-control" required name="namedp">
                            </div>
                            <div class="form-group">
                                <label>Detail</label>
                                <input type="text" class="form-control"  name="detail" >
                            </div>
                            <div class="form-group">
                                <label>Note</label>
                                <input type="text" class="form-control"  name="note" >
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a type="button" class="btn btn-default" href="Departmentmanager">Cancel</a>
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>