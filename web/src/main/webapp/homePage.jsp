
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            margin-top: 20px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            border-bottom: 1px solid #ddd;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Hii, ${sessionScope.email}</h1>
<h1 id="details"></h1>
<table>
    <tr>
        <th>Tracking Number</th>
        <td><input id="tracking" type="text" name="tracking"/></td>
        <td><input onclick="realTimeTracking()" type="submit" value="Tracking"/></td>
    </tr>
</table>
<script>
    function realTimeTracking() {
        let id = document.getElementById("tracking").value;
        let details = document.getElementById("details");
        const request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                details.innerText = request.responseText;
                setTimeout(realTimeTracking, 1000);
        };
        request.open("GET", "http://localhost:8080/web/tracking?tracking=" + id, true);
        request.send();
    }
</script>
</body>
</html>
