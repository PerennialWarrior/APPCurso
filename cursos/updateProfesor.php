<?php

$host = "localhost";
$db_name = "appcurso";
$username = "root";
$pass = "";
$respuesta = array();
$respuesta["cursos"] = array();
$conn = mysqli_connect($host, $username, $pass)
or trigger_error (mysqli_error($conn), E_USER_ERROR);
mysqli_select_db($conn, $db_name);

$id=$_POST['id'];
$profesor=utf8_encode($_POST['profesor']);
$registrado=$_POST['registrado'];

$query = "UPDATE cursos SET profesor = '".$profesor."', registrado = '".$registrado."' WHERE id = '".$id."'";
$query_execute = mysqli_query($conn, $query) or die (mysqli_error($conn));

mysqli_close($conn);


?>
