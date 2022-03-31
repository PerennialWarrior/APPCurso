<?php

$host = "localhost";
$db_name = "appcurso";
$username = "root";
$pass = "";
$conn = mysqli_connect($host, $username, $pass)
or trigger_error (mysqli_error($conn), E_USER_ERROR);
mysqli_select_db($conn, $db_name);

$nombre=utf8_encode($_POST['nombre']);

$query = "SELECT * FROM cursos WHERE nombre = '".$nombre."' AND cupos > 0";
$query_execute = mysqli_query($conn, $query) or die (mysqli_error($conn));

$arr1 = array();
while ($row=mysqli_fetch_array($query_execute)) {
    $arra = array('id' => $row['id'],'nombre' => $row['nombre'],'descripcion' => $row['descripcion'],'fechainicio' => $row['fechainicio'],'fechafin' => $row['fechafin'],'horarios' => $row['horarios'],'fechasparciales' => $row['fechasparciales'],'grupo' => $row['grupo'],'cupos' => $row['cupos'],'profesor' => $row['profesor'],'registrado' => $row['registrado']);
    array_push($arr1, $arra);
	
    echo json_encode(array('cursos' => $arr1));
	

}

mysqli_close($conn);


?>