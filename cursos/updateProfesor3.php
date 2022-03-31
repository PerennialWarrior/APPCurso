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

$cedula=$_POST['cedula'];
$nombreOriginal=utf8_encode($_POST['nombreOriginal']);
$matriculado=$_POST['matriculado'];

$query = "UPDATE usuarios SET matriculado = '".$matriculado."', cursos = '".$nombreOriginal."' WHERE cedula = '".$cedula."'";
$query_execute = mysqli_query($conn, $query) or die (mysqli_error($conn));

mysqli_close($conn);


?>
