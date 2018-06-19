
public class ObjectsAndClassesExample {

    // S private nie pravim taka che tezi neshta da ne mogat da se vidqt otvun tozi clas !

    // V Java klasovete nqma properties kato v C# {get; set;} TUK TRQBVA DA SI PISHEM METODI !
    private String name;
    private double grade;
    private int credits;

// WE HAVE AN EMPTY CONSTRUCTOR
    public ObjectsAndClassesExample() {
    }

// WE HAVE A CONSTRUCTOR WITH EVERYTHING, kogato izvikvame new() relno izvikvame konstruktura
    //konstruktura suzdava instanciq ot obekt
    public ObjectsAndClassesExample(String name, double grade, int credits) {
        this.name = name;
        this.grade = grade;
        this.credits = credits;
    }

    // get metoda vrushta dadena stoinost
    public String getName()
    {
        return this.name;
    }

    // set metoda e OT TIP VOID, priema kato stoinost promenlivata koqto iskame da setnem !
    // I prosto q setvame, NE VRUSHTAME NISHTO
    public void setName(String name)
    {
        this.name = name;
    }


    public double getGrade()
    {
        return this.grade;
    }

    public void setGrade(double grade)
    {
        this.grade = grade;
    }

    public int getCredits()
    {
        return this.credits;
    }

    public void setCredits(int credits)
    {
        this.credits = credits;
    }

    // CHREZ Dqsno kopche, Generate mojem da si generirame avtomatichno konstrukturi, get i set metodi !

}
