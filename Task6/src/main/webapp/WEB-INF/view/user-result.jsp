<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-body">
                    <h3 class="text-center mb-4">Submitted Data</h3>

                    <ul class="list-group mb-3">
                        <li class="list-group-item">
                            <strong>Username:</strong> ${user.username}
                        </li>
                        <li class="list-group-item">
                            <strong>Country:</strong> ${user.country}
                        </li>
                        <li class="list-group-item">
                            <strong>Programming Language:</strong> ${user.programmingLanguage}
                        </li>
                        <li class="list-group-item">
                            <strong>Operating Systems:</strong>
                            <span>
                                <c:if test="${user.linux}">Linux </c:if>
                                <c:if test="${user.macOs}">Mac OS </c:if>
                                <c:if test="${user.windows}">Windows </c:if>
                            </span>
                        </li>
                    </ul>

                    <div class="d-grid">
                        <a href="/user" class="btn btn-secondary">Back</a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
