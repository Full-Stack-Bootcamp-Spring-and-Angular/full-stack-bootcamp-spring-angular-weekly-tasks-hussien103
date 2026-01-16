<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>User Form</title>
    <link  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-body">
                    <h3 class="text-center mb-4">User Form</h3>

                    <form:form method="post" action="submit" modelAttribute="user">

                        <div class="mb-3">
                            <form:input path="username" cssClass="form-control" placeholder="Username"/>
                        </div>

                        <div class="mb-3">
                            <form:password path="password" cssClass="form-control" placeholder="Password"/>
                        </div>

                        <div class="mb-3">
                            <form:select path="country" cssClass="form-select">
                                <form:option value="Brazil" label="Brazil"/>
                                <form:option value="USA" label="USA"/>
                                <form:option value="Germany" label="Germany"/>
                                <form:option value="Egypt" label="Egypt"/>
                            </form:select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Preferred Programming Language</label>
                            <div class="form-check">
                                <form:radiobutton path="programmingLanguage" value="Java" cssClass="form-check-input"/>
                                <label class="form-check-label">Java</label>
                            </div>
                            <div class="form-check">
                                <form:radiobutton path="programmingLanguage" value="C#" cssClass="form-check-input"/>
                                <label class="form-check-label">C#</label>
                            </div>
                            <div class="form-check">
                                <form:radiobutton path="programmingLanguage" value="PHP" cssClass="form-check-input"/>
                                <label class="form-check-label">PHP</label>
                            </div>
                            <div class="form-check">
                                <form:radiobutton path="programmingLanguage" value="Ruby" cssClass="form-check-input"/>
                                <label class="form-check-label">Ruby</label>
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">Preferred Operating System</label>
                            <div class="form-check">
                                <form:checkbox path="linux" cssClass="form-check-input"/>
                                <label class="form-check-label">Linux</label>
                            </div>
                            <div class="form-check">
                                <form:checkbox path="macOs" cssClass="form-check-input"/>
                                <label class="form-check-label">Mac OS</label>
                            </div>
                            <div class="form-check">
                                <form:checkbox path="windows" cssClass="form-check-input"/>
                                <label class="form-check-label">MS Windows</label>
                            </div>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-danger">Submit</button>
                        </div>

                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
