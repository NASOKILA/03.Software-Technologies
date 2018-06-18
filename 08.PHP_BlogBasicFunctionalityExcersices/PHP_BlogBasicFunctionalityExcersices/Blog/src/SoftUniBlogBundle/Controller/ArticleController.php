<?php

namespace SoftUniBlogBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use SoftUniBlogBundle\Entity\Article;
use SoftUniBlogBundle\Form\ArticleType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class ArticleController extends Controller
{

    /**
     * @param Request $request
     *
     * @Route("/articles/create", name="article_create")
     *
     * @Security("is_granted('IS_AUTHENTICATED_FULLY')")
     *
     * @return \Symfony\Component\HttpFoundation\Response
     *
     */
    public function create(Request $request)
    {
        // slagame si Request $request v create fiunkciqta i Requesta trqbva da e
        // pod HttpFoudation

        // Suzdavame si prazen artikul
        $article = new Article();

        // Suzdavame si forma i podavame artikula za da se napulni
        $form = $this->createForm(ArticleType::class, $article);

        //set the form to handle requests
        $form->handleRequest($request);

        //we check if the form is valid
        if($form->isValid() && $form->isSubmitted())
        {
            // ako formata e validna trqbva da q zapishem v bazata

            // We set the author to be the current User();
            $article->setAuthor($this->getUser());

            /*Then we get the entity manager from doctrine and using the “persist”
            function we add our new article in the database*/
            $em = $this->getDoctrine()->getManager();
            $em->persist($article);

            // The flush() function sends the article to our database !
            $em->flush();

            // sled kato zapishem noviq artikul se vrushta me na glavnata stranica
            return $this->redirectToRoute('blog_index');
        }

        //return a vew:
        return $this->render('articles/create.html.twig',
            [
                'form' => $form->createView()
            ]
        );







    }

    /**
     * @Route("/articles/list", name="article_list")
     *
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function list()
    {
        // vikame si repositorito na artikulite
        $repository = $this
            ->getDoctrine()
            ->getRepository(Article::class);

        // i ot tam durpame vsichi artikuli
        $articles = $repository->findAll();

        return $this->render('articles/list.html.twig',
            [
                'articles' => $articles
            ]);
    }

    // PRAVIM SI I edit() funkciq koqto pokazva po edinichno vseki artikul kato dadem na Read More butona !
    /**
     * @Route("/articles/{id}", name="article_edit")
     * @param $id
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function edit($id)
    {
        $repository = $this
            ->getDoctrine()
            ->getRepository(Article::class);

        $article = $repository->find($id);

        return $this->render('articles/edit.html.twig',
            [
                'article' => $article
            ]);
    }

}
