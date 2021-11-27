<?php
$key = "tHeApAcHe6410111";

function encrypt($data, $key) {
    return base64_encode(openssl_encrypt($data, "aes-128-ecb", $key, OPENSSL_RAW_DATA));
}

function decrypt($data, $key) {
    return openssl_decrypt(base64_decode($data), "aes-128-ecb", $key, OPENSSL_RAW_DATA);
}

$enc =  encrypt("Arnab C",$GLOBALS['key']);
echo "Encrypted : ".$enc."\n";
$enc="apcPtC7tD8/gUFssWEvnZQ==";
$dec = decrypt($enc,$GLOBALS['key']);
echo "Decrypted : ".$dec;

?>