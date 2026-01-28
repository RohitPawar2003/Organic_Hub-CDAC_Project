package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cdac.modelmvc.Category;
import com.cdac.services.CategoryServices;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/all")
    public List<Category> getAllCategory() {
        return categoryServices.getAllCategory();
    }
}
