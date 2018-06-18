<?php

namespace SoftUniBlogBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Article
 *
 * @ORM\Table(name="article")
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
     * @ORM\Column(name="title", type="string", length=150)
     */
    private $title;

    /**
     * @var string
     *
     * @ORM\Column(name="content", type="text")
     */
    private $content;

    //pravim si $summary za Read More butona

    /** @var  string*/
    private $summary;


    // ako e pod 50 sinvola da vrushta celiqt artikul, ako ne da vurne samo
    // purvite 5 sivole i ...
    /**
     * @return string
     */
    public function getSummary(): string
    {
        if(strlen($this->getContent()) <= 50)
        {
            return $this->getContent();
        }
        // Ako li ne rejem purvite 50 sinvola i konkatenirame sus " ... "
            return substr(
                $this->getContent(),
                0,
                50
                ) . "...";

    }


    // DOBAVQME SI AVTOR KOITO SHTE E OT TIP User
    // I E MANY TO ONE ZASHTOTO MNOGO STATII MOGAT DA IMAT EDIN POTREBITEL
    // SLED KATO SME SETNALI I ARTICLES V User Entity-to mojem da si dovurshim inversedBy" I GO SETVAME NA articles

    /** @var  User
     *
     *@ORM\ManyToOne(targetEntity="SoftUniBlogBundle\Entity\User", inversedBy="articles")
     */
    private $author;


    // TUK SHTE SUZDADEM NA AVTORA GETERI I SETERI

    /**
     * @return User
     */
    public function getAuthor(): User
    {
        return $this->author;
    }

    /**
     * @param User $author
     * @return Article
     */
    public function setAuthor(User $author)
    {
        $this->author = $author;
        return $this;
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
}

