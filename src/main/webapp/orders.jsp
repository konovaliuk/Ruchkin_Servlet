<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Orders</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/iagency/'">Home</button>
     </div>
     <form action="/app/iagency/" method="post">
                            <div visible="hidden">
                                <input type="hidden" name="command" value="addOrder">
                            </div>

                            <label><b>Add order</b></label>
                            <input name="name" type="text" placeholder="Enter name" required>
                            <input name="description" type="text" placeholder="Enter description" required>

                            <button type="submit">Add</button>

               </form>
     <form action="/app/iagency/" method="post">
                       <div visible="hidden">
                           <input type="hidden" name="command" value="deleteOrder">
                       </div>

                       <label><b>Delete order by id</b></label>
                       <input name="order_id" type="text" placeholder="Enter id" required>
                       <button type="submit">Delete</button>

          </form>

    <c:forEach var="order" items="${requestScope.orders}">
          "${order.id()}"
          "${order.name()}"
          "${order.description()}"
    <hr>
    </c:forEach>
</body>
</html>