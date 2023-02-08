package org.example.service;

import org.example.model.Student;
import org.example.repo.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceImpl{

    @Autowired
    private StudentRepoImpl repo;

    @Override
    public void insertSingle(Student s1){
        repo.insertSingle(s1);
    }

    @Override
    public void insertMultiple(List<Student> studentList){
        for (int i=0;i<studentList.size();i++) {
            repo.insertSingle(studentList.get(i));
        }
    }

    @Override
    public Student selectSingle(int sid,int tid){
        return repo.selectSingle(sid,tid);
    }
    @Override
    public List<Student> selectMultiple(List<Integer> sids,List<Integer> tids){
        List<Student> studentList = new ArrayList<>();
        for (int i=0;i<sids.size();i++){
            if(tids.size()<i) {
                studentList.add(repo.selectSingle(sids.get(i), tids.get(tids.size())));
            }
            else {
                studentList.add(repo.selectSingle(sids.get(i), tids.get(i)));
            }
        }
        return studentList;
    }
    @Override
    public List<Student> selectAll(){
        return repo.selectAll();
    }
    @Override
    public Boolean deleteSingle(int sid,int tid){
        return repo.deleteSingle(sid,tid);
    }
    @Override
    public Boolean deleteMultiple(List<Integer> sids,List<Integer> tids){
        List<Boolean> resultList = new ArrayList<>();
        Boolean result =false;
        for (int i =0;i<sids.size();i++){
           resultList.add(repo.deleteSingle(sids.get(i),tids.get(i)));
        }
        for (int i=0;i<resultList.size();i++){
            if (resultList.get(i).equals(true)){
                result = true;
            }
        }
        return result;
    }

    @Override
    public Student updateSingle(Student s1){
        return repo.updateSingle(s1);
    }
    @Override
    public List<Student> updateMultiple(List<Student> studentList){
        List<Student> students = new ArrayList<>();
        for (int i=0;i< studentList.size();i++){
            students.add(repo.updateSingle(studentList.get(i)));
        }
        return students;
    }

    @Override
    public Boolean deleteAll(){
        return repo.deleteAll();
    }














}
