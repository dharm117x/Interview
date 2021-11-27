<?php
$data = "Hello World";
function encrypt($data)
{
    $publicKeyPEM = openssl_get_publickey(file_get_contents('public_key.pem'));
	$result = openssl_public_encrypt($data, $encrypted, $publicKeyPEM, OPENSSL_PKCS1_PADDING); 
	return $result ? base64_encode($encrypted) : false;
}

function decrypt($data)
{
    $privateKeyPEM = openssl_get_privatekey(file_get_contents('private_key.pem'));
	$result = openssl_private_decrypt(base64_decode($data), $decrypted, $privateKeyPEM, OPENSSL_PKCS1_PADDING);	 
	return $result ? $decrypted : false;
 }
  
 
$ecData =  encrypt($data);
echo $ecData;
$myfile = fopen("newfile.txt", "w") or die("Unable to open file!");
fwrite($myfile, $ecData);
fclose($myfile);

echo "\n";

echo decrypt($ecData);

?>