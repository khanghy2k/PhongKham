package com.example.PhongKham.controller;
import com.example.PhongKham.model.DichVu;
import com.example.PhongKham.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;
import java.util.List;

@Controller
public class DichVuController {
    @Autowired
    private DichVuService dichVuService;


    @GetMapping("/dichvu")
    public String findAll(Model model) {
        List<DichVu> dichVuList = dichVuService.findAll();
        model.addAttribute("dichvu", dichVuList);
        System.out.println(dichVuList);
        return "home/DichVu";
    }
    @GetMapping("/AddDichVu")
    public String create(Model model) {
        model.addAttribute("dichvu", new DichVu());
        return "home/AddDichVu";
    }
    @PostMapping("/AddDichVu")
    public String create(@Valid @ModelAttribute("dichvu")DichVu dichVu, BindingResult bindingResult ,Model model) {
        model.addAttribute("dichvu", dichVu);
        if (bindingResult.hasErrors()){
            return "home/AddDichVu";
        }
        dichVuService.add(dichVu);
        return "redirect:/dichvu";
    }
    @GetMapping("/deleteDichVu/{id}")
    public String delete(@PathVariable("id") int id) {
        dichVuService.delete(id);
        return "redirect:/dichvu";
    }
    @GetMapping("/editDichVu/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        DichVu dichVu = dichVuService.findId(id);
        model.addAttribute("dichvu1", dichVu);
        return "home/editDichVu";
    }
    @PostMapping("/editDichVu")
    public String edit(@Valid @ModelAttribute("dichvu1") DichVu dichVu,BindingResult bindingResult,Model model){
        model.addAttribute("dichvu1", dichVu);
        if (bindingResult.hasErrors()) {
            return "home/editDichVu";
        }
        dichVuService.edit(dichVu);
        System.out.println(dichVu);
        return "redirect:/dichvu";
    }
}
