<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Profile</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/iagency/'">Home</button>
     </div>

         <p>user name = "${user.name()}" </p>
          <p>user surname = "${user.surname()}"</p>
          <p>user email = "${user.email()}"</p>

          <form action="/app/iagency/" method="post">
                            <div visible="hidden">
                                <input type="hidden" name="command" value="commandUpdateUser">
                            </div>

                            <label><b>Update user info</b></label>
                            <input name="name" type="text" placeholder="Enter username" required>
                            <input name="surname" type="text" placeholder="Enter surname" required>
                            <input name="email" type="text" placeholder="Enter email" required>
                            <button type="submit">Update</button>

                    </form>

</body>
</html>