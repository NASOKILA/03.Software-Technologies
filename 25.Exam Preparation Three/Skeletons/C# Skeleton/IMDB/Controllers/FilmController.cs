using System.Linq;
using System.Net;
using System.Web.Mvc;
using IMDB.Models;
using System.Collections.Generic;

namespace IMDB.Controllers
{
    [ValidateInput(false)]
    public class FilmController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            // Otvarqme si bazovo prozorche sus using
            using (var db = new IMDBDbContext())
            {

                // vzimame vsichki filmi ot bazata
                List<Film> films = db.Films.ToList();

                // po davam gi na viewto kato spisuk zashtoto taka ochakva viewto
                return View(films);

            }
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
        {
            // prosto vushtame create viewto
            return View();
        }

        [HttpPost]
        [Route("create")]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Film film)
        {
            // Ako populnenoto e validno
            if (ModelState.IsValid)
            {
                
                using (var db = new IMDBDbContext())
                {
                    //dobavqme filma i zapazvame promenite v bazata
                    db.Films.Add(film);
                    db.SaveChanges();

                    // redirktvame kum index
                    return RedirectToAction("Index");
                }
            }

            return View(); // Ako populnenoto ne e validno ostavqme na sushtata stranica !
            
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {

            // Ako ni podadat id koeto e null vrushtame greshka
            if (id == null)
            {
                return HttpNotFound();
            }


            using (var db = new IMDBDbContext())
            {

                // vzimame si filma chrez id-to
                Film film = db.Films.Find(id);

                // Ako filma e null se vrushtame ku index page-a
                if (film == null)
                {
                    return Redirect("/");
                }

                // podavame filma na viewto
                return View(film);
            }


            
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int? id, Film filmModel)
        {

            // Ako ni podadat id koeto e null vrushtame greshka
            if (id == null)
            {
                return HttpNotFound();
            }


            using (var db = new IMDBDbContext())
                {
                    // Vzimame si filma chrez id-to
                    Film film = db.Films.Find(id);


                // Ako podadenoto ot formata NE e validno ostavqme na sushtata stranica
                if (!ModelState.IsValid)
                {
                    // polzvame actiona edit
                    return RedirectToAction("edit");
                }


                // ako filma ne e validen se vrushtame kum "/"
                if (film == null)
                {
                    return Redirect("/");
                }

                    //setvame mu stoinostite da sa ravni na tazi ot filmModel
                    film.Name = filmModel.Name;
                    film.Genre = filmModel.Genre;
                    film.Director = filmModel.Director;
                    film.Year = filmModel.Year;

                    //zapazvame promenite v bazata
                    db.SaveChanges();

                    // nakraq redirektvame kum index page-a
                    return Redirect("/");

                }
           
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int? id)
        {

            // Ako ni podadat id koeto e null vrushtame greshka
            if (id == null)
            {
                return HttpNotFound();
            }


            using (var db = new IMDBDbContext())
            {
                // Vzimame filma 
                Film film = db.Films.Find(id);

                // Ako filma e null se vrushtame ku index page-a
                if (film == null)
                {
                    return Redirect("/");
                }

                // i go podavame na viewto
                return View(film);
            }


        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int? id, Film filmModel)
        {
            // Ako ni podadat id koeto e null vrushtame greshka
            if (id == null)
            {
                return HttpNotFound();
            }



            // MODELA SHTE E VALIDEN ZASHTOTO NE MOJME DA GO PROMENQME!

            using (var db = new IMDBDbContext())
            {
                // NAMIRAME FILMA, PREMAHVAME GO, ZAPAZVAME BAZATA
                Film film = db.Films.Find(id);
                db.Films.Remove(film);
                db.SaveChanges();

                //Redirektvame kum Index stranicata !
                return Redirect("/");

            }


        }
    }
}