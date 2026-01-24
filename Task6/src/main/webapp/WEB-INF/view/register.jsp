<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
<div class="container mt-5">
    <div class="card p-4 shadow-sm" style="max-width: 450px;">
        <h3>Employee Registration Form</h3>

        <form:form method="post" modelAttribute="employee">

            <div class="mb-3">
                <label>Username</label>
                <form:input path="username" class="form-control"/>
                <form:errors path="username" cssClass="text-danger"/>
            </div>

            <div class="mb-3">
                <label>Email address</label>
                <form:input path="email" class="form-control"/>
                <form:errors path="email" cssClass="text-danger"/>
            </div>

            <div class="mb-3">
                <label>Password</label>
                <form:password path="password" class="form-control"/>
            </div>

            <div class="mb-3">
                <label>Confirm Password</label>
                <form:password path="confirmPassword" class="form-control"/>
                <form:errors path="*" cssClass="text-danger"/>
            </div>

            <button class="btn btn-primary">Submit</button>

        </form:form>
    </div>
</div>
</body>
</html>