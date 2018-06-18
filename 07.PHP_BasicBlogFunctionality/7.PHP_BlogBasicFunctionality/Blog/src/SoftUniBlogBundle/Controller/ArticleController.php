<?php

namespace SoftUniBlogBundle\Controller;

use Proxies\__CG__\SoftUniBlogBundle\Entity\User;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use SoftUniBlogBundle\Entity\Article;
use SoftUniBlogBundle\Form\ArticleType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\BrowserKit\Request;
use Symfony\Component\CssSelector\Parser\Reader;

class ArticleController extends  Controller
{


// SUS @Security anotaciqta ako ne sme lognati ne mojem da dostupim viewtp t.e. stranicata
// /articles/create
    /**
     * @Route("/articles/create", name="article_create")
     * @Security("is_granted('IS_AUTHENTICATED_FULLY')")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(\Symfony\Component\HttpFoundation\Request $request)
    {

        //Suzdavame si prazna statiq purvonachalno I Q PODAVAME VUV FORMATA ZA DA Q NAPULNI
        $article = new Article();

        // Sled koeto q podavame na formulqrat, taka toi shte q napulni ako bute izpraten pravilno

        // SLED KATO SVURSHIM RABOTA V ArticleType SI PRAVIM FORMATA I Q PODAVAME NA VIEWTO
        $form = $this->createForm(ArticleType::class, $article);

        // FORMATA ZADULJITELNO TRQBVA DA HENDELNE REQUESTA
        $form->handleRequest($request);



        // ZNAEM CHE POTREBITELQ E LOGNAT I SEGA TRQBVA DA NAPRAVIM TAKA CHE
        //toI DA BUDE AVTOR NA STATIQTA:

        //purvo si vzimame usera
        $loggerUser = $this->getUser();

        //Sled kato formulqra se spravi s requesta toi znae dali e validen ili ne
        //Ako toi e validen i submitnat
        if($form->isValid())
        {

            // Slagame tekushtiqt lognat potrebitel da bude avtor na statiqta:
            $article->setAuthor($loggerUser);

            // zapisvame Artikula v bazata !!!
            // Zapisvaneto stava s ENTITY MANAGER sukrateno e $em

            // Vzimame EntityManager:
            $em = $this->getDoctrine()->getManager();

            //Tozi Entity Manager znae kak da dobavq i trie obekti ot bazata

            //Dobavq se sus persist(),  Trie se sus remove()
            $em->persist($article); // Dobavqme si artiula v bazata

            // SLED DOBAVQNE VINAGI SE PUSKA flush() ZADULJITELNO !!!
            $em->flush();

        }

        return $this->render(
            'articles/create.html.twig',
            [
                'form' => $form->createView()
            ]
        );
    }


    /**
     *
     *@Route("/articles/list", name="article_list")
     */
    public function listArticles()
    {

        //Podavame mu masiva ot statii koito gi vzimame chrez REPOSITORY t.e. hranilishe.

        $articleRepository = $this->getDoctrine()->getRepository(Article::class);

        // vzehme repositorito na artikulite, TO SI IMA DADENI METODI V NEGO KOITO SHTE POLZVAME
        // mojem da tursim artikul po ID, po drug kriterii mojem da tursim samo edna statiq
        // mnogo statii i t.n.

        // s find() vzimame vsichi statii koeto e masiv razbirase.
        $allArticles = $articleRepository->findAll();


        //izprashtame masivat kum viewto
        return $this->render(
            'articles/list.html.twig',
            [
                'articles' => $allArticles
            ]);
    }

    /**
     *@Route("/articles/mine",name="article_my");
     */
    public function MyArticles()
    {

        // KAK DA VZEMEM SAMO STATIITE NA TEKUSHTIQ USER:
        // 1.PURVO SI VZIMAME USERA
        // 2.I POSLE OT NEGO DURPAME VSICHKITE NEGOVI STATII
        // 3.PODAVAME GI NA VIEWTO list.html.twig

        // KATO MU SLOJIM ANOTATIONA I KAJEM CHE E OT TIP User NI PODSKAZVA POSLE
        //KATO PISHEM $this-> CTRL + SPACE
        /** @var  User $currentUserAndAuthor */
        $currentUserAndAuthor = $this->getUser();

        $allArticles = $currentUserAndAuthor->getArticles();

        return $this->render('articles/list.html.twig',
            [
                'articles' => $allArticles
            ]);

    }


    // Polzvame $id na statiite, slagame go kato parametur
    /**
     * @Route("/articles/{id}", name="article_show")
     * @param $id
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function show($id)
    {
        //get current article:

        //1. get the article repository:
        $articleRepository = $this
            ->getDoctrine()
            ->getRepository(Article::class);

        //2.From here we take the current article by $id, we use find($id);
        $article = $articleRepository->find($id);

        //3. We send it to the view
        return $this->render('articles/show.html.twig',
            [
                'article' => $article
            ]);

    }

}









