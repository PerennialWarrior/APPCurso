<?php

$host = "localhost";
$db_name = "appcurso";
$username = "root";
$pass = "";
$conn = mysqli_connect($host, $username, $pass)
or trigger_error (mysqli_error($conn), E_USER_ERROR);
mysqli_select_db($conn, $db_name);

$desactivar = utf8_encode($_POST['desactivar']);
$nombre = utf8_encode($_POST['nombre']);
$apellido = utf8_encode($_POST['apellido']);
$cedula = utf8_encode($_POST['cedula']);
$usuario = utf8_encode($_POST['usuario']);
$rol = utf8_encode($_POST['rol']);
$contrasena = utf8_encode($_POST['contrasena']);
$codigo = utf8_encode($_POST['codigo']);
$correo = utf8_encode($_POST['correo']);
$telefono = utf8_encode($_POST['telefono']);
$facultad = utf8_encode($_POST['facultad']);
$programa = utf8_encode($_POST['programa']);
$cursos = utf8_encode($_POST['cursos']);
$matriculado = utf8_encode($_POST['matriculado']);
$horarioatencion = utf8_encode($_POST['horarioatencion']);

$query = "INSERT INTO usuarios (desactivar, nombre, apellido, cedula, usuario, rol, contrasena, codigo, correo, telefono, facultad, programa, cursos, matriculado, horarioatencion) VALUES ('".$desactivar."','".$nombre."','".$apellido."','".$cedula."','".$usuario."','".$rol."','".$contrasena."','".$codigo."','".$correo."','".$telefono."','".$facultad."','".$programa."','".$cursos."','".$matriculado."','".$horarioatencion."')";
$query_execute = mysqli_query($conn, $query) or die (mysqli_error($conn));

?>