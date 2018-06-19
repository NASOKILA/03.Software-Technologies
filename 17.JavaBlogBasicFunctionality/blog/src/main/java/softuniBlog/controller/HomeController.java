package softuniBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuniBlog.entity.Article;
import softuniBlog.repository.ArticleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    // We need the Article repository to get all the articles
    private final ArticleRepository  articleRepository;

    // DOBAVQ NI GO KATO PARAMETUR NA KONSTRUKTURA I S @Autowired go injectvame
    @Autowired
    public HomeController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/")
    public String index(Model model) {

        // We use the Article repository to get all the articles
        List<Article> allArticles = this.articleRepository.findAll();



        //WE NEED TO ADD THEM TO DTHE MODEL SO THAT THE VIEW CAN USE THEM :
        model.addAttribute("articles",allArticles);
        model.addAttribute("view", "home/index");
        return "base-layout";
    }
}







