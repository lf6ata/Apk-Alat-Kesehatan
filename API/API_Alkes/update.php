<?php
 require_once'koneksi.php';
 if($_SERVER['REQUEST_METHOD'])
{
   $id=$_POST['id'];
   $nm_produk=$_POST['nm_produk'];
   $dec_produk=$_POST['dec_produk'];
   $harga=$_POST['harga'];
   $image=$_POST['image'];

   $query="UPDATE tb_produk SET nm_produk='$nm_produk',dec_produk='$dec_produk',harga=$harga WHERE id='$id'";
   
   $exeQuery=mysqli_query($konek,$query);
   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'data berhasil update'
   	)
   ):json_encode(array('kode'=>2,'pesan'=>'data gagal diupdate'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}

//mengatur tampilan json
header('Content-Type: application/json');
?>
                     