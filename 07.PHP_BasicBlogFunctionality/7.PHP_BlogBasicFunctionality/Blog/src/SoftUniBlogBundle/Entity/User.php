<?php

namespace SoftUniBlogBundle\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Security\Core\User\UserInterface;

/**
 * User
 *
 * @ORM\Table(name="users")
 * @ORM\Entity(repositoryClass="SoftUniBlogBundle\Repository\UserRepository")
 */
class User implements UserInterface
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
     * @ORM\Column(name="email", type="string", length=100, unique=true)
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="fullName", type="string", length=255)
     */
    private $fullName;

    /**
     * @var string
     *
     * @ORM\Column(name="password", type="string", length=255)
     */
    private $password;


// DOBAVQME NA USERA I STATII
    // TE SA OT TIP ArrayCollection KOETO E KLASCHE KATO LIST I NI DAVA MNOGO OPCII
    // KAZVAME CHE MOJE DA E ILI ARRAYCOLECTION ILI ARTICLE MASIV
    //SHTE IMAME METODITE I OT DVETE EDNOVREMENNO
    //Edin potrebitel moje da ima mnogo statii znchi e OneToMany
    // Targeta ni e Article i SUSHTOTAKA MAPVAME avtora

    /** @var  ArrayCollection|Article[]
     *
     * @ORM\OneToMany(targetEntity="SoftUniBlogBundle\Entity\Article", mappedBy="author")
     */
    private $articles;


    // PRAVIM SI KONSTRUKTOR V User.php I MU KAZVAME CHE PURVONACHALNITE
    //STATII SHTE SA PRAZNA KOLEKCIQ
    //TOVA E NUJNO ZASHTOTO AKO IZVLECHEM EDIN POTREBITEL KOITO SI NQMA STATII OT BAZAT,
    //SHTE NI DADE NULL I SHTE NI POKAJE EXCEPTION ZATOVA V KONSTRUKTORA MU DAVAME DEFAULTNA STOINOST

    public function __construct()
    {
        $this->articles = new ArrayCollection();
    }


    // TUK PRAVIM NA ARTIKULITE GETERI I SETERI:

    /**
     * @return ArrayCollection|Article[]
     */
    public function getArticles()
    {
        return $this->articles;
    }

    /**
     * @param ArrayCollection|Article[] $articles
     * @return User
     */
    public function setArticles($articles)
    {
        $this->articles = $articles;
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
     * Set email
     *
     * @param string $email
     *
     * @return User
     */
    public function setEmail($email)
    {
        $this->email = $email;

        return $this;
    }

    /**
     * Get email
     *
     * @return string
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * Set fullName
     *
     * @param string $fullName
     *
     * @return User
     */
    public function setFullName($fullName)
    {
        $this->fullName = $fullName;

        return $this;
    }

    /**
     * Get fullName
     *
     * @return string
     */
    public function getFullName()
    {
        return $this->fullName;
    }

    /**

     * Set password
     *
     * @param string $password
     *
     * @return User
     */
    public function setPassword($password)
    {
        $this->password = $password;

        return $this;
    }

    /**
     * Get password
     *
     * @return string
     */
    public function getPassword()
    {
        return $this->password;
    }

    /**
     * Returns the roles granted to the user.
     *
     * <code>
     * public function getRoles()
     * {
     *     return array('ROLE_USER');
     * }
     * </code>
     *
     * Alternatively, the roles might be stored on a ``roles`` property,
     * and populated in any number of different ways when the user object
     * is created.
     *
     * @return (Role|string)[] The user roles
     */
    public function getRoles()
    {
        return ['ROLE_USER'];
    }

    /**
     * Returns the salt that was originally used to encode the password.
     *
     * This can return null if the password was not encoded using a salt.
     *
     * @return string|null The salt
     */
    public function getSalt()
    {
        return null;
    }

    /**
     * Returns the username used to authenticate the user.
     *
     * @return string The username
     */
    public function getUsername()
    {
        return $this->email;
    }

    /**
     * Removes sensitive data from the user.
     *
     * This is important if, at any given point, sensitive information like
     * the plain-text password is stored on this object.
     */
    public function eraseCredentials()
    {
        // TODO: Implement eraseCredentials() method.
    }
	
	function __toString()
    {
        return $this->fullName;
    }
}

