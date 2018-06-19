package todolist.entity;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {
	//TODO:Implement me...

    //Tuk trqbva da si slojim i id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String comments;

    // CHREZ DQSNO KOPCHE, generate, avtomatichno generirame get, set i konstruktor

    // TRQBVA DA NAPRAVIM VSICHKI GET METODI REQUIRED, OBCHE TUK E @Column(nullable = true) VMESTO Required !!!


    // pravim si i prazen konstruktor za da mojem da dotupvame instanciq na klasa
    public Task()
    {
    }

    public Task(String title, String comments) {
        this.title = title;
        this.comments = comments;
    }

    @Column(nullable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = true)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
