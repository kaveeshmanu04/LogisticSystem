<%@ page import="com.devkm.app.entity.CargoEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Cargo Details</title>
</head>
<body>

<%
CargoEntity cargoEntity=(CargoEntity) request.getAttribute("cargoEntity");
%>
<form action="updateCargo" method="post">
    <table>
        <tr>
            <th>Cargo Id</th>
            <td><input type="text" name="id" value="<%=cargoEntity.getId()%>"/></td>
        </tr>
        <tr>
            <th>Current Location</th>
            <td><input type="text" name="currentLocation" value="<%=cargoEntity.getCurrentLocation()%>"/></td>
        </tr>
        <tr>
            <th>Destination Location</th>
            <td><input type="text" name="destinationLocation" value="<%=cargoEntity.getDestinationLocation()%>"/></td>
        </tr>
        <tr>
            <th>Origin Location</th>
            <td><input type="text" name="originLocation" value="<%=cargoEntity.getOriginLocation()%>"/></td>
        </tr>
        <tr>
            <th>Details</th>
            <td><input type="text" name="details" value="<%=cargoEntity.getDetails()%>"/></td>
        </tr>
        <tr>
            <th>Status</th>
            <td><input type="text" name="status" value="<%=cargoEntity.getStatus()%>"/></td>
        </tr>
        <td></td>
        <td>
            <input type="submit" value="UpdateCargo"/>
        </td>
    </table>
</form>
</body>
</html>
