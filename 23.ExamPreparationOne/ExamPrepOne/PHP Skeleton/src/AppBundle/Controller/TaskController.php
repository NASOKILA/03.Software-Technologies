<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Task;
use AppBundle\Form\TaskType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\HttpFoundation\Request;

class TaskController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {

        //GET THE TASKS FROM THE DB AND PASS THEM TO THE VIEW

        // Vzimame si Repositorito za taskovete
        $tasksRepo = $this->getDoctrine()->getRepository(Task::class);

        // vzimame si vsichki taskove
        $tasks = $tasksRepo->findAll();


        // PODAVAME GI KUM VIEWTO KOETO SHTE GI LISTNE VSICHKI
        return $this->render(':task:index.html.twig', ['tasks' => $tasks]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        // TOVA SHTE BUDE I GET I POST METOD



        //Za da vurnem kakvoto i da e ni trqbva forma tuk

        $task = new Task(); // V TAZI PROMENLIVA SHTE ZAPISHEM PODADENOTO OT FORMATA

        // TRQBVA DA E OT TIP TASKTYPE
        $form = $this->createForm(TaskType::class, $task); // Sega vsichko shte se zapishe vuv formata

        $form->handleRequest($request); // BEZ TOZI RED FORMATA NQMA KAK DA E VALIDNA FORMATA

        if($form->isSubmitted() && $form->isValid())
        {



            //TRQBVA DA PROVERIM DALI NQKOE OT POLETATA E PRAZNO
            if($task->getTitle() == null || $task->getComments() == null)
            {
                // Ako edno ot poletata e prazno redirektvame usera kum sushtata stranica 'create'
                return $this->redirectToRoute('create');
            }



            // Ako podadenoto ot formata e validno zapisvame noviq task v bazata, seivame bazata
            // i redirektvame um index stranicata

            // vzimame si bazata
            $em = $this->getDoctrine()->getManager();

            // zapisvame v neq nociq task
            $em->persist($task);

            //seivame promenite v bazata
            $em->flush();

            return $this->redirectToRoute('index');

        }

        // Ako sme tuk a purvi put shte vlezem tuk i posle shte vidim formata
        //Vlizame tuk i kogato ne e validno podadenoto ot formata !
        return $this->render('task/create.html.twig', ['form' => $form->createView()]);
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

        $taskRepo = $this->getDoctrine()->getRepository(Task::class);
        $task = $taskRepo->find($id);

        //AKO TASKA E NULL REDIREKTVAME KUM INDEX PAGE-a
        if($task == null)
        {
            return $this->redirectToRoute('index');
        }



        // {{ form_row(form._token) }}    TOZI EXCEPTION OZNACHAVA CHE ISKA OT NAS  DA NAPRAVIM FORMA
        //I DA Q PODADEM NA VIEWTO

        //PRAVIM SI FORMATA

        //Veche imame $task VZEHME GO PO id

        //Pravim si formata ot tip TaskType kato kazvame che shte zapishe vsicho v Promenlivata $task
        $form = $this->createForm(TaskType::class, $task);

        //TOVA E ZADULJITELNO
        $form->handleRequest($request);


        //FORMATA E SUBMITNATA SAMO KOGATO NATISNEM BUTONA DELETE OT Delete.Html.Twig
        if($form->isSubmitted() && $form->isValid())
        {
            //Ako sme suk znachi sme natisnali kopcheto Delete
            //TRIEM TASKA OT BAZATA

            //Vzimame bazata
            $em = $this->getDoctrine()->getManager();

            //Triem ot neq taska
            $em->remove($task);

            //Izpulnqvame i zapazvame promenite
            $em->flush();

            return $this->redirectToRoute('index');
        }


        //2.vrushtame viewto kato mu podavame taska
        // KATO POGLEDNESH VIEWTO TI STAVA QSNO KAKVO ISKA DA MU SE PODADE
        // V NASHIQ SLUCHAI ISKA 'task' I 'form'
        return $this->render('task/delete.html.twig',['task' => $task, 'form' => $form->createView()]);
    }
}




