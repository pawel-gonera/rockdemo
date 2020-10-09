package org.rockexample.controllers;

import org.rockexample.form.DemoForm;
import org.rockexample.services.OutputMapper;
import org.rockexample.services.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {
    @Autowired
    Processor processor;

    @Autowired
    OutputMapper outputMapper;

    @GetMapping("/")
    public String index(Model model) {
        DemoForm form = new DemoForm();
        model.addAttribute("demoForm", form);
        model.addAttribute("categories", outputMapper.getCategories());
        return "index";
    }

    @PostMapping("/")
    public String results(@ModelAttribute DemoForm form, Model model) {
        model.addAttribute("demoForm", form);
        model.addAttribute("categories", outputMapper.getCategories());
        model.addAttribute("results",
                processor.processData(form.getInput(), form.getCategory()));
        return "index";
    }
}
