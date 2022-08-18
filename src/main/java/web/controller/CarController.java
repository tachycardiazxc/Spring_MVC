package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.services.CarServiceImp;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarServiceImp carServiceImp;

    @Autowired
    public CarController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping("")
    public String getCars(@RequestParam(value = "count", required = false) String count,
                          Model model) {
        if (count == null || Integer.parseInt(count) >= 5) {
            List<Car> cars = carServiceImp.getCars(5);
            model.addAttribute("cars", cars);
            cars.forEach(System.out::println);
            return "car_controller/car";
        }
        List<Car> cars = carServiceImp.getCars(Integer.parseInt(count));
        model.addAttribute("cars", cars);
        cars.forEach(System.out::println);
        return "car_controller/car";
    }

}
