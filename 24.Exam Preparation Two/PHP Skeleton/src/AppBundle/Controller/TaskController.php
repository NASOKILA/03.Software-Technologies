<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Task;
use AppBundle\Form\TaskType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
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

        $taskRepo = $this->getDoctrine()->getRepository(Task::class);

        $openTasks = $taskRepo->findBy(['status' => 'Open']);
        $inProgressTasks = $taskRepo->findBy(['status' => 'In Progress']);
        $finishedTasks = $taskRepo->findBy(['status' => 'Finished']);

        return $this->render('task/index.html.twig',
            ['openTasks' => $openTasks,
            'inProgressTasks' => $inProgressTasks,
            'finishedTasks' => $finishedTasks
            ]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        $task = new Task();
        $form = $this->createForm(TaskType::class, $task);
        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid())
        {
            if($task->getTitle() == "")
            {
                return $this->redirect("/");
            }

            $em = $this->getDoctrine()->getManager();
            $em->persist($task);
            $em->flush();

            return $this->redirect("/");

        }

        return $this->render("task/create.html.twig", ['form' => $form->createView()] );
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
        //Tova go vzimame ot bazata po id
        $task = $this
            ->getDoctrine()
            ->getRepository(Task::class)
            ->find($id);

        //proverqvame dali e null
        if($task == null)
        {
            return $this->redirect("/");
        }


        //Suzdavame forma kato kazvame che shte zapisvame vsichko v $task
        $form = $this->createForm(TaskType::class, $task);

        //Hendelvame requesta
        $form->handleRequest($request);

        //proverqvame formata
        if($form->isSubmitted() && $form->isValid())
        {
            //proverqvame da li title e ""
            if($task->getTitle() == "")
            {
                return $this->redirect("/");
            }

          //Ako ne e ""

            $em = $this->getDoctrine()->getManager();

            //POLZVAME MERGE, T.E. SMESVAME TOVA V BAZATA S TOVA V PAMETTA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            $em->merge($task);
            $em->flush();

            return $this->redirect("/");
        }


       return $this->render('task/edit.html.twig', ['task' => $task, 'form' => $form->createView()]);

    }
}
