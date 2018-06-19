package softuniBlog.entity;

import javax.persistence.*;
import java.beans.*;
import java.beans.Transient;

@Entity  // kazvame mu che e obekt v bazata danni
@Table(name="articles")   // kazvame mu che e tablica s ime articles
public class Article {

    // we have set the table name, now we need the columns

    private Integer id;
    private String title;
    private String content;
    private User author;

// SPRING OBICHA PRAZNITE KONSTRUTURI ZA DA SI PRAVI INSTANCII
    public Article() {

    }


    // Pravim si konstruktor bez ID zashtoto to idva ot bazata
    public Article(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    // We are going to place annotations on the getter methods

    // KATO NAPISHEM @Id VIJDAME CHE IMAME DVA ID-ta
    // VAJNO: ZA ID-to AKO E SVURZANO S BAZATA e po dobre da polzvame javax.persist
    //INACHE ORM-a SE BURKA !
    @Id // it will be primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false) // it cannot be epmty
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // kazvame che e required i che TIPUT NA KOLONATA V BAZATA E 'TEXT'
    @Column(columnDefinition = "text", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    /* TRQBVA DA SUZDADEM RELACIQ:
    *
    * RAVIM ManyToOne Relaciq
    *
    *S JoinColumn kazvame che iskame kolonata da se kazva "authorId" i da e nullable
    * */
    @ManyToOne
    @JoinColumn(nullable = false, name = "authorId")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    // this method will display half of th content
    // We are saying that this method will not be saved in the DB
    @javax.persistence.Transient        // IZPOLZVAME javax.persistence
    public String getSummary(){

        int endIndex = this.getContent().length() / 2;
        //rejem ot nachaloto do getContent() deleno na 2 i dobavqme tochici
        return this.getContent().substring(0, endIndex) + ". . .";
    }




}
