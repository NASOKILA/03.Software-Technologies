<?php

namespace SoftUniBlogBundle\Controller;

use Proxies\__CG__\SoftUniBlogBundle\Entity\User;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use SoftUniBlogBundle\Entity\Article;
use SoftUniBlogBundle\Entity\Book;
use SoftUniBlogBundle\Form\ArticleType;
use SoftUniBlogBundle\Form\BookType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\BrowserKit\Request;
use Symfony\Component\CssSelector\Parser\Reader;

class BookController extends  Controller
{

    /**
     * @Route("/books/create", name="books_create")
     * @Security("is_granted('IS_AUTHENTICATED_FULLY')")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(\Symfony\Component\HttpFoundation\Request $request)
    {
        $book = new Book();
        $form = $this->createForm(BookType::class, $book);
        $form->handleRequest($request);
        $loggerUser = $this->getUser();
        if($form->isValid())
        {
            $book->setAuthor($loggerUser);
            $em = $this->getDoctrine()->getManager();
            $em->persist($book);
            $em->flush();
        }

        return $this->render(
            'books/create.html.twig',
            [
                'form' => $form->createView()
            ]
        );
    }

    /**
     *
     *@Route("/books/list", name="books_list")
     */
    public function listBooks()
    {
        $bookRepository = $this->getDoctrine()->getRepository(Book::class);
        $allBooks = $bookRepository->findAll();

        return $this->render(
            'books/list.html.twig',
            [
                'books' => $allBooks
            ]);
    }

    /**
     * @Route("/books/{id}", name="books_show")
     * @param $id
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function show($id)
    {
        $bookRepository = $this
            ->getDoctrine()
            ->getRepository(Book::class);

        $book = $bookRepository->find($id);

        return $this->render('books/show.html.twig',
            [
                'book' => $book
            ]);
    }

}









