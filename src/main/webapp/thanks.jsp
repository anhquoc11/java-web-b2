<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<body>
    <h1>Thanks for taking our survey</h1>

    <p>Here is the information that you entered:</p>

    <label>Email:</label>
    <span>${user.email}</span><br>

    <label>First Name:</label>
    <span>${user.firstName}</span><br>

    <label>Last Name:</label>
    <span>${user.lastName}</span><br>

    <label>Date of Birth:</label>
    <span>${user.dob}</span><br>

    <label>Heard From:</label>
    <span>${survey.heardFrom}</span><br>

    <label>Wants Updates:</label>
    <span>${survey.wantsUpdates}</span><br>

    <label>Email Offers:</label>
    <span>${survey.emailOffers}</span><br>

    <label>Contact Via:</label>
    <span>${survey.contactVia}</span><br>

    <p>To enter another survey, click on the Return button shown below.</p>

    <form action="emailList" method="post">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>

</body>
</html>