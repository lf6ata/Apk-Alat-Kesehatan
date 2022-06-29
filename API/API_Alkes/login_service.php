<?php 
	require_once'koneksi.php';

	//tangkap data yang dikirim dari Android
	$username = $_POST["post_username"];
	$password = $_POST["post_password"];

	//proses periksa username dan password didatabase
	$query = "SELECT * FROM tb_login where username='$username' AND password='$password'";
	$obj_query = mysqli_query($konek, $query);
	$data = mysqli_fetch_assoc($obj_query);

	//periksa apakah login berhasil
	if ($data) {
		echo json_encode(
			array(
				'response' => true,
				'payload' => array(
					"nama" => $data["nama"],
					"username" =>$data["username"],
					"foto" =>$data["foto"]

				)
			)

		);
}
	else {
		echo json_encode(
			array(
				'response'=> false,
				'payload'=> null
			)
		);
}

//mengatur tampilan json
header('Content-Type: application/json');

?>