<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Film;
use Doctrine\DBAL\Types\TextType;
use AppBundle\Form\FilmType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class FilmController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {
        // Vzimame si repositorito
        $repo = $this->getDoctrine()->getRepository(Film::class);

        //Vzimame si vsichki filmi
        $films = $repo->findAll();

        //podavame gi na viewto
        return $this->render('film/index.html.twig',['films' => $films]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        //1. Pravim is nov film
        $film = new Film();

        //2. Pravim si forma ot tip FilmType klas, i zapisvame vsichko v $film
        $form = $this->createForm(FilmType::class, $film);

        //3. Handvalme si requesta ZADULJITELNO
        $form->handleRequest($request);

        //4. Proverqvame dali formata e validna i submitnata
        if($form->isSubmitted() && $form->isValid())
        {
            //5. Ako formata e validna, proverqvame dali ima prazni poleta
            if($film->getName() == "" || $film->getGenre() == ""
                || $film->getDirector() == "" || $film->getYear() == null)
            {
                //5.1 Ako ima prazno pole ostavqme na sushtta stranica
                return $this->redirect("/create");
            }

            //6. Ako vsichko e ok vzimame si bazata, zapazvame filma i seivame
            $em = $this->getDoctrine()->getManager();
            $em->persist($film);
            $em->flush();

            //7. nakraq se vrushtme na "/"
            return $this->redirect("/");
        }

        //4.1 Ako formata ne e validna se vrushtame na sushtata stranica
        return $this->render("film/create.html.twig", ['form' => $form->createView()] );
	}

    /**
     * @Route("/edit/{id}", name="edit")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function edit($id, Request $request)
    {
        //Vzimame filma ot bazata po id
        $film = $this
            ->getDoctrine()
            ->getRepository(Film::class)
            ->find($id);

        //proverqvame dali e null
        if($film == null)
        {
            return $this->redirect("/");
        }

        //Suzdavame forma kato kazvame che shte zapisvame vsichko v $film
        $form = $this->createForm(FilmType::class, $film);

        //Hendelvame requesta ZADULJITELNO
        $form->handleRequest($request);

        //proverqvame formata dali e validna
        if($form->isSubmitted() && $form->isValid())
        {
            //proverqvame dali ima prazni poleta vus formata
            if($film->getName() == "" || $film->getGenre() == ""
                || $film->getDirector() == "" || $film->getYear() == null)
            {
                //Ako ima greshka se vrushtame na sushtoto view ZAPAZVAIKI POLETATA !
                return $this->render('film/edit.html.twig',
                    [
                        'film' => $film,
                        'form' => $form->createView()
                    ]);
            }

            //Ako ne e ""
            $em = $this->getDoctrine()->getManager();
            //POLZVAME MERGE, T.E. SMESVAME TOVA V BAZATA S TOVA V PAMETTA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            $em->merge($film);
            $em->flush();

            //Redirektvame kum glavnata stranica
            return $this->redirect("/");
        }

        //Ako formata ne e validna se vrushtame na sushtoto view
        return $this->render('film/edit.html.twig',
            [
            'film' => $film,
            'form' => $form->createView()
            ]);

    }

    /**
     * @Route("/delete/{id}", name="delete")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function delete($id, Request $request)
    {
        //1. vzimame taska no purvo ni trqbva repositorito
        $filmRepo = $this->getDoctrine()->getRepository(Film::class);
        $film = $filmRepo->find($id);

        //AKO FILMA E NULL REDIREKTVAME KUM INDEX PAGE-a
        if($film == null)
        {
            return $this->redirectToRoute('index');
        }

        $form = $this->createForm(FilmType::class, $film);
        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid())
        {

            //Vzimame bazata
            $em = $this->getDoctrine()->getManager();
            //Triem ot neq taska
            $em->remove($film);
            //Izpulnqvame i zapazvame promenite
            $em->flush();

            //Vrushtame se kum index page-a
            return $this->redirectToRoute('index');
        }

        //2.vrushtame viewto kato mu podavame taska
        return $this->render('film/delete.html.twig',
            [
                'film' => $film,
                'form' => $form->createView()
            ]);

    }
}
