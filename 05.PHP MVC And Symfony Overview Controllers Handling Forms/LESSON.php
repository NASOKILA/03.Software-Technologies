
ZA DA TRUGNAT SYMFONY PROEKTITE TRQBVA DA IZKLUCHISH APACHE V XAMPPA !!!

<?php
/**
MVC NI POMAGA ZA ORIENTACIQTA NA KODA
dori i da ne poznavame proekta.
MVC OZNACHAVA: MODEL VIEW CONTROLLER.

MVC-to stoi vurhu MODEL, VIEW i CONTROLLER.
Bsazata ot danni e svurzana s Modela a Klienta e svuran s
kontrolera, kontrolera e svurzan s Model i View


MODEL:
MODELITE SA KLASOVE, KAKTO V C# bqha sus set; i get;
modela e prosto edin klas obekt koito e kato pattern

NE e zaduljitelno da imame baza danni no ako imame tq trqbva da
e optimizirana, i da raboti burzo.
Modela i bazata ot danni vurvat ruka za ruka zashtoto modela
modelira informaciqta koqto shte zapazim v bazata danni I TE
TRQBVA DA SUVPADAT !


VIEW e neshtoto koeto se otvarq v brauzera, tova koeto vijda klienta, to
e krainiq rezultat, VIEW e STRUKTURATA NA HTML.
KAK DA SE VIZUALIZIRA DADENIQ MODEL, TOVA E VIEW.
Modela pazi konkretnite danni v bazata koito iskme klienta d vijda a
View gi izobrazqva na klienta.



CONTROLLER:
Toi pravi vsichki vidove proverki i vsichkata logika i vsichki izchisleniq
i precenki.
Kontrolera kontrolira neshtata, zatova se kazva kontroler, dali usera e
registriran, dali e joint, dali ima pravata da napravi dadenoto neshto,
dali ima restrikcii, dali nqkoi kontext e svurshil, dali sushtestvuva i t.n.
KONTROLERA E NQKAKUV KLAS V KOITO IMA NQKAKVA FUNKCIQ.

Kontrolera pravi vsichko vuzmojno modela da raboti sus veawto
TOI PITA BAZATA I TQ VRUSHTA CQLATA INFORMACIQ KOQTO KONTROLERA IZISKVA,
ZSHTOTO MODELA TAKA GO IZISKVA.
AKO BAZATA NE RAZSPOLAGA S TOVA KOETO KONTROLERA ISKA NI VRUSHTA GRESHKA
KOQTO NIE VIJDAME NA BRAUZERA.
KONTROLERA E SHEFA, TOI IMA VRUZKA SUS VICHKO.
MODELA GO INTERESUVA SAMO TOVA KOETO IMA TOEST: ime, godini, data na rajdane i t.n.
VIEW-to  E SHBLON NA HTML I NE ZNAE ZA NISHTO DRUGO OSVEN ZA KOI E MODELA t.e. kakvo
da vizualizira.


KLIENT:
Klienta e nqkakuv brauser, kogato napishem nqkakuv link v brausera
toi se svurzva us nqkoi surver koito e napraven sus nqkakvo MVC.
KLIENTA E TOVA KOETO VIJDAME NA BRAUZERA, toest KRAINIQ REZULTAT.



VUV VSICHKI GOLEMI PROEKTI SE POZVANQKAKUV VID MVC,
MVC E STARO ot 1970-te, hubavoto e che preizpolzvame kod,


ACTIONS : Vseki kontroller ima edin ili poveche actioni.
PRIMERNO EDIN CONTESTS CONTROLER  ILI POST KONTROLERA MOJE DA IMA : Edit, Create, Delete
and Update cshunite obiknovenno sa vurzani za nqkoq funkciq


USER CONTROLLER:
Toi ima samo Login i Register.
Pri register toi zapisva nov user a pri login vliza da proveri v bazata dali ima takuv i vliza
I dvete priemat username i parola.

 */


ZA DA TRUGNAT SYMFONY PROEKTITE TRQBVA DA IZKLUCHISH APACHE V XAMPPA !!!

/*Symphony :
Tova e konkreten sintaksis vurzan kum MVC.
Tova e MVC framework za PHP WEB PRILOJENIE !!!
Sazdaden e ot nqkakva firma.
Raboti s mnogo tipove bazi ot danni MySQL, SQLite, MSSQL, etc...

ZA VSEKI EZIK IMAME PONE PO 5 FAMEWORKA KOITO IZPULNQVAT MVC ROLQ.
MOJE DAPOLZVAME MVC I SUS DRUGI Frameworci.

SYMPHONY E KOMENTAR NAD SAMATA FUNKCIQ I NA BAZATA NA TOZI KOMENTAR FUNKCIQTA ZNAE
DALI DA SE IZPULNI KOGATO NQKOI USER DOSTUPI POSOCHENOTO NESHTO.

TRQBVA DA VLEZEM DA PROCHETEM V SAITA NA SYMPHONY!!!!!!!!!!!!!!!!!!!!!!!!!!!

.twig    E SHABLONA KOITO TRQBVA DA SE RANDERIRA !
 twig e neshtoto koeto vizualizira HTML-a RABOTI SE SUS {{TWIG SYNTAXIS}} v HTML-a,


PHP SE IZPOLZVA SAMO ZA WEB PROGRAMIRANE, DEBUGERA NE E ZADULJITELEN NO PREPORUCHITELEN.
V PHP VSE OSHTE NQMAT NAMESPEISI I ZATOVA GI PRAVIM SUS IMETO NA PAPKITE,
PRIMERNO V PAPKA CONTROLLERS NAMESPEISA SHTE BUDE CONTOROLERS.
V KRAQ NA NAMESPEISITE SE LAGA ;  ILI PROSTO OGRAJDAME CELIQ KOD V SKOBI,
PREPORUCHVA SE ; .

Za using - ite vmeto s . se slaga \ V c# E PRIMERNO: using System.Collections;
V PHP SHTE BUDE: use System\Collections;

Symphony e framework t.e. vunshna biblioteka 6 miliona reda kod,
ZA DA POLZVME TAZI BIBLIOTEKA TRQBVA DA Q INSTALIRAME NO POVECHETO BIBLIOTEKI ZAVISQT OT
DRUGI BIBLIOTEKI T.E. AVTOMATICHNO SE SVALQT I TQH.

OT SETTINGS/PLUGINS/BROWSE REPOSITORIES INStALIRAME SYMFONY PLUGINA KOETO NE E SYMFONY A E
SAMO PLUGIN ZA RABOTA SUS SYMFONI TO NI GO SVALA AVTOMATICHNO I NI PRAVI SKELET.
VTORIA PLUGIN KOITO NI TRQBVA E PHP ANNOTATIONS.

s ALT + F12 se otvarq terminalut

ZA DA TRUGNAT SYMFONY PROEKTITE TRQBVA DA IZKLUCHISH APACHE V XAMPPA !!!

PRILOJENIETO SE STARTIRA SUS KOMANDATA V KONZOLATA:   php bin\console server:run



Gledai  putishtata do proektite da sa ti kusi zashtoto ponqkoga ima restrikciq i
moje da dovede do greshki.


@var e za promenlivi
@return e za funkcii
@param e za parametri na funkcii
@route e za putishta do actioni t.e. funkcii koito vikat viwta ili drugo


SUS this->render('ImeNaView.html.twig',[masiv s imena i stoinosti na promenlivite koito iskame da ima]);  mojem da puskame nqkakvo view, TRQBVA DA ZAVURSHVA NA html.twig

KATO POSOCHIM NA DADENO VIEW KOETO NE SUSHTESVUVA I NATISNEM ALT + ENTER NI SUZDAVA TEMPLATE


V TWIG E VAJNOO DA ZNAEM CHE PRINTIRAME POLUCHENITE PROMENLIVI SU {{ ... }} A
KONTROLNITE STRUKTURI KATO IFOVE, CIKLI I DR GI PRAVIM SUS {% ... %}

FUNKCIITE MOJEM DA GI SLAGAME V PROMENLIVI KOITO POSLE DA POKAZVAME SUS {{ ... }}

SUS <a href="{{ path('IME NA ROUTE') }}">Go to route</a> MOJEM DA NAVIGIRAME
PO SYMFONY PUTISHTATA.
 
ZA DA TRUGNAT SYMFONY PROEKTITE TRQBVA DA IZKLUCHISH APACHE V XAMPPA !!!


for loopove ifove elsove i drugi mogat da se pishat i vuv samiqt html.twig fail
no se preporuchva vsichkata logika da se pishe vuv kontrolera


v PHP FOREACH CIKULA SE PISHE SAMO S FOR

AKO PISHEM V KONTROLERITE PISHEM NA PHP, AKO PISHEM DIREKTNO V HTMLITE PISHEM NA 
HTML I SYMFONY ILI PO SKORO TWIG KOETO E TEMPLATE ENGINE KOITO SE KESHIRA KUM HTML.

ContainsKey() v PHP e array_key_exists()


PRI SUZDAVANETO NA NOV SYMFONY KONTROLER:
//Avtomatichno ni kazva che se namira v nqkakuv specialen namespace za kontrolleri
// nasledqva specialen klas za kontrolleri v koito ima mnogo pomoshtni funkcii !
//AVTOMATICHNO NI POKAZVA KAK SE POLZVAT KONTOLLERITE I RENDERIRA NQKAKVO VIEW


NE E PRAVILNO VSICHKO DA SE PRASHTA PO GET, SAMO NESHTATA KOITO 
IZVLICHAT FUNKCII, KATO OPERATORA V NASHIQ SUCHAI

ALT + ENTER NI SUZDAVA NOV TEMPLATE

ZA FORMITE NE E NUJNO INPUTITE I DRUGITE NESHTA DA GI PRAVIM V HTML-A, SYMFONY
IMA EDNA OPCIQ ZA SUZDAVANE NA  SYMFONI FORM KOQTO NI OTVARQ EDIN KLAS, V NEGO 
IMA FUNKCIQ NA IME buildForm() I V NEQ MOJEM DA SI DEFINIRAME VSICHKO KOETO 
ISKAME NO E DOBRA PRAKTIKA DA SI NAPRAVIM I PAPKA Form !!!!!!



TRQBVA OBACHE DA ZPOMNIM NA IZUS KAKVO DA NAPISHEM VUV funkciqta:
configureOptions() TAM TRQBVA DA NAPISHEM SLEDNOTO:
$resolver->setDefaults(
[
'data_class' => Calculator::class
]);

Calculator::class shte se resolvne na AppBundle/Model/Calculator ...
no e dobre da izpolzvame Calculator::class zashtoto e strogo tipizirano
v smisul che ako promenim imeto na klasa to avtomatichno i tuk se promenq
a ako napishem samo stringa ili putqt nqma kak da se promeni i shte dovede do 
runtime greshki.

V CalculatorController  TRQBVA DA SI SUZDADEM FORMICHKA SUS
$form = $this->CreateForm(CalculatorType::class);
I TRQBVA DA Q PODADEM KATO VToRI PARAMETUR NA RENDERA

return $this->render('Calculator.html.twig',
           [
               'form' => $form->createView() // PAK TRQBVA DA SE ZAPOMNI NA IZUS!
           ]);

I VUV VIEWTO PROSTO PISHEM:

{{ form_start(form) }} <!--Taka otvarqme formichkata-->
{{ form_widget(form) }}
<input type="submit" name="btn"> <!--butona nqma sam da se napravi !-->

{{ form_end(form) }} <!--Taka zatvarqme formichkata-->






PRAVIM SI I PAPKA Model ZA VSICHKI MODELI !


MODELITE SA PROSTO PHP KLASOVE. PRI PRAVENETO IM PISHEM IME I SLAGAME NAMESPACE
KOETO E PROSTO PUTQ DO TAM:  AppBundle\Model I DAVEME OK. 

V MODELITE VECHE ZNAEM TRQBVA DA SI DEKLARIRAME PROMENLIVI, FUNKCII, GETTERI I 
SETTERI ZA VSQKA PROMENLIVA I NE ZABRAVQI /** ...symfony framework...*/

GETTERI, SETTERI I KONSTRUKTORI MOJEM DA GENERIRAME AVTOMATICHNO V MODELA SUS
ALT + INSERT !!!! ILI SUS DQSNO KOPCHE I GENERATE !!!!!!!

KONSTRUKTURUT ZA KALKULATORA IZGLEJDA TAKA :  
    
    /**
     * CalculatorModel constructor.
     * @param int $firstNumber
     * @param int $secondNumber
     */
    public function __construct($firstNumber, $secondNumber) 
    { 
// bez DVE dolni cherti nqma da proraboti !

	$this->firstNumber = $firstNumber;
        $this->secondNumber = $secondNumber;
    }


SUS CTRL + SPACE VIJDAME VUZMOJNITE OPCII ZA DADENI NESHTO


V PHP NQMA RAZLIKA MEJDU int i integer !



ZA SUBMITVANE NA FORMA NI TRQBVA $form->handeReauet($request);



ZA IZPITA SHTE NI TRQBVA DA PRINTIRAME PROMENLIVI, DA PRAVIM FORMULQRI, 
DA PISHEM FOR CIKLI  I IFCHETA PONQKOGA V SAMIQ HTML CHREZ TWIG !
Routove i dr




*/