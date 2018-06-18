<form>
    num: <input type="number" name="num" />
    <button type="submit" name="btn">Submit!</button>
</form>

<?php
if(isset($_GET['num']))
{
    $num = $_GET['num'];
    $result = 1;
    for($i = 1; $i <= $num; $i++)
    {
        $result *= $i;
    }
    echo $result;
}
?>