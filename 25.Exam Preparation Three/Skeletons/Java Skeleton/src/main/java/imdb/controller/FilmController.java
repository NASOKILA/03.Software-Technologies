package imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import imdb.bindingModel.FilmBindingModel;
import imdb.entity.Film;
import imdb.repository.FilmRepository;

import java.util.List;

@Controller
public class FilmController {

	private final FilmRepository filmRepository;

	@Autowired
	public FilmController(FilmRepository filmRepository) {

		// VAJNO !!! TUK PROSTO SETVAME FILMREPOSITORITO :
		this.filmRepository = filmRepository;
	}

	@GetMapping("/")
	public String index(Model model) {

		// Vzimame vsichki filmi
		List<Film> films = filmRepository.findAll();

		// Podavame gi na viwto
		model.addAttribute("films", films);

		// Podavame samoto view
		model.addAttribute("view", "film/index");
		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {

		model.addAttribute("view", "film/create");
		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, FilmBindingModel filmBindingModel) {

		//1.Proverqvame dali ima prazni poleta
		if(filmBindingModel.getName().equals("") || filmBindingModel.getGenre().equals("")
				|| filmBindingModel.getDirector().equals(""))
		{
			// redirektvame kum "/create"
			return "redirect:/create";
		}

		//2.Pravim si nov film
		Film film = new Film();

		//3. I go setvame na BindingModea koito poluchihme
		film.setName(filmBindingModel.getName());
		film.setGenre(filmBindingModel.getGenre());
		film.setDirector(filmBindingModel.getDirector());
		film.setYear(filmBindingModel.getYear());

		//4.seivame v bazata i pravim flush
		filmRepository.saveAndFlush(film);

		//5. redirektvame kum "/"
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {

		// TOZI METOD E SUSHTIQ KATO TOZI NA DELETE !!!
		Film film = filmRepository.findOne(id);

		if(film == null)
		{
			return "redirect:/";
		}

		model.addAttribute("film", film);
		model.addAttribute("view", "film/edit");
		return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(Model model, @PathVariable int id, FilmBindingModel filmBindingModel) {

		//1. Vzimame si filma ot bazata
		Film changedFilm = filmRepository.findOne(id);

		if(changedFilm == null)
		{
			return "redirect:/";
		}

		//2. Setvame mu novite parametri ot filmBindingModel-a
		changedFilm.setName(filmBindingModel.getName());
		changedFilm.setGenre(filmBindingModel.getGenre());
		changedFilm.setDirector(filmBindingModel.getDirector());
		changedFilm.setYear(filmBindingModel.getYear());


		//3. Proverqvame dali NQKOE OT TQH e prazno
		if(changedFilm.getName().equals("") || changedFilm.getGenre().equals("")
				|| changedFilm.getDirector().equals("") || changedFilm.getYear() == 0)
		{

			//Ako ima prazno mqsto si ostavqme na sushtata stranica
			model.addAttribute("film", changedFilm);
			model.addAttribute("view", "film/edit");
			return "base-layout";
		}


		//3. AKO VSICHKO E OK prosto pravim flush na bazata BEZ DA SEIVAME NISHTO
		filmRepository.flush();
		// Moje da se napravi i sus filmRepository.saveAndFlush();


		//4. Vrushtame se kum index stranicata !!!!
		return "redirect:/";

	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {

		Film film = filmRepository.findOne(id);

		if(film == null)
		{
			return "redirect:/";
		}

		model.addAttribute("film", film);
		model.addAttribute("view", "film/delete");
		return "base-layout";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(@PathVariable int id) {

		Film film = filmRepository.findOne(id);

		if(film == null)
		{
			return "redirect:/";
		}

		filmRepository.delete(film);
		filmRepository.flush();

		return "redirect:/";
	}
}
