<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Users</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/iagency/'">Home</button>
     </div>
     <form action="/app/iagency/" method="post">
                  <div visible="hidden">
                      <input type="hidden" name="command" value="deleteUser">
                  </div>

                  <label><b>Delete user by id</b></label>
                  <input name="user_id" type="text" placeholder="Enter id" required>
                  <button type="submit">Delete</button>

     </form>

    <c:forEach var="user" items="${requestScope.users}">
          "${user.id()}"
          "${user.name()}"
          "${user.surname()}"
          "${user.email()}"
    <hr>
    </c:forEach>
</body>
</html>