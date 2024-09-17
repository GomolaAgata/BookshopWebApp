<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="pjatk.tpo.tpo6_ga_s27943.Book" %>
<%@ page import="java.util.List" %>

<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bookstore</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("images/Unknown-2-transformed.jpeg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            color: #FAEBD7;
            font-size: 80px;
            font-family: 'Stencil Std', fantasy;
            margin-top: 40px;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            background-color: #FAEBD7;
            border-radius: 10px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .search-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 40px;
        }
        .search-container form {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .search-container input[type=text],
        .search-container input[type=number],
        .search-container input[type=submit] {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .search-container input[type=text]:focus,
        .search-container input[type=number]:focus {
            outline: none;
            border-color: #0056b3;
        }
        .search-container input[type=submit] {
            background-color: #FAEBD7;
            color: darkslateblue;
            border: none;
            cursor: pointer;
        }
        .search-container input[type=submit]:hover {
            background-color: #003d80;
        }
        .filter-inputs {
            display: flex;
            gap: 10px;
        }
        .filter-inputs label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Bookshop</h1>

<div class="search-container">
    <form action="booksServlet" method="GET">
        <input type="text" placeholder="Search for a book..." name="search">
        <div class="filter-inputs">
            <input type="number" id="minPrice" placeholder="Min Price" name="minPrice" step="0.5">
            <input type="number" id="maxPrice" placeholder="Max Price" name="maxPrice" step="0.5">
        </div>
        <input type="submit" value="Search">
    </form>
</div>

<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Price</th>
        <th>Number of pages</th>
        <th>Publication date</th>
    </tr>
    </thead>
    <tbody>
    <% for (Book book : books) { %>
    <tr>
        <td><%= book.getTitle() %></td>
        <td><%= book.getAuthor() %></td>
        <td><%= book.getPublisher() %></td>
        <td><%= book.getPrice() %></td>
        <td><%= book.getPages() %></td>
        <td><%= book.getDate() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
