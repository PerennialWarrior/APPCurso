<?php

$host = "localhost";
$db_name = "appcurso";
$username = "root";
$pass = "";
$respuesta = array();
$respuesta["usuarios"] = array();
$conn = mysqli_connect($host, $username, $pass)
or trigger_error (mysqli_error($conn), E_USER_ERROR);
mysqli_select_db($conn, $db_name);

$nombre=$_GET['nombre'];

$query = "SELECT COUNT(cursos) FROM usuarios WHERE matriculado = 0 AND rol = 'Estudiante' AND cursos = '".$nombre."'";
$query_execute = mysqli_query($conn, $query) or die (mysqli_error($conn));

while ($row=mysqli_fetch_array($query_execute)) {
    $tmp = array();
    $tmp["cursos"] = $row["COUNT(cursos)"];

array_push($respuesta["usuarios"], $tmp);
}

header('Content-Type: application/json');

echo json_encode($respuesta);


?>
