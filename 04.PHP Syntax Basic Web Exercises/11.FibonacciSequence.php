
<form>
    num:<input type="number" name="num"/>
    <input type="submit" name="btn"/>
</form>
<?php

if(isset($_GET['num']))
{
    $n = intval($_GET['num']);
    $firstNum = 1;
    $secondNum = 1;
    $result = 0;
    echo $firstNum . " ";
    echo $secondNum . " ";
    for($i = 2; $i < $n;$i++) // n puti
    {
        $result = $secondNum + $firstNum; // 1
        echo $result . " "; // 1
        $firstNum = $secondNum; // 1
        $secondNum = $result;
    }
}
?>
