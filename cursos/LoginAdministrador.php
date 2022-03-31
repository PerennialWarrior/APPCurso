<?php

$host = "localhost";
$db_name = "appcurso";
$username = "root";
$pass = "";
$conn = mysqli_connect($host, $username, $pass)
or trigger_error (mysqli_error($conn), E_USER_ERROR);
mysqli_select_db($conn, $db_name);

$usuario=utf8_encode($_POST['usuario']);
$contrasena=utf8_encode($_POST['contrasena']);

$query = "SELECT * FROM administrador WHERE usuario = '".$usuario."' AND contrasena = '".$contrasena."'";
$query_execute = mysqli_query($conn, $query) or die (mysqli_error($conn));

$arr1 = array();
while ($row=mysqli_fetch_array($query_execute)) {
    $arra = array('usuario' => $row['usuario'],'contrasena' => $row['contrasena']);
    array_push($arr1, $arra);
}

echo json_encode(array('administrador' => $arr1));

mysqli_close($conn);


?>