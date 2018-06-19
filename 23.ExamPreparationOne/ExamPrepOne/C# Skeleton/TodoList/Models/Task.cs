using System.ComponentModel.DataAnnotations;

namespace TodoList.Models
{
    public class Task
    {
        //TODO: Implement me...

        // ako anotaciite ne sa vklucheni gi puskame sus ALT + ENTER !!!


        [Key]
        public int Id { get; set; }

        [Required]
        public string Title { get; set; }

        [Required]
        public string Comments { get; set; }
        
    }
}