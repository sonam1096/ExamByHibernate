package com.neebal.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected String name;

    @Column(nullable = false,length = 1)
    protected Character gender;



    @Column(nullable = true)
    private Integer rollno;


    @OneToMany(mappedBy = "student")
    private  Set<StudentsExams> studentsExamsSet;

    public Student() {
    }

    public Student(String name, Character gender,Integer rollno) {
         this.name=name;
         this.gender=gender;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Set<StudentsExams> getStudentsExamsSet() {
        return studentsExamsSet;
    }

    public void setStudentsExamsSet(Set<StudentsExams> studentsExamsSet) {
        this.studentsExamsSet = studentsExamsSet;
    }


    @Override
    public String toString() {
        return "Student{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", rollno=" + rollno +
                '}';
    }
}
