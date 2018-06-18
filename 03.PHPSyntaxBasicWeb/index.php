<?php
echo "Hello Nasko !"; echo "<br/>";
echo "Hello Nasko !"; echo "<br/>";
echo "Hello Nasko !"; echo "<br/>";

/*Ne e nujno da ima tabulaciq v tagovete na php TOVA E GRESHNO!*/
//Coment
#Comment


#promenlivite se pishat s $
$variable = 5;
echo $variable; echo "<br/>";echo "<br/>";
#Ako nqma dolur znachi e konstanta
const name = "NaskoKonstanta";
echo name;

# V PHP I V DRUGI DINAMICHNI EZICI TIPUT NA PROMENLIVITE STAVAT QSNI V
# V MOMENTA V KOITO IM NAPISHEM STOINOST !

$n = 2;
$n = "DVE";
echo "Mojem v posledstvie da promqnqme tiput na promenlivite NO NE E DOBRA PRAKTIKA  ";
echo $n; echo "<br/>";echo "<br/>";

echo "V php nqma nikakva razlika v tipa mejdu edinichni i dvoini kavichki.";
echo "<br/>";echo "<br/>";
echo "Razlikata e che dvoinite kavichki pozvolqvat stringova interpolaciq!";
echo "<br/>";echo "<br/>";

#Sednoto e stringova interpolaciq
$fName = "Atanas";
$age = 24;
$greeting = "Hi, my name is $fName and I am $age old.";
echo $greeting;

echo "<br/>";echo "<br/>";
echo "Tova e stringova interpolaciq, ako promenlivata  greeding beshe v 
malki kavichki nqmashe da stane.";
echo "<br/>";echo "<br/>";

echo "isset(variable); proverqva dali nqkoq promenliva sushtestvuva 
NO SE POLZVA ZA PROVERKA DALI NQKAKVI DANNI SA PRISTIGNALI !";
echo "<br/>";echo "<br/>";

if(isset($fName))
    echo "Promenlivata $fName sushtestvuva!";
else
    echo "Promenlivata NE sushtestvuva!";
echo "<br/>";echo "<br/>";

echo "unset(variable); TRIE PROMENLIVATA !";
echo "<br/>";

unset($age);

if(isset($age))
    echo "Promenlivata $age sushtestvuva!";
else
    echo "Promenlivata NE sushtestvuva!";
echo "<br/>";echo "<br/>";

echo "AKO EDNA PROMENLIVA E NAPRAVENA VUV FUNKCIQ TO TQ NE MOJE DA SE POLZVA
IZVUN NEQ I OBRATNOTO. AKO E SAZDADENA IZVUN NEQ TO TQ NE MOJE DA SE POLZVA
VUV FUNKCIQTA";

$a = 5;
function nums(){

    //echo $a; # NE MI GO DAVA !!!
    $b = 4;
}

# echo $b;      DAVA MI CHE NE SUSHTESTVUVA PROMENLIVATA
echo "<br/>";echo "<br/>";

echo "intval() E KATO int.Parse();";
echo "<br/>";echo "<br/>";

?>


<?php
echo "Little exercise:";
echo "<br/>";echo "<br/>";

$month = date('m');
echo $month;

if($month >= 5 && $month <= 8){ ?>
<p>It is <?=date("M")?>, a summer time!</p>
<?php } else {?>
<p>It is NOT summer time!</p>
<?php } ?>



<?php
#date(); po default vzima dneshnata data
echo "<br/>";echo "<br/>";

echo "S gettype(variable); VZIMAME TIPUT NA DADENA PROMENLIVA!";
echo "<br/>";echo "<br/>";

echo gettype($month);
echo "<br/>";echo "<br/>";

echo "var_dump(varible) NI KAZVA KAKVA E STOINOSTTA, TIPUT DANNI I OSHTE!
POLZVA SE KATO DEBUGGER !!!";
echo "<br/>";echo "<br/>";

echo var_dump($month);
echo "<br/>";echo "<br/>";

echo "Mojem i da go polzvame za sravnenie no ne e dobra praktika";
echo "<br/>";echo "<br/>";


echo "Tuk nqma exceptioni: Primerno ako parsenem string kum int, tuk shte poluchim 0 !";
echo "<br/>";echo "<br/>";


echo intval($fName);
echo "<br/>";echo "<br/>";


echo "floatval(variable); parsva drobni chisla, to e kato double.Parse()";
echo "<br/>";echo "<br/>";

echo "Tuk === proverqva i tipovete VINAGi SRAVNQVAI SUS === ,  == provetqva samo stoinostite
bez tipovete. Ako sravnqvame 6 i '6' sus == shte kaje che sa ravni zashtoto kastva ednoto
kum dtugoto!";
echo "<br/>";echo "<br/>";

echo "filter_var() e neshto kato tryParse() ili tryCatch, toi slaga filtri vurhu dadena promenliva
i ni kazva dali e filtrirana i ni vrushta filtriranata stoinost ili vrusht false!";
echo "<br/>";echo "<br/>";

$six = "6";
if(filter_var($six, FILTER_VALIDATE_INT))# opitvame da go parsnem kum chislo
{
    echo "Parsnahme stringa kum chislo";
}
else
{
    echo "Ne mojahme da parsnem stringa kum chislo !";
}

echo "<br/>";echo "<br/>";
echo "DOBRA PRAKTIKA E DA NE SMENQME TIPOVETE NA PROMENLIVITE I DA NE SRAVNQVAME S ==";


echo "<br/>";echo "<br/>";
echo "<=> e sushtoto kato CompareTo() v C#, VRUSHTA DALI PURVOTO E PO-MALKO, PO-GOLQMO ILI 
RAVNO NA VTOROTO, VRUSHTA -  1, 0 ILI 1 !";


echo "TUK ZAKRUGLQME SUS number_format();";
echo "<br/>";echo "<br/>";


echo "<br/>";echo "<br/>";
$oneHundred = 100;
$sumeNumB = 5;

echo $oneHundred <=> $sumeNumB;
echo "<br/>";echo "<br/>";

echo "TUK ZA DA PROMENIM IMENATA NA VSICHKI EDNAKVI PROMENLIVI NAVEDNUJ OTIVAME VURHU EDNATA I 
NATISKAME SHIFT + F6";
echo "<br/>";echo "<br/>";

echo "CIKLI: Te sa absolutno ednakvi samo deto ne definitash tiput danni,
break i contonue sa edni i sushti !!!";
echo "<br/>";echo "<br/>";

echo "Razlikata vuv foreach e che mojem da slojim kluchovete na daden masiv primerno.";
echo "<br/>";echo "<br/>";

echo "TUK MASIVITE SA I RECHNICI KUDETO INDEKSITE SA KLUCHOVETE A STOINOSTITE SA SI STOINOSTI.";
echo "<br/>";echo "<br/>";


# Tuk masivite sa i rechnici
$x = [
    "Naso" => 24,
    "Asi" => 25,
    "Toni" => 23,
    33 => "Toshko",
    '7' => "Bobi",
    "Toplo?" => true,
];

echo var_dump($x);
echo "<br/>";echo "<br/>";


echo "Tuk nqma mnogo prilojeniq koito da chetat ot konzolata, povecheto sa web apps.
Mojem da chetem ot konzolata sus fgets(STDIN); To e kato Console.ReadLine(); Samoche 
trqbva da go runnem ot konzolata !";
echo "<br/>";echo "<br/>";


echo "php FORMS:";
echo "<br/>";echo "<br/>";

echo "GET sa neshtata koito vurvat po URLa a POST e informaciq koqto se
prenasq NE po URLa a po drug nachin TOVA GO RESHAVAME V TAGA form S 
method='' !";
echo "<br/>";echo "<br/>";
?>


<form method="post" action=""><!--KATO E GET ZNACHI PRASHTAME PO URLa VIJ URLa SLED KATO KLIKNESH BUTONA!-->
    <!--method="" reshava kak da se izpratqt dannite ot formichkite, po URL ili ne !-->
    <!-- action="" kum koi fail ili kum koi URL adres da se izpratqt dannite v poletata !-->
    <label>Name:</label><input name="name"/><br/>
    <label>Age:</label><input name="age"/><br/>
<button type="submit">Send!</button>
</form>


<?php
echo "Get:";
var_dump($_GET); # $_GET TOVA E DOBUR NACHIN DA PROVERQVAME GET ZAQVKI STAVA I S $_POST !
echo "<br/>";echo "<br/>";

echo "Post:";
var_dump($_POST); # STAVA I S POST
echo "<br/>";echo "<br/>";

echo "Poluchavame masiv kato rechnik v koito kluhovete sa nameovete name i age !!!";
echo "<br/>";echo "<br/>";


echo "Za printirane na masivi se polzva implode(); tq e kato string.Join();";
echo "<br/>";echo "<br/>";

$arr = [43,75,8,2,32,56];
echo implode(", ", $arr);
echo "<br/>";echo "<br/>";



echo "Za repleisvane na stringove se polzva str_replace(whatToReplace,withWhatToReplace, inWhichString); 
tq e kato string.Join();";
echo "<br/>";echo "<br/>";

$str = "Atanas Kambi***";
echo str_replace("***","tov", $str);
echo "<br/>";echo "<br/>";

echo "S CTRL + Click vurhu daden metod mojem da go vidim kak e napraven ! ";
echo "<br/>";echo "<br/>";

echo "Prevrushtane na masiv vuv obiknoven string sus join();";
echo "<br/>";
$arr2 = [1,2,3,4,5];
$arr2Str = join(" ", $arr2);
echo $arr2Str;
echo "<br/>";echo "<br/>";


echo "Prevrushtane na obiknoven string v masiv sus explode() ili sus split();";
echo "<br/>";
$simpleStr = "1 2 3 4 5";
$simpleStrArr = explode(" ", $simpleStr);
echo implode(",", $simpleStrArr);
echo "<br/>";echo "<br/>";



echo "Ako edna funkciq e zachertnata znachi e deprikated koeto oznachava che veche ne se polzva i e 
zamestena s nqkoq druga ! ";
echo "<br/>";echo "<br/>";


echo "MASIVITE MOGAT DA SE SORTIRAT SUS sort() i usort() asort() i mnogo drugi rzlichni 
metodi za sortirane";
echo "<br/>";echo "<br/>";

echo "KONKATENACIQTA SE PRAVI S . VMESTO SUS +";
echo "<br/>";echo "<br/>";


echo "ESKEIPVANETO SE PRAVI PAK SUS \ KAKTO VUV C#";
echo "<br/>";echo "<br/>";

?>









<?php
echo "<br/>";echo "<br/>";
echo "<br/>";echo "<br/>";
echo "<br/>";echo "<br/>";
echo "<br/>";echo "<br/>";
?>