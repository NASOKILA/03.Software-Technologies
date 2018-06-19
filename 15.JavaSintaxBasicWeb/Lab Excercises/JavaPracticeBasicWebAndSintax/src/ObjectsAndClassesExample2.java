
public class ObjectsAndClassesExample2 {
    public static void main(String[] args) {

        // Zaradi prazniq konstruktor mojem da imame prazna instanciq na tozi klas
        ObjectsAndClassesExample student = new ObjectsAndClassesExample();

        // i posle sus setterite mojem da si setvame stoinostite
        student.setName("Atanas");
        student.setGrade(5.50);
        student.setCredits(325);

        // S getterite mojem da dostupvame setnatite stoinosti na tozi student
        System.out.printf(" %s %s %s",student.getName(),student.getGrade(), student.getCredits());
    }
}
