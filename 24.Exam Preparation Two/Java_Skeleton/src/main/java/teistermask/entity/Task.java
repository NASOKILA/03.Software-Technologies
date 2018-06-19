package teistermask.entity;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String status;


    // VAJNO !  V C# I V JAVA KOGATO NQMAME NITO EDIN KONSTRUKTOR,
    // AVTOMATICHNO NI SLAGA PRAZEN KONSTRUKTOR


    public Task() {
    }

    public Task(String title, String status) {
        this.title = title;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
