
<form>
    num:<input type="number" name="num"/>
    <input type="submit" name="btn" value="Submit!"/>
</form>
<?php
if(isset($_GET['num']))
{
    $n = intval($_GET['num']);

    $firstNum = 1;
    $secondNum = 1;
    $thirdNum = 2;

    $result = 0;

    echo $firstNum . " ";
    echo $secondNum . " ";
    echo $thirdNum . " ";

    for ($i = 3; $i < $n; $i++)
    {

     $result = $firstNum + $secondNum + $thirdNum;
     echo $result . " ";
     $firstNum = $secondNum;
     $secondNum = $thirdNum;
     $thirdNum = $result;

    }
}

?>


