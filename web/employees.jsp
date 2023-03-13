<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Product Page - Admin HTML Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
        <!--Datatables-->
    </head>

    <body id="reportsPage" >
        <%@include file="components/NavbarAdmin.jsp" %>
        <div class="container mt-5">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 accordiontm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products" style="min-height: 900px">
                        <h2 class="tm-block-title">Employee List</h2>
<!--                        <div class="form-outline mb-3">
                            <div class="row">
                                <div class="col-xl-10 col-lg-10 col-md-12">
                                    <input class="form-control" type="text" id="myInput" placeholder="Search for names.." value="${name}">
                                </div>
                                <div class="col-xl-2 col-lg-2 col-md-12">
                                    <button onclick="selectPage(${page}, ${categoryID})" class="btn-primary" style="width: 100%; height:100%;">Search</button>
                                </div>
                            </div>
                        </div>-->
                        <form id="products" actiopn="ProductsController" method="POST">
                            <div class="tm-product-table-container">
                                <input type="hidden" value="deleteProducts" name="do">
                                <table id="sortTable" class="table table-hover tm-table-small tm-product-table">
                                    <thead>
                                        <tr>
                                            <th scope="col">&nbsp;</th>
                                            <th scope="col">ID</th>
                                            <th scope="col">Department</th>
                                            <th scope="col">Position</th>
                                            <th scope="col">IN</th>
                                            <th scope="col">Salary</th>
                                            <th scope="col">&nbsp;</th>
                                        </tr>
                                    </thead>
                                    <tbody class="product-tb">
                                        <c:forEach items="${employeeList}" var="emp">
                                            <tr class="product-tr">
                                                <th scope="row"><input type="checkbox" value="${emp.getAccountId()}" name="employeeID"></th>
                                                <td class="tm-product-name" onclick="editProduct(${emp.getAccountId()})">${emp.getAccountId()}</a></td>
                                                <td>${emp.getDepartmentId()}</td>
                                                <td>${emp.getPositionEmp()}</td>
                                                <td>${emp.getDateIn()}</td>
                                                <td>${emp.getSalary()}</td>
                                                <td>
                                                    <a onclick="return deleteProduct(${emp.getAccountId()})" class="tm-product-delete-link">
                                                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                            <!-- table container -->
                            <a
                                href="addEmployee"
                                class="btn btn-primary btn-block text-uppercase mb-3 mt-5">Add new employee
                            </a>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                    Copyright &copy; <b>2018</b> All rights reserved. 

                    Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                </p>
            </div>
        </footer>

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->

        <style>
            th { white-space: nowrap; overflow: hidden; text-overflow:ellipsis; }
        </style>

        <script>
                                                function searchName() {
                                                    let input = document.getElementById('myInput').value;
                                                    input = input.toLowerCase();
                                                    let x = document.getElementsByClassName('product-tr');

                                                    for (i = 0; i < x.length; i++) {
                                                        if (!x[i].getElementsByTagName("td")[0].innerHTML.toLowerCase().includes(input)) {
                                                            x[i].style.display = "none";
                                                        } else {
                                                            x[i].style.display = "";
                                                        }
                                                    }
                                                }

                                                function searchCategory(categoryID) {
                                                    window.location.href = "ProductsController?CategoryID=" + categoryID;
                                                }

                                                function deleteProduct(accountID) {
                                                    if (confirm("Are you sure you want to delete? \nThis will delete all data related to the product.")) {
                                                        window.location.href = "employee?do=deleteEmployee&accountID=" + accountID;
                                                    } else {
                                                        return false;
                                                    }
                                                }

                                                function editProduct(productID) {
                                                    window.location.href = "editEmployee?accountId=" + productID;
                                                }

                                                function deleteProducts() {
                                                    if (confirm("Are you sure you want to delete? \nThis will delete all data related to the product.")) {
                                                        document.getElementById('products').submit();
                                                    } else {
                                                        return false;
                                                    }
                                                }

                                                function selectPage(page, categoryID) {
                                                    let name = document.getElementById('myInput').value;
                                                    window.location.href = "ProductsController?page=" + page + "&CategoryID=" + categoryID + "&name=" + name;
                                                }
        </script>
    </body>
</html>