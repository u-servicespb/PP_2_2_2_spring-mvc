package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;

import java.util.Optional;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String showCars(@RequestParam(required = false, value = "count") Optional<Integer> count, Model model) {
        model.addAttribute("cars", carService.getCars(count.orElse(0)));
        return "cars";
    }
}