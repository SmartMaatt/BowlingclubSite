<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8"/>
	<title>rejestracja pracownika</title>
</head>

<body>
	<h1>rejestracja pracownika</h1>
	<form action="rejestruj.php" method="post">
		Imię:          <input type="text" name="imie"/>       </br> </br>
		Nazwisko:      <input type="text" name="nazwisko"/>   </br> </br>
		Nr. klubu:     <input type="text" name="id_klubu"/>   </br> </br>
		Login:         <input type="text" name="login"/>      </br> </br>
		Hasło:         <input type="password" name="haslo1"/>  </br> </br>
        Powtórz hasło: <input type="password" name="haslo2"/>  </br> </br>
		<input type="submit" value="Rejestruj"/>
		<?php
			session_start();
			if (isset($_SESSION['error'])) {
				echo $_SESSION['error'];
			}
		?>
	</form>
</body>
</html>