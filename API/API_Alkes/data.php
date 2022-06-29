<?php

  	$server = "localhost";
	$username = "root";
	$password = "";
	$database = "db_data";


   $konek = mysqli_connect($server,$username,$password,$database);

	if (mysqli_connect_error()) {
		echo "Gagal konek dengan Database" . mysqli_connect_error();
	}

$query="SELECT * FROM tb_data";
$result=mysqli_query($konek,$query);
$array=array();
while($row=mysqli_fetch_assoc($result))
{
    $array[]=$row;
}
echo($result)?
json_encode(
	array(
		"notes"=>$array
	)
):json_encode(
	array(
		"kode"=>0,
		"pesan"=>"data tidak ditemukan"
	)
);

header('Content-Type: application/json');
                         
?>