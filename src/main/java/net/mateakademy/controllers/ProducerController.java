package net.mateakademy.controllers;

import net.mateakademy.dto.Producer;
import lombok.AllArgsConstructor;
import net.mateakademy.service.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@AllArgsConstructor
public class ProducerController {
    @Autowired
    private  ProducerServiceImpl service;

    @GetMapping("/admin/producers")
    public ModelAndView getAllProducers(){
        ModelAndView modelAndView = new ModelAndView("producer_list_Admin");
        modelAndView.addObject("producers", service.getAllProducers());
        return modelAndView;
    }

    @GetMapping("/admin/producer-form")
    public ModelAndView producerForm(){
        Producer producer = new Producer();
        ModelAndView modelAndView = new ModelAndView("producer_form_Admin");
        modelAndView.addObject("producer", producer);
        return modelAndView;
    }

    @PostMapping("/admin/save-producer")
    public RedirectView saveProducer(@ModelAttribute("producer") Producer producer){
        service.createProducer(producer);
        return new RedirectView("/admin/producers");
    }

    @GetMapping("/admin/edit-producer/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_producer_Admin");
        Producer producer = service.getProducerById(id);
        modelAndView.addObject("producer", producer);

        return modelAndView;
    }

    @GetMapping("/admin/delete-producer/{id}")
    public RedirectView deleteProducer(@PathVariable(name = "id") Long id){
        service.deleteProducerById(id);
        return new RedirectView("/admin/producers");
    }

    @GetMapping("user/producers")
    public ModelAndView getAllProducersForUser(){
        ModelAndView modelAndView = new ModelAndView("producer_list_User");
        modelAndView.addObject("producers", service.getAllProducers());
        return modelAndView;
    }
}
