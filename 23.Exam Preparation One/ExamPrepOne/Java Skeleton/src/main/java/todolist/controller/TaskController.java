package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import todolist.bindingModel.TaskBindingModel;
import todolist.entity.Task;
import todolist.repository.TaskRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        //TODO:Implement me...

        // Tuk shte listnem vsichki taskove

        //1. Vzimae gi ot bazata kato polzvame repositorito
        // Za modela Task si imame veche napraveno repository
        // MODELITE I REPOSITORITATA V JAVA I C# SA RAZDELENI

        List<Task> tasks = taskRepository.findAll();

        // podavame gi v modela
        model.addAttribute("tasks", tasks);
        model.addAttribute("view", "task/index");

        return "base-layout";
    }

    @GetMapping("/create")
    public String create(Model model) {

        //TODO:Implement me...
        // TUK PROSTO TRQBVA DA PODADEM VIEW-to I DA VURNEM "base-layout" ta

        model.addAttribute("view", "task/create");
        return "base-layout";
    }

    @PostMapping("/create")
    public String createProcess(Model model, TaskBindingModel taskBindingModel) {
        //TODO:Implement me...

        //1. VZIMAME SI PODEDENOTO OT USERA I GO ZAPISVAME V TaskBindingModel MODEL
        TaskBindingModel newTask = taskBindingModel;


        //2. PROVERQVAME DALI title I comments SA PRAZNI
        if(newTask.getComments().equals("") || newTask.getTitle().equals(""))
        {
            //AKO EDNO OT TQH E PRAZNO, REDIRECTVAME KUM INDEX STRANICATA
            return "redirect:/";
        }


        //3. PRAVIM SI NOV TASK I GO PULNIM S TOVA KOETO E V TaskBindingModel-a
        Task task = new Task();
        task.setTitle(newTask.getTitle());
        task.setComments(newTask.getComments());


        //4. I GO DOBAVQME V BAZATA I ZAPISVAME
        taskRepository.save(task);
        taskRepository.flush();

        //5. VZIMAME SI PAK VSICHKI TASKOVE
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);

        //6. I GI VRUSHTAME SE KUM INDEX VIEWTO
        model.addAttribute("view", "task/index");
        return "base-layout";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        //TODO:Implement me...

        //1. VZIMAME SI TASKA CHREZ POLUCHENOTO ID
        Task task = taskRepository.findOne(id);

        //2. PROVERQVAME DALI E NULL, I AKO E REDIRECTVAME KUM INDEX VIEWTO

        // MNOGO VAJNO : TOVA SHTE RABOTI SAMO AKO POLZVAME '==' VMESTO .equals()
        if(task == null)
        {
            return "redirect:/";
        }

        //3. PODAVAME SI TASKA KUM VIEWTO
        model.addAttribute("task", task);

        //4. PODAVAME SI VIEWTO KOETO ISKAME
        model.addAttribute("view", "task/delete");
        return "base-layout";
    }

    @PostMapping("/delete/{id}")
    public String deleteProcess(Model model, @PathVariable int id) {
        //TODO:Implement me...

        //1. Vzimame si taska ot bazata s poluchenoto ID
        Task taskToDelete = taskRepository.findOne(id);

        //1.1 PROVERQVAME DALI E VALIDNO
        if(taskToDelete == null)
        {
            return "redirect:/";
        }

        //2. TRIEM GO OT BAZATA I SEIVAME
        taskRepository.delete(taskToDelete);
        taskRepository.flush();


        /*
        // VZIMAME SI VSICHKI TASKOVE
        List<Task> tasks = taskRepository.findAll();

        //VRUSHTAME PODAVEME GI KUM VIEWTO
        model.addAttribute("tasks", tasks);

        // VRUSHTAME SE KUM INDEX VIEWTO, VECHE SME PODALI TSKOVETE
        model.addAttribute("view", "task/index");
        return "base-layout"
        */

        // VMESTO DA PRAVIM VSICHKOTO GORE MOJEM PROSTO DA REDIREKTNEM KUM "/"
        return "redirect:/";
    }
}
