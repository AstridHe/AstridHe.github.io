<?php


header("Content-Type: application/json; charset=UTF-8"); 

//Arrayer med namn, beskrivning, bild, thumbnail och pris.

$namn = [
"Sänglampa",
"Krage",
"Taklampa",
"Takkrona",
"Julbelysning",
"Tyglykta",
"Skriv-spot",
"Matsalslampa",
"Golvlampa",
"Röd lykta",
"Glasburkar",
"Fotogenlampa",
"Päronlampa",
"Hängande",
"Rörlampa",
"Papperslampa",
"Scenlampa",
"Stjärna",
"Gatlykta",
"Vägglykta"
];

$beskrivning = [
    "Enkel grå skärm för sovrummet.",
    "Snygg skärm som inte döljer glödlampan.",
    "Flerarmad taklampa i glänsande metall.",
    "Exklusiv takkrona för finrummet.",
    "En fullständig uppsättning gatudekorationer.",
    "Vackra lampskärmar i kulörta färger.",
    "Funktionell, justerbar skrivbordslampa.",
    "En stilren lampa till matbordet.",
    "En statement-lampa som ger rummet det lilla extra.",
    "Thailändsk lykta för nyår.",
    "Konstfull konstruktion gjord av glasburkar.",
    "Fotogenlykta för vinterstormarnas strömavbrott.",
    "Glödlampa med päronform och glödtrådar.",
    "Tre glänsande metallskärmar.",
    "Unik vägglampa av rustika vattenrör.",
    "Rispapperslampor i diverse former.",
    "Scenlampa för dig som är trött på vintermörkret.",
    "Stjärnor att hänga i trädgården.",
    "Gatlykta i svart gjutjärn med guld-detaljer.",
    "Glaskupa till husfasaden.",
];

$bild= [
    "http://ashell.eu/images/bedlamp.jpg",
    "http://ashell.eu/images/brightbulb.jpg",
    "http://ashell.eu/images/ceiling-lamp.jpg",
    "http://ashell.eu/images/chandelier.jpg",
    "http://ashell.eu/images/christmas.jpg",
    "http://ashell.eu/images/colourful.jpg",
    "http://ashell.eu/images/desk-lamp.jpg",
    "http://ashell.eu/images/dininglamp.jpg",
    "http://ashell.eu/images/floor-lamp.jpg",
    "http://ashell.eu/images/flying-lantern.jpg",
    "http://ashell.eu/images/jar.jpg",
    "http://ashell.eu/images/kerosenelamp.jpg",
    "http://ashell.eu/images/pear.jpg",
    "http://ashell.eu/images/pendant.jpg",
    "http://ashell.eu/images/pipes.jpg",
    "http://ashell.eu/images/rice-paper.jpg",
    "http://ashell.eu/images/stage-light.png",
    "http://ashell.eu/images/star.jpg",
    "http://ashell.eu/images/street-lamp.jpg",
    "http://ashell.eu/images/wall-lamp.jpg"
];

$thumbnail= [
     "http://ashell.eu/images/bedlamp.thumb.jpg",
     "http://ashell.eu/images/brightbulb.thumb.jpg",
     "http://ashell.eu/images/ceiling-lamp.thumb.jpg",
     "http://ashell.eu/images/chandelier.thumb.jpg",
     "http://ashell.eu/images/christmas.thumb.jpg",
     "http://ashell.eu/images/colourful.thumb.jpg",
     "http://ashell.eu/images/desk-lamp.thumb.jpg",
     "http://ashell.eu/images/dininglamp.thumb.jpg",
     "http://ashell.eu/images/floor-lamp.thumb.jpg",
     "http://ashell.eu/images/flying-lantern.thumb.jpg",
     "http://ashell.eu/images/jar.thumb.jpg",
     "http://ashell.eu/images/kerosenelamp.thumb.jpg",
     "http://ashell.eu/images/pear.thumb.jpg",
     "http://ashell.eu/images/pendant.thumb.jpg",
     "http://ashell.eu/images/pipes.thumb.jpg",
     "http://ashell.eu/images/rice-paper.thumb.jpg",
     "http://ashell.eu/images/stage-light.thumb.png",
     "http://ashell.eu/images/star.thumb.jpg",
     "http://ashell.eu/images/street-lamp.thumb.jpg",
     "http://ashell.eu/images/wall-lamp.thumb.jpg"
];

$pris = [
    "1000", 
    "500", 
    "3000", 
    "2000", 
    "700", 
    "4000", 
    "5000", 
    "70000", 
    "5000",
    "1000",
    "500", 
    "400", 
    "1600", 
    "1100",
    "800",
    "8000",
    "1500",
    "1200",
    "7000",
    "4599"
];

//Om antal är valt genom en GET-request används det, annars är 10 defaultvärde.
//Om värdet som skickas i GET-requesten är över 20 eller inte ett heltal visas 
//felmeddelande i JSON-format. 
//0 räknas inte heller som heltal, och ger fel.
$limit=10;
if(isset($_GET["limit"])) 
{  
if(($_GET["limit"]<=20) && (!filter_var($_GET["limit"], FILTER_VALIDATE_INT)===false))
{
   $limit=$_GET["limit"];  
    }
else {
    $error=["error"=> "Limit måste vara ett heltal mellan 1 och 20."];
    $json =json_encode($error);
    print_r($json);
    exit;
}
}
//Stoppa in värdena i en nästlad array.
//Lägg även till en slumpad siffra till varje under-array. 
$products=[];

for($i=0; $i<$limit; $i++):
  
$pro=["name"=>$namn[$i], 
"description" =>$beskrivning[$i], 
"thumbnail"=>$thumbnail[$i],
"img"=>$bild[$i], 
"price"=>$pris[$i],
"stock"=>rand(0,50)];

$products[]=$pro;

endfor;
//print_r($products); Kontroll att arrayen är ok!

//Omvandla till JSON-kod och skriv ut.
$json =json_encode($products);

print_r($json);

