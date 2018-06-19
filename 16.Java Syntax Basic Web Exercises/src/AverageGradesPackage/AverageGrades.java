package AverageGradesPackage;

import java.lang.reflect.Array;
import java.util.*;

import java.util.ArrayList;


class AverageGrades {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++)
        {
            String[] input = scanner.nextLine().split("\\s");
            String name = input[0];

            Double[] grades = Arrays.stream(input)
                    .skip(1)
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);

            Student student = new Student(){{
               setName(name);
               setGrades(Arrays.asList(grades));
            }};
            students.add(student);
        }

// Pravim si masiv sus filtrirani studenti i si go sortirame
        Student[] filteredStudents = students
                .stream()
                .filter(s -> s.getAverageGrade() >= 5.00)
                .sorted((a,b) -> {
                // tuk si pishme funkciqta za sortirane

                    //sortirame po imena
                    int comparison = a.getName().compareTo(b.getName());

                    if(comparison == 0)
                    { // ako sa ednakvi sortirame po averageGrade
                        comparison = b.getAverageGrade().compareTo(a.getAverageGrade());
                    }

                    // vrushtame resultata
                    return comparison;
                })
                .toArray(Student[]::new);

        for (Student fs : filteredStudents) {
            // taka sruvnqvame do vtoriq znak sled zapetaqta
            System.out.printf("%s -> %.2f%n", fs.getName(), fs.getAverageGrade());
        }

    }
}
