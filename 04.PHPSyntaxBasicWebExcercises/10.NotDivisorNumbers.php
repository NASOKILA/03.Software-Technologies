
<form>
    num: <input type="number" name="num"/>
    <input type="submit" value="Submit!"/>
</form>

<?php
if(isset($_GET['num']))
{
    $num = intval($_GET['num']);
    $copy = $num;
    while($num > 0)
    {
        if($copy % $num !== 0)
        {
            echo $num . " ";
        }
        $num--;
    }
}

?>