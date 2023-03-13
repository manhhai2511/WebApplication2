<%-- 
    Document   : login
    Created on : Mar 12, 2023, 2:48:10 AM
    Author     : MSI_PRO
--%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Clinic Management</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">
        <link rel="stylesheet" href="css/style_login.css">





        <!-- Customized Bootstrap Stylesheet -->

    </head>

    <body>
        <div class="main">  	
            <input type="checkbox" id="chk" aria-hidden="true">

            <div class="login">
                <form class="form" action="LoginController" method="get">
                    <label style="margin-bottom: 100px;" for="chk" aria-hidden="true">Log in</label>
                    <input class="input" type="email" placeholder="Email" name="email"required=""/>
                    <input class="input" type="password" placeholder="Password" name="password" required=""/>
                    <button type="submit">Log in</button>
                </form>
            </div>

            <div class="register">
                <form class="form" action="RegisterController" method="post">
                    <label for="chk" aria-hidden="true">Register</label>     
                    <input class="input" type="text" pattern="[A-Za-z\d\.}]{6,12}" title="Username must bettween 6-12 character,contains only letters,numbers" placeholder="UserName" placeholder="UserName" name="username" value="${username1}" required="" />
                    <input class="input" type="email" placeholder="Email" name="email" value="${email1}" required=""/>
                    <input class="input" type="password"  title="Password must more than 8 character,at least one digit,at least one upper letter,at least one special character, not contain space" placeholder="Password" name="password" required="" />                  
                    <input class="input" type="password" placeholder="rePassword" name="repassword" />
                    <button type="submit">Register</button>
                </form>
            </div>
        </div>
                    


    </body>
