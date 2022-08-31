package com.revitalize.admincontrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String homeApp(Model model){
    model.addAttribute("Mensagem", "Mensagem realizada para testar o Model");
    return "index";
  }
}
