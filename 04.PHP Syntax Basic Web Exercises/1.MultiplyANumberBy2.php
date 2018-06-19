
<form method="get">
    N: <input type="text" name="num"/>
    <input type="submit" value="Calculate!" />
</form>


<?php
if(isset($_GET['num']))
{
    $value = intval($_GET['num']);
echo $value * 2;
}
?>