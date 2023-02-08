package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    @RequestMapping("/insertSingle")
    @ResponseBody
    void insertSingle(@RequestBody Student s1){
        service.insertSingle(s1);
    }

    @RequestMapping("/insertMultiple")
    @ResponseBody
    void insertMultiple(@RequestBody List<Student> studentList){
        service.insertMultiple(studentList);
    }

    @RequestMapping("/selectSingle")
    @ResponseBody
    Student selectSingle(@RequestParam int sid,@RequestParam int tid){
        return service.selectSingle(sid,tid);
    }
    @RequestMapping("/selectMultiple")
    @ResponseBody
    List<Student> selectMultiple(@RequestParam List<Integer> sids,@RequestParam List<Integer> tids){
        return service.selectMultiple(sids,tids);
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    List<Student> selectAll(){
        return service.selectAll();
    }
    @RequestMapping("/deleteSingle")
    @ResponseBody
    Boolean deleteSingle(@RequestParam int sid,@RequestParam int tid){
        return service.deleteSingle(sid, tid);
    }
    @RequestMapping("/deleteMultiple")
    @ResponseBody
    Boolean deleteMultiple(@RequestParam List<Integer> sids,@RequestParam List<Integer> tids){
        return service.deleteMultiple(sids, tids);
    }
    @RequestMapping("/updateSingle")
    @ResponseBody
    Student updateSingle(@RequestBody Student s1){
        return service.updateSingle(s1);
    }
    @RequestMapping("/updateMultiple")
    @ResponseBody
    List<Student> updateMultiple(@RequestBody List<Student> studentList){
        return service.updateMultiple(studentList);
    }
    @RequestMapping("/deleteAll")
    @ResponseBody
    Boolean deleteAll(){
        return service.deleteAll();
    }
}
