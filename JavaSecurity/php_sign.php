
$key = "KEY";
$sequence = "hello";
$encrypted = hash_hmac('sha1', $sequence, $key, true);
echo base64_encode($encrypted).PHP_EOL;