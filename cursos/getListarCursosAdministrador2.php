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

$query = "SELECT * FROM cursos";
$query_execute = mysqli_query($conn, $query) or die (mysqli_error($conn));

while ($row=mysqli_fetch_array($query_execute)) {
    $tmp = array();
    $tmp["id"] = $row["id"];

array_push($respuesta["cursos"], $tmp);
}

header('Content-Type: application/json');

echo json_encode($respuesta);


?>
