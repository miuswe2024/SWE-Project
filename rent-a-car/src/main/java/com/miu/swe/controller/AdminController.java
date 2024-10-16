package com.miu.swe.controller;

import com.miu.swe.entity.Car;
import com.miu.swe.entity.Customer;
import com.miu.swe.entity.Station;
import com.miu.swe.service.ICarService;
import com.miu.swe.service.ICustomerService;
import com.miu.swe.service.IRentalService;
import com.miu.swe.service.IStationService;
import com.miu.swe.bean.MessagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private MessagesBean messages;
    @Autowired
    private ICarService carService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IRentalService rentalService;
    @Autowired
    private IStationService stationService;

    @GetMapping("/add-new-car")
    public String showCreateCarForm(Model model, @ModelAttribute("car") Car car) {
        List<Station> stations = stationService.findAll();
        model.addAttribute("stations", stations);
        return "fragments/add-new-car";
    }


    @PostMapping("/add-new-car/process")
    public ModelAndView processCreateCarForm(@Valid @ModelAttribute("car") Car car,
                                             BindingResult bindingResult) {

        ModelAndView createForm = new ModelAndView("Add-New-Car");
        List<Station> stations = stationService.findAll();
        createForm.addObject("stations", stations);
        if (bindingResult.hasErrors()) return createForm;
        carService.create(car);

        return new ModelAndView("redirect:/admin/all-cars")
                .addObject("success", messages.get("createCarSuccess"));
    }

    @GetMapping("/all-cars")
    public String showAllCarsForm(Model model, @ModelAttribute("error") String error,
                                  @ModelAttribute("success") String success) {
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("error", error);
        model.addAttribute("success", success);
        return "fragments/all-cars";
    }

    @GetMapping("/delete-car/{id}")
    public ModelAndView showDeleteCarForm(@PathVariable("id") String id) {

        try {
            carService.deleteById(id);
        } catch (Exception e) {
            return new ModelAndView("redirect:/admin/all-cars")
                    .addObject("error", messages.get("carDeleteError"));
        }

        return new ModelAndView("redirect:/admin/all-cars")
                .addObject("success", messages.get("deleteCarSuccess"));
    }


    @GetMapping("/add-new-customer")
    public String showCreateCustomerForm(Model model, @ModelAttribute("customer") Customer customer) {
        return "fragments/add-new-customer";
    }


    @PostMapping("/add-new-customer/process")
    public ModelAndView processCreateCustomerForm(@Valid @ModelAttribute("customer") Customer customer,
                                                  BindingResult bindingResult) {

        ModelAndView createForm = new ModelAndView("add-new-customer");
        if (bindingResult.hasErrors()) return createForm;
        customerService.create(customer);

        return new ModelAndView("redirect:/admin/all-customers")
                .addObject("success", messages.get("createCustomerSuccess"));
    }

    @GetMapping("/all-customers")
    public String showAllCustomerForm(Model model, @ModelAttribute("error") String error, @ModelAttribute("success") String success) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("error", error);
        model.addAttribute("success", success);
        return "fragments/all-customers";
    }


    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteCustomerForm(@PathVariable("id") Integer id) {

        try {
            customerService.deleteById(id);
        }catch (Exception ex){
            return new ModelAndView("redirect:/admin/all-customers")
                    .addObject("error", messages.get("customerDeleteError"));
        }

        return new ModelAndView("redirect:/admin/all-customers")
                .addObject("success", messages.get("deleteCustomerSuccess"));
    }

    @GetMapping("/all-rentals")
    public String showAllRentalsForm(Model model, @ModelAttribute("error") String error,
                                     @ModelAttribute("success") String success) {
        model.addAttribute("rentals", rentalService.findAllRentals());
        model.addAttribute("error", error);
        model.addAttribute("success", success);
        return "fragments/all-rentals";
    }

    @GetMapping("/delete-rental/{id}")
    public ModelAndView showDeleteRentalForm(@PathVariable("id") Integer id) {

        try {
            rentalService.deleteById(id);
        }catch (Exception ex){
            return new ModelAndView("redirect:/admin/all-rentals")
                    .addObject("error", messages.get("rentalDeleteError"));
        }

        return new ModelAndView("redirect:/admin/all-rentals")
                .addObject("success", messages.get("deleteRentalSuccess"));
    }


}
