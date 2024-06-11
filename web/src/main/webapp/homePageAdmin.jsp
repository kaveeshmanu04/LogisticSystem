<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        h1, h2 {
            text-align: center;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
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
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #4CAF50;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Admin Dashboard</h1>
<h2>Add a Cargo </h2>
<form action="addCargo" method="post">
    <table>
        <tr>
            <th>Current Location</th>
            <td><input type="text" name="currentLocation"/></td>
        </tr>
        <tr>
            <th>Destination Location</th>
            <td><input type="text" name="destinationLocation"/></td>
        </tr>
        <tr>
            <th>Origin Location</th>
            <td><input type="text" name="originLocation"/></td>
        </tr>
        <tr>
            <th>Details</th>
            <td><input type="text" name="details"/></td>
        </tr>
        <tr>
            <th>Status</th>
            <td><input type="text" name="status"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="AddCargo"/>
            </td>
        </tr>
    </table>
</form>
<a href="viewCargo">View Cargo</a>
</body>
</html>
