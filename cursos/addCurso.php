<?php

$host = "localhost";
$db_name = "appcurso";
$username = "root";
$pass = "";
$conn = mysqli_connect($host, $username, $pass)
or trigger_error (mysqli_error($conn), E_USER_ERROR);
mysqli_select_db($conn, $db_name);

$nombre = utf8_encode($_POST['nombre']);
$descripcion = utf8_encode($_POST['descripcion']);
$fechainicio = $_POST['fechainicio'];
$fechafin = $_POST['fechafin'];
$horarios = utf8_encode($_POST['horarios']);
$fechasparciales = $_POST['fechasparciales'];
$grupo = $_POST['grupo'];
$cupos = $_POST['cupos'];
$registrado = $_POST['registrado'];

$query = "INSERT INTO cursos (nombre, descripcion, fechainicio, fechafin, horarios, fechasparciales, grupo, cupos, registrado) VALUES ('".$nombre."','".$descripcion."','".$fechainicio."','".$fechafin."','".$horarios."','".$fechasparciales."','".$grupo."','".$cupos."','".$registrado."')";
$query_execute = mysqli_query($conn, $query) or die (mysqli_error($conn));

?>