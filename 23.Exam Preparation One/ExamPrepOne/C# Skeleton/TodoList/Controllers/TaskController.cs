using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;
using TodoList.Models;

namespace TodoList.Controllers
{
        [ValidateInput(false)]
	public class TaskController : Controller
	{
	    [HttpGet]
        [Route("")]
	    public ActionResult Index()
	    {

            // VZIMAME SI BAZATA
            TodoListDbContext db = new TodoListDbContext();

            // Durpame si taskovete
            List<Task> tasks = db.Tasks.ToList();  

            //davame gi na viewto
	        return View(tasks);
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
		{
			//Vrushtame samo view-to Create
		    return View();
		}

		[HttpPost]
		[Route("create")]
        [ValidateAntiForgeryToken]
		public ActionResult Create(Task task)
		{
            //1. PROVERQVAME DALI task-a E NEVALIDEN
            if (task == null)
            {
                return RedirectToAction("Index");
            }

            //2. PROVERQVAME DALI NQKOE PROPERTI E PRAZNO
            if (task.Comments == null || task.Title == null)
            {
                return RedirectToAction("Index");
            }

            // AKO VSICHKO E NARED
            //3. VZIMAME SI BAZATA
            TodoListDbContext db = new TodoListDbContext();

            //DOBAVQME SI TASKA I SEIVAME PROMENITE
            db.Tasks.Add(task);
            db.SaveChanges();

		    return RedirectToAction("Index");
        }

		[HttpGet]
		[Route("delete/{id}")]
        public ActionResult Delete(int id)
		{
            //vzimame si bazata
            TodoListDbContext db = new TodoListDbContext();

            // vzimame si taska ot bazata po id
            Task task = db.Tasks.Find(id);

            if (task == null)
            {
                return RedirectToAction("Index");
            }

            // podavame taska kum delete viewto
            return View(task);
        }

        [HttpPost]
		[Route("delete/{id}")]
        [ValidateAntiForgeryToken]
		public ActionResult DeleteConfirm(int id)
		{
            //vzimame si bazata
            TodoListDbContext db = new TodoListDbContext();

            // vzimame si taska ot bazata po id
            Task task = db.Tasks.Find(id);

            //Ako taska ne sushtestvuva vrushame se v index stranicata
            if (task == null)
            {
                return RedirectToAction("Index");
            }

            // Triem taska ot bazata i zpazvame promenite
            db.Tasks.Remove(task);
            db.SaveChanges();

            //redirektvame kum index metoda
            return RedirectToAction("Index");
        }
	}
}