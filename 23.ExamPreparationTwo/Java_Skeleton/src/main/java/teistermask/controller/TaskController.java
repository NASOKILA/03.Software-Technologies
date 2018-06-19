package teistermask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import teistermask.bindingModel.TaskBindingModel;
import teistermask.entity.Task;
import teistermask.repository.TaskRepository;

import java.util.List;

@Controller
public class TaskController {
	private final TaskRepository taskRepository;

	@Autowired
	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	/*
	  5.1 Ot application.properties vijdame kak ni se kazva bazata POD spring.datasource.url i na koi port sme !

	  5.2 VAJNO!!!!! PREDI DA SI PUSNEM PROEKTA TRQBVA DA GO BUILDNEM INACHE SHTE NI DADE GRESHKA !!!!!!!!!!!!!!!

	  5.3 DOSTUPVAME PROEKTA NA localhost:8080

	  5.4 VAJNOOO ! NQMA DA NI DADE KARTINA DOKATO NE MU PODADEM NQKAKVO VIEW
	 */

	@GetMapping("/")
	public String index(Model model) {

		//1.Pravim si tri spisuka s taskove
		List<Task> openTasks = taskRepository.findAllByStatus("Open");
		List<Task> inProgressTasks = taskRepository.findAllByStatus("In progress");
		List<Task> finishedTasks = taskRepository.findAllByStatus("Finished");

		//2.i gi podavame na view-to
		model.addAttribute("openTasks", openTasks);
		model.addAttribute("inProgressTasks", inProgressTasks);
		model.addAttribute("finishedTasks", finishedTasks);

		//3.podavame samoto view i vrushtame basa-layout
		model.addAttribute("view", "task/index");
		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {

		//Prosto podavame viewto
		model.addAttribute("view","task/create");
		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, TaskBindingModel taskBindingModel) {

		//1. VZIMAME SI PODEDENOTO OT USERA I GO ZAPISVAME V TaskBindingModel MODEL
		TaskBindingModel newTask = taskBindingModel;

		//2.Proverqvame dali ima prazni poleta
		if(newTask.getTitle().equals("") || newTask.getStatus().equals(null) )
		{
			// redirektvame kum "/create"
			return "redirect:/create";
		}

		//Ako vsihcko e ok
		//3.Pravim si nov Task task = new Task(); i go pulnim s neshtata ot tozi task
		Task task = new Task();
		task.setStatus(newTask.getStatus());
		task.setTitle(newTask.getTitle());


		//4.Zapisvame v bazata noviq task i pravim .flush()
		taskRepository.save(task);
		taskRepository.flush();


		//4.Vrushteme se na index viewto
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {

		//1. Vzimam si ot bazata taska s poluchenoto id
		Task task = taskRepository.findOne(id);

		if(task.equals(null))
		{   //AKO NQMA TAKUV TASK SE VRUSHTAME KUM "/"
			return "redirect:/";
		}

		//2. Podavame go na viewto
		model.addAttribute("task", task);

		model.addAttribute("view", "task/edit");
		return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(@PathVariable int id, Model model, TaskBindingModel taskBindingModel) {

		//1. Vzimame si taska ot bazata
		Task changedTask = taskRepository.findOne(id);


		//2. Setvame mu novite parametri ot taskBindingModel-a
		changedTask.setTitle(taskBindingModel.getTitle());
		changedTask.setStatus(taskBindingModel.getStatus());

		//3. Proverqvame dali zaglavieto e prazno
		if(changedTask.getTitle().equals(""))
		{
			model.addAttribute("task", changedTask);
			model.addAttribute("view", "task/edit");
			return "base-layout";
		}



		//3. Prosto pravim flush na bazata BEZ DA SEIVAME NISHTO
		taskRepository.flush();

		//4. Vrushtame se kum index stranicata !!!!
		return "redirect:/";
	}
}
