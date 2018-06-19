package softuniBlog.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private Integer id;

    private String email;

    private String fullName;

    private String password;

    private Set<Role> roles;

    // DOBAVQME SI I STATII KUM USERA NO TRQBVA DA E SET A NE LIST ZASHTOTO NQMA KAK
    // DA IMAME EDNI I SUSHTI STATII
    private Set<Article> articles;



    public User(String email, String fullName, String password) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        // vrushtame nov set ot statii
        this.articles = new HashSet<>();
        this.roles = new HashSet<>();
    }


    //PRAVIM SI GETER I SETER ZA STATIITE:

    //Davame mu OneToMany Relaciq I GO MAPVAME KUM POLETO V DTUGIQ KLAS
    //KOETO DURJI TAZI STOINOST
    @OneToMany(mappedBy = "author")
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public User() {    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "fullName", nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "password", length = 60, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}