<?php
 require_once'koneksi.php';
 if($_SERVER['REQUEST_METHOD']=='POST')
{
   $nm_produk=$_POST['nm_produk'];
   $dec_produk=$_POST['dec_produk'];
   $harga=$_POST['harga'];
   $image=$_POST['image'];
   $query="INSERT INTO tb_produk(nm_produk,dec_produk,harga,image)VALUES('$nm_produk','$dec_produk',$harga,'$image')";
   $exeQuery=mysqli_query($konek,$query);

   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'berhasil menambahkan data'

      )
   ):json_encode(array('kode'=>2,'pesan'=>'data gagal ditambahkan'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}

?>