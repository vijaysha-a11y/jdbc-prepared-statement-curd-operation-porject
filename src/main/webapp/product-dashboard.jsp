<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product-Dashboard</title>
</head>
<body>
	
	<%
	
	String userEmail = (String) session.getAttribute("userSession");
	if(userEmail == null){
		response.sendRedirect(request.getContextPath()+"login-user.jsp");
		return;
	}
	int timeoutSeconds = session.getMaxInactiveInterval();
	%>
	
	<p>
		Logged in as: <strong><%= userEmail %></strong>
	</p>

	<p>
		Session expires in: <strong><span id="sessionTimer"><%= timeoutSeconds %></span></strong>
		seconds
	</p>

	<h4>Product-DashBoard</h4>
	
	<jsp:include page="product-display.jsp"></jsp:include>
	
	<script>
        let remainingSeconds = <%= timeoutSeconds %>;

        const timerElement = document.getElementById("sessionTimer");

        const countdown = setInterval(function () {
            remainingSeconds--;

            timerElement.textContent = remainingSeconds;

            if (remainingSeconds <= 0) {
                clearInterval(countdown);

                alert("Your session has expired. Please log in again.");

                window.location.href = "login-user.jsp";
            }
        }, 1000);
    </script>
</body>
</html>