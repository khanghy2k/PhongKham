package com.example.PhongKham.controller;
import com.example.PhongKham.model.BenhNhan;
import com.example.PhongKham.model.LichHen;
import com.example.PhongKham.model.PhienKham;
import com.example.PhongKham.model.Thuoc;
import com.example.PhongKham.service.BenhnhanService;
import com.example.PhongKham.service.DonThuocService;
import com.example.PhongKham.service.LichHenService;
import com.example.PhongKham.service.PhienKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CrudKhController {
    @Autowired
    private BenhnhanService benhnhanService;

    @Autowired
    private LichHenService lichHenService;

    @Autowired
    private PhienKhamService phienKhamService;

    @Autowired
    private DonThuocService donThuocService;


    @GetMapping("/AddBenhNhan")
    public String create(Model model) {
        model.addAttribute("BenhNhan", new BenhNhan());
        return "home/AddBenhNhan";
    }

    @PostMapping("/AddBenhNhan")
    public String create(@Valid @ModelAttribute("BenhNhan")BenhNhan benhNhan, BindingResult bindingResult, Model model) {
        model.addAttribute("BenhNhan", benhNhan);
        if (bindingResult.hasErrors()) {
            return "home/AddBenhNhan";
        }
        benhnhanService.add(benhNhan);
        return "redirect:/home/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        benhnhanService.delete(id);
        return "redirect:/home/home";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        BenhNhan benhNhan = benhnhanService.findId(id);
        model.addAttribute("benhNhan", benhNhan);
        return "home/edit";
    }


    @PostMapping("/edit")
    public String edit(@ModelAttribute("benhNhan")BenhNhan benhNhan, BindingResult bindingResult,Model model) {
        model.addAttribute("benhNhan", benhNhan);
        if (bindingResult.hasErrors()) {
            return "home/edit";
        }
        benhnhanService.edit(benhNhan);
        System.out.println(benhNhan);
        return "redirect:/home/home";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name")String name, Model model) {
        List<BenhNhan> benhNhan;
        if (name != null && !name.trim().isEmpty()) {
            benhNhan = benhnhanService.findName(name);
        } else {
            benhNhan = benhnhanService.findAll();
        }
        if (benhNhan.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy");
        }
        model.addAttribute("benhNhan", benhNhan);
        return "home/home";
    }

    @GetMapping("/phienkham/{id}")
    public String phienkham(@PathVariable("id") int id, Model model) {
        BenhNhan benhNhan = benhnhanService.findId(id);
        model.addAttribute("benhNhan", benhNhan);
        System.out.println("Ma Benh Nhan: " + benhNhan.getMaBenhnhan());
        Thuoc thuoc = new Thuoc();
        model.addAttribute("thuoc", thuoc);
        PhienKham phienKham = new PhienKham();
        phienKham.setMaBenhNhan(id);
        model.addAttribute("phienKham", phienKham);
        return "home/phienkham";
    }
    @PostMapping("/phienkham")
    public String phienkham(@Valid @ModelAttribute("phienKham")PhienKham phienKham, BindingResult bindingResult, Model model) {
        model.addAttribute("phienKham", phienKham);
        if (bindingResult.hasErrors()) {
            return "home/phienkham";
        }
        phienKhamService.add(phienKham);
        System.out.println("Ma Benh Nhan: " + phienKham.getMaBenhNhan());
        return "redirect:/home/home";
    }


    @GetMapping("/lichhen/{id}")
    public String lichhen(@PathVariable("id") int id, Model model) {
        BenhNhan benhNhan = benhnhanService.findId(id);
        model.addAttribute("benhNhan", benhNhan);
        System.out.println("Ma Benh Nhan: " + benhNhan.getMaBenhnhan());

        LichHen lichHen = new LichHen();
        lichHen.setMaBenhNhan(id);
        System.out.println("Lich hen" + lichHen.getThoiGian());
        model.addAttribute("lichHen", lichHen);
        return "home/lichhen";
    }

    @PostMapping("/lichhen")
    public String lichhen(@ModelAttribute("lichHen")LichHen lichHen, BindingResult bindingResult, Model model) {
        model.addAttribute("lichHen", lichHen);
        if (bindingResult.hasErrors()) {
            return "home/lichhen";
        }
        lichHenService.add(lichHen);
        System.out.println("Ma Benh Nhan: " + lichHen.getMaBenhNhan());
        return "redirect:/home/home";
    }

    @GetMapping("/deleteLichHen/{id}")
    public String deleteLichHen(@PathVariable("id") int id) {
       lichHenService.delete(id);
        return "redirect:/home/home";
    }

    @GetMapping("/editLichHen/{id}")
    public String editLichHen(@PathVariable("id") int id, Model model) {
        LichHen lichHen = lichHenService.findId(id);
        model.addAttribute("lichHen1", lichHen);
        return "home/editLichHen";
    }
    @PostMapping("/editLichHen")
    public String editLichHen(@Valid @ModelAttribute("lichHen1")LichHen lichHen, BindingResult bindingResult,Model model) {
        model.addAttribute("lichHen1", lichHen);
        if (bindingResult.hasErrors()) {
            return "home/editLichHen";
        }
        lichHenService.edit(lichHen);
        System.out.println(lichHen);
        return "redirect:/home/home";
    }


}

