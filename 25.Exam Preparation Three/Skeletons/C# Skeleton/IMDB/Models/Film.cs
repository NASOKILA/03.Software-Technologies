using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace IMDB.Models
{
    public class Film
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [AllowHtml] // s tozi atribut kazvame che ako nqkoi idiot napishe html kod v poleto da go smqta za string
        public string Name { get; set; }

        [Required]
        [AllowHtml]
        public string  Genre { get; set; }

        [Required]
        [AllowHtml]
        public string Director { get; set; }

        [Required]
        [AllowHtml]
        public int Year { get; set; }


    }
}