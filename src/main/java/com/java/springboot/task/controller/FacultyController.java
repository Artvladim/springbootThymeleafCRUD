package com.java.springboot.task.controller;

import javax.validation.Valid;

import com.java.springboot.task.entity.Faculty;
import com.java.springboot.task.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faculties/")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        model.addAttribute("faculties", facultyService.list());
        return "faculties";
    }

    @PostMapping("add")
    public String addFaculty(@Valid Faculty faculty, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("faculty", faculty);
            model.addAttribute("faculties", facultyService.list());
            return "faculties";
        } else {
            if (facultyService.findByName(faculty.getName()).isEmpty()) {
                facultyService.create(faculty);
            } else {
                String msg = String.format("Faculty with name %s already exists", faculty.getName());
                result.addError(new FieldError("faculty", "name", faculty.getName(), false, null, null, msg));
                model.addAttribute("faculty", faculty);
                model.addAttribute("faculties", facultyService.list());
                return "faculties";
            }
        }


        return "redirect:/faculties/list";
    }

    @GetMapping("delete/{id}")
    public String deleteFaculty(@PathVariable("id") Long id, Model model) {
        facultyService.delete(id);
        model.addAttribute("faculties", facultyService.list());
        return "redirect:/faculties/list";
    }
}
