package org.example.repo;

import org.example.model.Student;

import java.util.List;

public interface StudentRepoImpl {
    void insertSingle(Student s1);
    Student selectSingle(int sid,int tid);
    List<Student> selectAll();
    Boolean deleteSingle(int sid,int tid);
    Student updateSingle(Student s1);
    Boolean deleteAll();
}
