
        

        <?php 
        //Hämta endpoint
        $url="http://ashell.eu/api/products/api.php";

        if(isset($_POST["use_button"]))
        
        $url.= "?limit=" . $_POST["use_button"];
        
        //Hämta data, gör om till associativ array
        $data=file_get_contents($url);
        $products=json_decode($data, true);
        //print_r ($products); Kontrollera var värdena finns
        
        //Arrangera värdena som vi vill ha dem, sedan är datan klar att visas.
        $boxes ="<div class='container'>";
        foreach((array)$products as $key=>$value){
         
         $boxes.= "<div class='box'>";          
         $boxes.= "<div><a href='" . $value["img"] . "'" . "target='_blank'>";
         $boxes.= "<img src='" . $value["thumbnail"] . "'></a></div>";
         $boxes.= "<div class='text'><h2>" . $value["name"] . "</h2>";
         $boxes.=  $value["description"] . "<br>";
         $boxes.= "<div class='pris'>Pris: " . $value["price"] . " kr </div>";
         $boxes.= "I lager: " . $value["stock"] . " st </div></div>";
        } 
        $boxes.= "</div>";
        ?>
     