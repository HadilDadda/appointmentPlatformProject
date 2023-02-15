<?php

$url ="mysql:host=localhost;dbname=prjteccart";
$dbuser ="root";
$dbpw ="";

//if(isset($_POST["username"])){
//    $utilUser = $_POST['username'];
//}
//
//if(isset($_POST["password"])){
//    $utilPass = $_POST['password'];
//}

$utilUser = $_POST['numStudent'];
$utilPass = $_POST['password'];

try
{
  $dbcon = new PDO($url,$dbuser,$dbpw);
  $dbcon->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
  
  $cmd = $dbcon->prepare("SELECT * FROM login WHERE numStudent= ? and password = ?;");
    
    $data = array($utilUser, $utilPass);
    $cmd->execute($data);
    
    $out = "";
    $line;
    while($line = $cmd->fetchObject())
    {
        $out .="$line->studentID".","."$line->numStudent".","."$line->password";
    }
}
catch(Exception $ex)
{
    $out = $ex->getMessage();
}
echo $out;
?>