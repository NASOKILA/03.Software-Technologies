<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
    <style>
        div {
            display: inline-block;
            margin: 5px;
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
<!--Write your PHP Script here-->

<?php
$f = 0;
$s = 0;
$t = 0;
for ($i = 1; $i <= 5; $i++)
{

    for ($e = 1; $e <= 10; $e++)
    {
        ?>

        <div style="background-color: rgb(<?=$f?>,<?=$s?>,<?=$t?>)"></div>

        <?php
        $f += 5;
        $s += 5;
        $t += 5;
    }
    echo "<br/>";
    $f++;
    $s++;
    $t++;

}

?>
</body>
</html>