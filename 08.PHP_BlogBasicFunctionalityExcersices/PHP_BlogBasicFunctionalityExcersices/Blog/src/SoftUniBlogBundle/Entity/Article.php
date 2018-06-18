<?php

namespace SoftUniBlogBundle\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\ORM\Mapping as ORM;

/**
 * Article
 *
 * @ORM\Table(name="articles")
 * @ORM\Entity(repositoryClass="SoftUniBlogBundle\Repository\ArticleRepository")
 */
class Article
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="title", type="string", length=255)
     */
    private $title;

    /**
     * @var string
     *
     * @ORM\Column(name="content", type="text")
     */
    private $content;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateAdded", type="datetime")
     */
    private $dateAdded;

    /**
     * @var string
     *
     *
     */
    private $summary ;


    // V Article.php si pravim %uthor ot tip User i si dobavqme drugite dve anotacii
    /*
     We’re using the “ManyToOne” annotation to tell the program that one user will
     have many articles.
     The other annotation is “JoinColumn”, which tells Doctrine how are we going
     to connect the fields in our entities. That the field “authorId” in our article
     entity will correspond to the “id” field from the User entity.
    */

    /** @var  User
     *
     *@ORM\ManyToOne(targetEntity="SoftUniBlogBundle\Entity\User",inversedBy="articles")
     *@ORM\JoinColumn(name="authorId", referencedColumnName="id")
     */
    private $author;



    // PRAVIM SI GETERI I SETERI ZA $authorId I KONSTRUKTOR ZA DAFAULT VALUE


    /**
     * @param User $author
     * @return Article
     */
    public function setAuthor(User $author = null)
    {
        $this->author = $author;

        return $this;
    }

    /**
     * @return User
     */
    public function getAuthor()
    {
        return $this->author;
    }

    // SUZDAVAME SI AOUTHORID AND SAVE IT IN THE DATABASE
    /**
     * @var string
     * @ORM\Column(name="authorId", type="integer")
     */
    private $authorId;

    //trqbvat ni get i set metodi za authorid :

    /**
     * @return string
     */
    public function getAuthorId()
    {
        return $this->authorId;
    }


    /**
     * @param string $authorId
     *
     * @return Article
     */
    public function setAuthorId($authorId)
    {
        $this->authorId = $authorId;
        return $this;
    }

    // WE SET DEFAUlt VALUES FOR OUR ENTITIES BY CREATING A CONSTRUKTOR
    // The constructors are special methods that are called each time
    // a new object from the entity is created.

    public function __construct()
    {
        $this->dateAdded = new \DateTime('now');
        // Every time we create a new article, it will add the current time
    }


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set title
     *
     * @param string $title
     *
     * @return Article
     */
    public function setTitle($title)
    {
        $this->title = $title;

        return $this;
    }

    /**
     * Get title
     *
     * @return string
     */
    public function getTitle()
    {
        return $this->title;
    }

    /**
     * Set content
     *
     * @param string $content
     *
     * @return Article
     */
    public function setContent($content)
    {
        $this->content = $content;

        return $this;
    }

    /**
     * Get content
     *
     * @return string
     */
    public function getContent()
    {
        return $this->content;
    }

    /**
     * Set dateAdded
     *
     * @param \DateTime $dateAdded
     *
     * @return Article
     */
    public function setDateAdded($dateAdded)
    {
        $this->dateAdded = $dateAdded;

        return $this;
    }

    /**
     * Get dateAdded
     *
     * @return \DateTime
     */
    public function getDateAdded()
    {
        return $this->dateAdded;
    }


    /*Now we should create the accessor. It should simply return the saved value in our summary variable. However, if
    summary is empty, it should call the mutator to set the value:*/


    /**
     * Get summary
     *
     * @return string
     */
    public function getSummary()
    {
            if($this->summary === null)
            {
                $this->setSummary();
            }
            return $this->summary;

        // It simply returns the saved value in our summary variable.
        // However, if summary is empty, it should call the mutator to set the value
    }


    /**
     * @param string
     */
    public function setSummary()
    {
    // We to set the value of the summary to half of the article content
        $this->summary = substr($this->getContent(),
                0, 50
            ) . " . . .";
    }


}

