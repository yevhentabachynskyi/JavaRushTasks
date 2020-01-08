package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University  {
    protected int age;
    protected String name;
    private List<Student> students = new ArrayList<>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
     /*   double sum = 0;
        Student student = null;
        *//*for (int i = 0; i < students.size()-1; i++)
            sum = students.get(i).getAverageGrade() + students.get(i+1).getAverageGrade();*//*
        for (Student st: students){
            sum = sum + st.getAverageGrade();
        }
        for (Student s: students){
            averageGrade = sum/students.size();
            if (s.getAverageGrade() == averageGrade)
        student = s;
        }
        return student;*/
        return students.stream().filter(x -> averageGrade == x.getAverageGrade()).findFirst().get();


    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
       /* Student student = null;
        for (int i = 0; i < students.size()-1; i++){
          if (students.get(i).getAverageGrade() > students.get(i+1).getAverageGrade()){
               student = students.get(i);
            }
        }*/
        return students.stream().max((x,y) -> Double.compare(x.getAverageGrade(),y.getAverageGrade())).get();
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
     /*   Student student = null;
        for (int i = 0; i < students.size()-1; i++){
            if (students.get(i).getAverageGrade() < students.get(i+1).getAverageGrade()){
                student = students.get(i);
            }
        }*/
        return students.stream().min((x,y) -> Double.compare(x.getAverageGrade(),y.getAverageGrade())).get();
    }
    public void expel(Student student){
        students.remove(student);
    }
}