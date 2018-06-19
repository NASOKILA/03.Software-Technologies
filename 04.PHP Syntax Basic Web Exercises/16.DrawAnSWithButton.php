<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
</head>
<body>
<!--Write your PHP Script here-->
<?php
for ($e=1;$e<=5;$e++) {
    ?>
    <button style="background-color: blue">1</button>
    <?php
}
echo"<br/>";
for ($w = 1;$w <= 3;$w++)
{
    ?>

    <button style="background-color: blue">1</button>

    <?php

    for ($i = 1; $i <= 4; $i++)
    {
    ?>
        <button>0</button>
<?php
    }
    echo "<br/>";
}

for ($e=1;$e<=5;$e++) {
    ?>
    <button style="background-color: blue">1</button>
    <?php
}
echo "<br/>";
for ($i=1;$i<=5;$i++) {
    for ($a = 1;$a <= 3;$a++)
    {
        for ($i = 1; $i <= 4; $i++)
        {
            ?>
            <button>0</button>
            <?php
        }
        ?>
        <button style="background-color: blue">1</button>
        <?php
        echo "<br/>";
    }

}

for ($e=1;$e<=5;$e++) {
    ?>
    <button style="background-color: blue">1</button>
    <?php
}

?>

</body>
</html>