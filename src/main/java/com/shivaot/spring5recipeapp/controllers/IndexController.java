package com.shivaot.spring5recipeapp.controllers;

import com.shivaot.spring5recipeapp.domain.Category;
import com.shivaot.spring5recipeapp.domain.UnitOfMeasure;
import com.shivaot.spring5recipeapp.repositories.CategoryRepository;
import com.shivaot.spring5recipeapp.repositories.UnitOfMeasureRepository;
import com.shivaot.spring5recipeapp.services.RecipeService;
import com.shivaot.spring5recipeapp.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Slf4j
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting index page");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
