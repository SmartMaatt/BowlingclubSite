<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8"/>
	<title>Logowanie</title>
</head>

<body>
	<h1>Logowanie</h1>
	<form action="loguj.php" method="post">
		Login:   <input type="text" name="login"/>     </br> </br>
		Hasło:   <input type="password" name="haslo"/> </br> </br>
		<input type="submit" value="Zaloguj"/>
		<?php
			session_start();
			if (isset($_SESSION['error'])) {
				echo $_SESSION['error'];
			}
		?>
	</form>
</body>
</html>