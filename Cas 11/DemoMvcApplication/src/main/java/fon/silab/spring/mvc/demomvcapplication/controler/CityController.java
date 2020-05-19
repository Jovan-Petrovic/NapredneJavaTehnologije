/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.controler;

import fon.silab.spring.mvc.demomvcapplication.model.CityDto;
import fon.silab.spring.mvc.demomvcapplication.service.CityService;
import fon.silab.spring.mvc.demomvcapplication.validator.CityValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author KORISNIK
 */
@Controller
@RequestMapping(path = "/city")
public class CityController {

    private final CityService cityService;
    private final CityValidator cityValidator;

    @Autowired
    public CityController(CityService cityService, CityValidator cityValidator) {
        this.cityService = cityService;
        this.cityValidator = cityValidator;
    }

    @GetMapping
    public String home() {
        return "city/home";
    }

    @GetMapping(path = "add")
    public String add(HttpServletRequest request, HttpServletResponse response) {
        CityDto cityDto = new CityDto(0L, "/");
        request.setAttribute("cityDto", cityDto);
        return "city/add";
    }

    /*
    @PostMapping(path = "save")
    public String save(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        Long number = Long.parseLong(request.getParameter("number"));
        String name = request.getParameter("name").trim();
        
        System.out.println("Save city");
        System.out.println(number);
        System.out.println(name);
        
        CityDto cityDto = new CityDto(number, name);
        cityService.save(cityDto);
        redirectAttributes.addFlashAttribute("message", "City is saved");
        return "redirect:/city/add";       
    }
     */
 /*
    @PostMapping(path = "save")
    public String save(@RequestParam(name = "number") Long number, @RequestParam(name = "name") String name, RedirectAttributes redirectAttributes) {

        System.out.println("Save city");
        System.out.println(number);
        System.out.println(name);

        CityDto cityDto = new CityDto(number, name);
        cityService.save(cityDto);
        redirectAttributes.addFlashAttribute("message", "City is saved");
        return "redirect:/city/add";
    }
     */
    @PostMapping(path = "save")
    public String save(@ModelAttribute(name = "cityDto") @Validated CityDto cityDto, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        // public String save(CityDto cityDto, )
        System.out.println("Save city: " + cityDto);

        if (result.hasErrors()) {
            System.out.println("There was validation errors.");
            model.addAttribute("invalid", "One or more fields are invalid!");
            return "city/add";
        } else {
            System.out.println("There was no validation errors.");
            cityService.save(cityDto);

            redirectAttributes.addFlashAttribute("message", "City is saved");
            return "redirect:/city/add";
        }

    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(cityValidator);
    }
}
