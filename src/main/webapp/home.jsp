<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IAgency</title>
</head>
<body>
<div>
    <h1>IAgency</h1>
</div>

<div>
    <div>
        <button onclick="location.href='/app/iagency/?command=login'">Login</button>
        <button onclick="location.href='/app/iagency/?command=register'">Register</button>
        <c:if test = "${sessionScope.registered == true}">
            <button onclick="location.href='/app/iagency/?command=orderList'">Orders</button>
        </c:if>
        <c:if test = "${sessionScope.admin == true}">
            <button onclick="location.href='/app/iagency/?command=usersList'">Users</button>
        </c:if>
        <c:if test = "${sessionScope.registered == true}">
                                    <button onclick="location.href='/app/iagency/?command=commandProfile'">Profile</button>
                        </c:if>
        <c:if test = "${sessionScope.registered == true}">
                    <button onclick="location.href='/app/iagency/?command=logOut'">LogOut</button>
        </c:if>

    </div>
</div>
</body>
</html>