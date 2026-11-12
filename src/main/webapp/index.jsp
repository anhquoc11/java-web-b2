<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
    <img src="images/Murach.png" alt="Murach" width="100" height="100">

    <h1><b>Survey</b></h1>
    <p>If you have a moment, we'd appreciate it if you would fill out this <br> survey.</p>

    <p style="color: red;"><i>${message}</i></p>

    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">

        <h1>Your information</h1>
        
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName" value="${user.firstName}"><br>

        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" value="${user.lastName}"><br>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" value="${user.email}"><br>

        <label for="dob">Date of Birth</label>
        <input type="date" id="dob" name="dob" value="${user.dob}"><br>

        <h1>How did you hear about us</h1>
        <input type="radio" id="search" name="heardFrom" value="Search engine" checked>
        <label for="search">Search engine</label>

        <input type="radio" id="word" name="heardFrom" value="Word of mouth">
        <label for="word">Word of mouth</label>

        <input type="radio" id="social" name="heardFrom" value="Social Media">
        <label for="social">Social Media</label>

        <input type="radio" id="other" name="heardFrom" value="Other">
        <label for="other">Other</label>

        <p>Would you like to receive announcements <br> about new CDs and special offers?</p>
        <p>
            <input type="checkbox" id="wantsUpdates" name="wantsUpdates" value="yes">
            <label for="wantsUpdates">YES, I'd like that.</label>
        </p>
        <p>
            <input type="checkbox" id="emailOffers" name="emailOffers" value="yes">
            <label for="emailOffers">YES, please send me email announcements and special offers.</label>
        </p>

        <label for="contactVia">Please contact me by:</label>
        <select id="contactVia" name="contactVia">
            <option value="Email or postal mail" selected>Email or postal mail</option>
            <option value="Email only">Email only</option>
            <option value="Postal mail only">Postal mail only</option>
        </select>

        <p><input type="submit" value="Submit" id="submit"></p>
    </form>
</body>
</html>