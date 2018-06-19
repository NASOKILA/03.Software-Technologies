package softuniBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import softuniBlog.bindingModel.ArticleBindingModel;
import softuniBlog.entity.Article;
import softuniBlog.repository.ArticleRepository;
import softuniBlog.repository.UserRepository;

import java.beans.Transient;

// KAZVAME MU CHE E KONTROLLER, IMA NQKOLKO TIPA KONTROLLERI S RAZLICHNO POVEDENIE.
@Controller
public class ArticleController {

    // TRQBVA NI ARTICLE REPOSITORITO ZA DA MOJEM DA RABOTIM S BAZATA DANNI.
    // V JAVA DUMATA 'final' E SUSHTATA KATO 'const' V C#, Nie suzdadome konstanta!
    private final ArticleRepository articleRepository;


    // SVETESHE CQLOTO V CHERVENO ZASHTOTO ISKASHE DA BUDE INICIALIZIRANO.
    // KATO DADEM CTRL + SPACE SE INICIALIZIRA AVTOMATICHNO V KONSTRUKTURA

    // SUSHTOTO PRAVIM I ZA USER REPOSITORITO ZASHTOTO MOJE DA NI TRQBVA ZA NAPRED.
    private final UserRepository userRepository;


    @Autowired // S tova kazvame na spring da nabie repositori tuk
    public ArticleController(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }


    // Create articles:



    // Model model se pzprashta kum viewto avtomatichno, modela e tova koeto ni
    // pozvolqva da izprashtame kakvito i da e danni kum viewto

    // S @GetMapping() kazvame che samo shte pokazvame, v nashiq sluhai formata
    // i shte slusha na daden url

    //S @PreAuthorize("isAuthenticated()") Kazvame che trqbva da e autentikiran
    // IDVA OT SECURITY-to, TAM IMA MNOGO NESTA ZA UCHENE !!!
    @GetMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String create(Model model)
    {

        // izprashtame kvp key e view-to a  value e putq kum tova view
        model.addAttribute("view", "article/create");
        return "base-layout";
    }


    @PostMapping("/article/create") // tuk poluchavame dannite ot getMetoda
    @PreAuthorize("isAuthenticated()") // stava samo ako sme lognati
    public String createProcess(ArticleBindingModel model)
    {   // Kato parametur nu podavame ArticleBindingModelut koito iskame

        // Vzimame si lognatiq user t.e. email-a i parola
        UserDetails currentUser = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        // s ALT + ENTER go castvame go kum UserDetails zashtoto vrushta obekt



        // DA NO NA NAS NI TRQBVA SAMIQ USER
        // We can use it to extract the current entity user from the database
        softuniBlog.entity.User user = this.userRepository.findByEmail(currentUser.getUsername());
        // VECHE VZEHME USERA PO Email


        // Taka vzehme usera i sega mojem da napravim nova statiq
        Article article = new Article(
                // Artikula ima nujda ot title, content i avtor
                model.getTitle(),
                model.getContent(),
                user
                );

        // Suzdadohme go no trqbva da go zapishem v bazata!!!!!!!!
        this.articleRepository.saveAndFlush(article);
        //Zapisahme go


        //Sega trqbva da go redirektnem KUM MAIN-a T.E. '/'
        return "redirect:/";
    }


    // KAZVAME CHE SHTE IMA I Id , Vkarvame si modela, S Anotaciqta @PathVariable
    // KAZVAME CHE TOZI PARAMETUR SHTE BUDE VZET OT URL-a, S Integer id
    // kazvame che ohakvame Id-to de e ot tip Integer
    @GetMapping("/article/{id}")
    public String details(Model model, @PathVariable Integer id){

        // purvo shte proverim dali ima takuv artikul s takova Id
        // AKO NQMA SHTE REDIREKTNEM USERA KUM HOME PAGE !!!!!
        // V REALNATA PRAKTIKA POVECHE SHTE GO SRESHTAME S NULL: if(this.articleRepository == null){...}
        // ZASHTOTO RABOTI PO BURZO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if(!this.articleRepository.exists(id))
        {
            return "redirect:/";
        }

        // If it exist we take it from the DB by using our repository :
        Article article = this.articleRepository.findOne(id); // namirame go po Id

        // NOW WE WILL SENT THE ARTICLE AND THE VIEW TO OUR base-layout:
        model.addAttribute("article",article);
        model.addAttribute("view", "article/details");

        return "base-layout";
    }

    // We will create the edit method
    @GetMapping("/article/edit/{id}") // it takes an Id t the end, slusha n tozi url
    @PreAuthorize("isAuthenticated()") // trqbva da  sme authentikirani
    public String edit(@PathVariable Integer id, Model model){
        //podavame id-to i modela za da mojem da go polzvame

        //proverqvame dali statiqta sushtestvuva
        if(this.articleRepository == null)
        {
           return "redirect:/";
        }

        // ako go ima si go vzimame ot repositorito
        Article article = this.articleRepository.findOne(id);

        // i nakraq go zakachame kum viewto
        model.addAttribute("article", article);
        model.addAttribute("view", "article/edit");

        return "base-layout";
    }


    // Suzdavame si i editPost metoda
    @PostMapping("/article/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editProcess(@PathVariable Integer id, ArticleBindingModel articleBindingModel)
    {
        // shte polzvame binfing Modela za da validirame napisanoto ot usera
        // Tuk REALNO NIE ROMENQME Artikula

        // vzimame si artikula i go proverqvame dali e vliden
        Article article = this.articleRepository.findOne(id);

        if(article == null)
        {
            return "redirect:/";
        }


            // Ako e validen setvame content i title
            article.setContent(articleBindingModel.getContent());
            article.setTitle(articleBindingModel.getTitle());

            //SEIVAME GO V BAZATA
            this.articleRepository.saveAndFlush(article);

            //NAKRAQ REDIREKTVAME KUM Details NA TOZI ARTIKUL !!!!!
            return "redirect:/article/" + article.getId();


    }

    @GetMapping("article/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String delete(@PathVariable Integer id, Model model)
    {

        //vzimame si artikula
        Article article = this.articleRepository.findOne(id);

        //proverqvame dali e v bazata
        if(article == null)
        {
            // ako ne e se vrushtame v glavnata stranica
            return "redirect:/";
        }

        //ako sushtestvuva
        model.addAttribute("view", "article/delete");
        model.addAttribute("article", article);

        //vrushtame se kum glavnata stranica
        return "base-layout";
    }

    @PostMapping("/article/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteProcess(@PathVariable Integer id){
        // VZIMAME SI SAMO ID-to OT URL-a

        // vimame si artikula
        Article article = articleRepository.findOne(id);

        //proverqvame dali e validen
        if(article == null)
        {
            return "redirect:/";
        }

        //ako e validen GO TRIEM OT BAZATA
        this.articleRepository.delete(article);

        // NAKRAQ SE VRUSHTAME KUM NACHALNATA STRANICA I VIJDAME CHE ARTIKULA GO NQMA
        return "redirect:/";

    }



}







