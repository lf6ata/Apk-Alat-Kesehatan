<?php
 require_once'koneksi.php';
 if($_SERVER['REQUEST_METHOD']=='POST')
{
   $nama=$_POST['nama'];
   $username=$_POST['username'];
   $password=$_POST['password'];
   $query="INSERT INTO tb_login(nama,username,password)VALUES('$nama','$username','$password')";
   $exeQuery=mysqli_query($konek,$query);

   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'berhasil melakukan registrasi'

      )
   ):json_encode(array('kode'=>2,'pesan'=>'data gagal ditambahkan'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}

?>