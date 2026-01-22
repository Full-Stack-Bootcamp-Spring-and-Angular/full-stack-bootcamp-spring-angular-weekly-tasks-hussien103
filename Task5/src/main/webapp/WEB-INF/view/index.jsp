<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculate Age</title>

    <link
            rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow">
                <div class="card-body">
                    <h3 class="card-title text-center mb-4">
                        Age Calculator
                    </h3>

                    <form action="${pageContext.request.contextPath}/calculateAge" method="get">

                        <div class="mb-3">
                            <label class="form-label">Year</label>
                            <input type="number" name="year" class="form-control"
                                   placeholder="for example 1999" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Month</label>
                            <input type="number" name="month" class="form-control"
                                   placeholder="1 - 12" min="1" max="12" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Day</label>
                            <input type="number" name="day" class="form-control"
                                   placeholder="1 - 31" min="1" max="31" required>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">
                            Calculate Age
                        </button>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
