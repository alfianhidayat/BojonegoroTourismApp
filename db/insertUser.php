<?php
	if($_SERVER["REQUEST_METHOD"]=="POST"){
		require 'connection.php';
		createUser()
	}

	function createUser(){
		global $conn;

		$id_user = $_POST["id_user"];
		$username = $_POST["username"];
		$pass = $_POST["password"];

		$query = "insert into tb_user (id_user, username, password) values ('$id_user', '$username', '$password'); ";

		mysql_query($conn, $query) or die (mysql_error($conn));
	}
?>