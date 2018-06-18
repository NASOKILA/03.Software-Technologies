    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>First Steps Into PHP</title>

    </head>
    <body>
    <form>
        N: <input type="number" name="num1" />
        M: <input type="number" name="num2" />
        <input type="submit" />
    </form>
    <ul>
        <!--Write your PHP Script here-->
        <?php
        if(isset($_GET['num1']) && isset($_GET['num2']))
        {
            $num1 = intval($_GET['num1']);
            $num2 = intval($_GET['num2']);

            for ($i = 1; $i <= $num1; $i++) {
                ?>
                <li>List <?= $i ?>
                    <ul>
                        <?php
                            for ($o = 1; $o <= $num2; $o++)
                            {
                                ?>
                                <li>
                                    Element <?=$i. "." . $o?>
                                </li>
                                <?php
                            }
                        ?>
                    </ul>
                </li>
                <?php
            }
        }
        ?>
    </ul>
    </body>
    </html>