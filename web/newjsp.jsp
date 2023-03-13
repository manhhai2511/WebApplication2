<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Management Department</title>
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
                                    <h2 style="font-family: Brush Script MT; text-align: center; font-size: 60px">Department manager</h2>
                                    <br>
                                    <table class="table table-striped table-hover">
                                        <div class="d-flex justify-content-center h-100">
                                            <div class="searchbar">
                                                <input class="search_input" type="text" id="search_Account" maxlength="50" placeholder="Search by user name..." value="${txt}">
                                                <button onclick="search();" class="search_icon"><i class="fas fa-search"></i></button>
                                                <a href="AddDepartment.jsp"><button type="button" class="btn btn-outline-info  btn-sm">Create new Departmant</button></a>

                                            </div>
                                        </div>
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Department Name</th>						
                                                <th>Detail</th>
                                                <th>Note</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="o">
                                                <tr>
                                                    <td>${o.getDepartmentID()}</td>
                                                    <td>${o.getDepartmentName()}</td>
                                                    <td>${o.getDetail()}</td>
                                                    <td>${o.getNote()}</td>

                                                    <%--<c:if test="${sessionScope.user.getIsAdmin() == 1}">--%>
                                                    <td>
                                                        <a href="EditDepartmentController?UserID=${o.getDepartmentID()}"><button type="button" class="btn btn-outline-info  btn-sm">Edit</button></a>
                                                        <form action="deleteAccount" method="POST" style="display:inline">
                                                            <a> <input type="submit" class="btn btn-outline-danger btn-sm" value="Delete" onclick="if (confirm('Are you sure you want to delete?'))
                                                                        form.action = 'DeleteDepartmentController?UserID=${o.getDepartmentID()}';
                                                                    else
                                                                        return false;"/>  
                                                            </a>   
                                                        </form>
                                                    </td>

                                                    <%--</c:if>--%>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <c:if test="${totalPage!=0}">
                                <div class="col-12 pb-1">
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination justify-content-center mb-3">
                                            <li class="page-item ${indexPage==1?'disabled':''}">
                                                <a class="page-link" href="Departmentmanager?indexPage=${indexPage-1}" aria-label="Previous">
                                                    <span aria-hidden="true">&laquo;</span>
                                                    <span class="sr-only">Previous</span>
                                                </a>
                                            </li>
                                            <c:forEach var="i" begin="1" end="${totalPage}"  >
                                                <li class="page-item ${indexPage==i?'active':''}">
                                                    <a class="page-link" href="Departmentmanager?indexPage=${i}">${i}</a></li>
                                                </c:forEach>
                                            <li class="page-item ${indexPage==totalPage?'disabled':''}">
                                                <a class="page-link" href="Departmentmanager?indexPage=${indexPage+1}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                    <span class="sr-only">Next</span>
                                                </a>  
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </c:if>

                            <c:if test="${totalPage==0}">
                                ${mess}
                            </c:if>  
                        </div>
                    </div>
                </div>  
            </div>
        </div>
        <script>
            var eDelete = document.getElementById("eDelete").value;
            if (eDelete == "false") {
                window.alert("Can't delete account!!!");
            }
        </script>
    </body>
</html>
