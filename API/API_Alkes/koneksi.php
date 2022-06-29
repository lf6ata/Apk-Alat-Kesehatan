<?php
   include'config.php';

   $konek = mysqli_connect($server,$username,$password,$database);

	if (mysqli_connect_error()) {
		echo "Gagal konek dengan Database" . mysqli_connect_error();
	}
 ?>