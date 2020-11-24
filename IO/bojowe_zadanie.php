<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8"/>
	<title>bojowe zadanie</title>
</head>
<body>

<?php

	require_once "connect.php";
	
	$connection = @new mysqli($host, $db_user, $db_password, $db_name);
	
	if($connection->connect_errno!=0)
	{
		echo "Error: ".$connection->connect_errno;
	}
	else
	{
		$sql = "SELECT * FROM zadanie_specjalne WHERE id_osoby = 1";
		if($result = @$connection->query($sql))
		{
			for($i = 0; $i<$result->num_rows; $i++)
			{
				$row = $result->fetch_assoc();
				$information = $row['tresc'];
				echo $information."<br>";
			}	
			$result->free_result();
		}
		
		$connection->close();
	}

?>
</body>
</html>