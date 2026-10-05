<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register Product</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: 'Segoe UI', Roboto, Arial, sans-serif;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 20px;
    }

    .card {
        background: #ffffff;
        border-radius: 16px;
        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15);
        padding: 40px 35px;
        width: 100%;
        max-width: 420px;
    }

    h4 {
        font-size: 22px;
        color: #2d2d2d;
        margin-bottom: 25px;
        text-align: center;
        font-weight: 600;
    }

    label {
        display: block;
        font-size: 13px;
        font-weight: 600;
        color: #555;
        margin-bottom: 6px;
        margin-top: 16px;
        text-transform: uppercase;
        letter-spacing: 0.5px;
    }

    input[type="text"],
    input[type="number"],
    input[type="date"] {
        width: 100%;
        padding: 12px 14px;
        border: 1.5px solid #e0e0e0;
        border-radius: 8px;
        font-size: 15px;
        color: #333;
        transition: border-color 0.2s ease, box-shadow 0.2s ease;
        outline: none;
        font-family: inherit;
    }

    input[type="text"]:focus,
    input[type="number"]:focus,
    input[type="date"]:focus {
        border-color: #764ba2;
        box-shadow: 0 0 0 3px rgba(118, 75, 162, 0.12);
    }

    input::placeholder {
        color: #aaa;
        font-size: 14px;
    }

    input[type="submit"] {
        width: 100%;
        margin-top: 28px;
        padding: 13px;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        color: #fff;
        border: none;
        border-radius: 8px;
        font-size: 15px;
        font-weight: 600;
        cursor: pointer;
        letter-spacing: 0.5px;
        transition: transform 0.15s ease, box-shadow 0.15s ease;
    }

    input[type="submit"]:hover {
        transform: translateY(-2px);
        box-shadow: 0 8px 16px rgba(118, 75, 162, 0.35);
    }

    input[type="submit"]:active {
        transform: translateY(0);
    }
</style>
</head>
<body>
    <div class="card">
        <h4>Register New Product</h4>
        <form action="productRegister" method="get">
            <label for="id">Product Id</label>
            <input type="text" id="id" placeholder="Enter product id" name="id" required>

            <label for="name">Product Name</label>
            <input type="text" id="name" placeholder="Enter product name" name="name" required>

            <label for="price">Product Price</label>
            <input type="number" id="price" placeholder="Enter product price" name="price" required>

            <label for="mfd">Product MFD</label>
            <input type="date" id="mfd" name="mfd" required>

            <label for="color">Product Color</label>
            <input type="text" id="color" placeholder="Enter product color" name="color" required>

            <input type="submit" value="Register Product">
        </form>
    </div>
</body>
</html>