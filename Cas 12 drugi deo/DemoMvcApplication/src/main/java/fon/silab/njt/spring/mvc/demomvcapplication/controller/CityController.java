package fon.silab.njt.spring.mvc.demomvcapplication.controller;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CityDto;
import fon.silab.njt.spring.mvc.demomvcapplication.dto.CountryDto;
import fon.silab.njt.spring.mvc.demomvcapplication.service.CityService;
import fon.silab.njt.spring.mvc.demomvcapplication.service.CountryService;
import fon.silab.njt.spring.mvc.demomvcapplication.validator.CityValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/city")
public class CityController {

    private final CountryService countryService;
    private final CityService cityService;
    private final CityValidator cityValidator;

    @Autowired
    CityController(CityService cityService, CityValidator cityValidator, CountryService countryService) {
        this.countryService = countryService;
        this.cityService = cityService;
        this.cityValidator = cityValidator;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(cityValidator);
    }

    @GetMapping
    public String home() {
        System.out.println("====================================================================");
        System.out.println("====================   CityController: home()    ===================");
        System.out.println("====================================================================");
        return "city/home";
    }

    @GetMapping(value = "add")
    public ModelAndView add() {
        System.out.println("====================================================================");
        System.out.println("====================   CityController: add()     ===================");
        System.out.println("====================================================================");

        ModelAndView modelAndView = new ModelAndView("city/add");
        return modelAndView;
    }

    @GetMapping(value = "all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("city/all");
        modelAndView.addObject("message", "All cities!");
        return modelAndView;
    }

    @GetMapping(value = "/{numberId}/view")
    public ModelAndView view(@PathVariable(name = "numberId") Long numberId) {
        ModelAndView modelAndView = new ModelAndView("city/view");
        modelAndView.addObject("message", "City " + numberId + "!");
        modelAndView.addObject("cityDto", cityService.findByNumber(numberId));
        return modelAndView;
    }

    @GetMapping(value = "/{numberId}/delete")
    public ModelAndView delete(@PathVariable(name = "numberId") Long numberId) {
        System.out.println("Delete..." + numberId);
        cityService.delete(numberId);
        ModelAndView modelAndView = new ModelAndView("city/all");
        modelAndView.addObject("message", "City " + numberId + " is deleted!");
        return modelAndView;
    }

    @PostMapping(value = "save")
    public String save(@ModelAttribute(name = "cityDto") @Validated CityDto cityDto, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   CityController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        System.out.println(cityDto);
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            model.addAttribute("invalid", "One or more fields are invalid");
            model.addAttribute("cityDto", cityDto);
            return "city/add";
        } else {
            cityService.save(cityDto);
            redirectAttributes.addFlashAttribute("message", "City is saved");
            return "redirect:/city/add";
        }
    }

    @ModelAttribute(name = "cities")
    private List<CityDto> getCities() {
        return cityService.getAll();
    }

    @ModelAttribute(name = "cityDto")
    private CityDto getCityDto() {
        return new CityDto(0L, "/");
    }

    @ModelAttribute(name = "countries")
    private List<CountryDto> getCountries() {
        return countryService.getAll();
    }
    
    @ExceptionHandler(NullPointerException.class)
	public String exceptionHandler(NullPointerException nullPointerException,RedirectAttributes redirectAttributes) {
		
		System.out.println("====================================================================");
		System.out.println("@ControllerAdvice exception ocured: NullPointerException===========");
		System.out.println("====================================================================");
		
		redirectAttributes.addFlashAttribute("errorMessage", nullPointerException.getMessage());
		redirectAttributes.addFlashAttribute("errorObj", nullPointerException);
		
		return "redirect:/error/globalException";
	}
}
