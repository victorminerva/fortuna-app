package com.minerva.fortuna.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaperPageController {

    @GetMapping("/paper")
    public String paper(Model model) {
        return "paper";
    }
}
