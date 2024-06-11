<%@ page import="java.util.List" %>
<%@ page import="com.devkm.app.entity.CargoEntity" %><%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cargo Details</title>
</head>
<body>
<%
  List<CargoEntity> cargoEntity =(List<CargoEntity>) request.getAttribute("cargoList");
  %>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Current Location</th>
    <th>Destination Location</th>
    <th>Origin Location</th>
    <th>Details</th>
    <th>Status</th>
    <th>Update Details</th>
  </tr>
  </thead>
  <tbody>
  <% for (CargoEntity cargoItem : cargoEntity) { %>
  <tr>
    <td><%= cargoItem.getId() %></td>
    <td><%= cargoItem.getCurrentLocation() %></td>
    <td><%= cargoItem.getDestinationLocation() %></td>
    <td><%= cargoItem.getOriginLocation() %></td>
    <td><%= cargoItem.getDetails() %></td>
    <td><%= cargoItem.getStatus() %></td>
    <td><a href="updateCargo?cargoId=<%=cargoItem.getId()%>">Update User</a></td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>
