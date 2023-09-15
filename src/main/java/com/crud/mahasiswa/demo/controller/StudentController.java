package com.crud.mahasiswa.demo.controller;

/**
 * @author muhammad.khadafi
 */
import com.crud.mahasiswa.demo.model.Student;
import com.crud.mahasiswa.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", service.listAll());
        return "index";
    }

    @GetMapping("/new")
    public String showNewStudentPage(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.save(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentPage(@PathVariable(name = "id") Long id, Model model) {
        Student student = service.get(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

