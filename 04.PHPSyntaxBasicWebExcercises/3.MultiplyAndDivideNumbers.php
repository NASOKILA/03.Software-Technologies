

<form>
    N:<input type="number" name="num1"/>
    M:<input type="number" name="num2"/>
    <input type="submit" name="btn" value="Calculate!"/>
</form>
<?php
if(isset($_GET['num1']) && isset($_GET['num2']))
{
    $n = intval($_GET['num1']);
    $m = intval($_GET['num2']);
    if($n <= $m)
    {
        echo $n * $m;
    }
    else
    {
        echo $n / $m;
    }
}
?>