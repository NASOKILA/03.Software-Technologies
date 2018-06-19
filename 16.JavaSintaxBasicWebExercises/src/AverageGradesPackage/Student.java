package AverageGradesPackage;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Double> Grades;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return Grades;
    }

    public void setGrades(List<Double> grades) {
        Grades = grades;
    }

    public Double getAverageGrade() {

        Double AverageGrade = this.Grades
                .stream()
                .mapToDouble(a -> a)
                .average()
                .getAsDouble();

        return AverageGrade;
    }


}
