


    <ul>
        <?php for ($i = 1; $i <= 20; $i++){ ?>
           <?php
            if($i % 2 == 1){ ?>

                <li><span style="color: blue"><?=$i?></span></li>
                <?php }
                else{ ?>
                <li><span style="color: green"><?=$i?></span></li>
        <?php }} ?>
    </ul>

<?php
# for cikula moje i da e zatvarq sus endfor;
# MOJEM DA POLZVAME I TERNALEN OPERATOR ZA CVETA:
#color = i$ % 2 == 0 ? "green" : "blue";
?>










