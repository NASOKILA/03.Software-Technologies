
<form>
    num1:<input type="number" name="num1">
    num2:<input type="number" name="num2">
    num3:<input type="number" name="num3">
    <input type="submit" value="Calculate!">
</form>
<?php
if(isset($_GET['num1']) && isset($_GET['num2']) && isset($_GET['num3']))
{
    $countNegativeNumbers = 0;
    $a = intval($_GET['num1']);
    $b = intval($_GET['num2']);
    $c = intval($_GET['num3']);

    $array = [$a, $b, $c];
    foreach ($array as $item) {
        if($item < 0)
            $countNegativeNumbers++;
        if($item === 0)
        {
            echo "Positive";
            return;
        }
    }

    if($countNegativeNumbers === 0 || $countNegativeNumbers === 2)
        echo "Positive";
    else
        echo "Negative";
}
?>