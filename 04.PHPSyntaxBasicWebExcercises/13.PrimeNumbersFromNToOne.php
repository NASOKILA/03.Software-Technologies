
<form>
    num:<input type="number" name="num"/>
    <input type="submit" name="btn"/>
</form>

<?php
if(isset($_GET['num']))
{
    $num = intval($_GET['num']);

    while($num > 1)
    {
        if ($num % 2 === 1 && ($num % 3 === 1 || $num % 3 === 2))
            echo $num . " ";
        else if($num === 3 || $num === 2)
            echo $num . " ";

        $num--;
    }

}

?>