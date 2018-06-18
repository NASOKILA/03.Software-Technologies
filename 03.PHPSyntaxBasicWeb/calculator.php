<?php declare(strict_types=1);?>

<?php
$result = PHP_INT_MIN;
if(isset($_GET['sum_btn'])){ # proverqvame dali butona e natisnat
    # TE IDVAT KATO STRINGOVE ZATOVA TRQBVA DA GI PARSNEM.
    $a = intval($_GET['num1']);
    $b = intval($_GET['num2']);
    $oprion = $_GET['option'];

    if($oprion === "Sum")
    {
        $result = Sum($a, $b);
    }
    else if($oprion === "Divide")
    {
        $result = Div($a, $b);
    }


}
# Po default ako mu podadem string koito moje da se parsne kum chislo STAVA
# No zaradi declare(strict_types=1) trqbva da podavame samo nomera inache gurmi !
#SLAGAME IFA TUK ZA DA MOJEM DA GO POLZVAME VUV FORMATA OT DOLO !!!
?>


    <form> <!--PO DEFAULT E NA GET-->
        First Number: <input name="num1" type="number"value="<?= isset($_GET['num1']) ? $a : 0 ?>"/><br/>
        Second Number: <input name="num2" type="number" value="<?= isset($_GET['num2']) ? $b : 0 ?>"/><br/>

        <select name="option">
            <option>Sum</option>
            <option>Divide</option>
        </select>

        <?php if($result != PHP_INT_MIN){ # PRAVIM TAKA CHE DA SE POKAZVA SAMO KOGATO RESULTATUT NE E NULL !?>
        Result: <input disabled value="<?= isset($_GET['sum_btn'])
            ? $result
            : 0 ?>"/><br/>
        <?php }?>

        <input type="submit" value="Calculate!" name="sum_btn"/>
    </form>

<?php
# AKO DEKLARIRASH NESHTO VINAGI V NACHALOTO I V OTDELEN php TAG

# KAK SE DEKLARIRA FUNKCIQ ?
function Sum(int $a, int $b): int # sled skobite nie kazvame kakvo trqbva da vurne
{# tuk e hubavo i da pishem TIPOVETE
    return $a + $b;
}

function Div(int $a, int $b):float
{
    return $a / $b;
}

?>


