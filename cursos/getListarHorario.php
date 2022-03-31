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

$nombre=$_GET['nombre'];
$grupo=$_GET['grupo'];

$query = "SELECT * FROM cursos WHERE nombre = '".$nombre."' AND grupo = '".$grupo."'";
$query_execute = mysqli_query($conn, $query) or die (mysqli_error($conn));

while ($row=mysqli_fetch_array($query_execute)) {
    $tmp = array();
    $tmp["horarios"] = $row["horarios"];
    $tmp["cupos"] = $row["cupos"];
    $tmp["id"] = $row["id"];

array_push($respuesta["cursos"], $tmp);
}

header('Content-Type: application/json');

echo json_encode($respuesta);


?>
