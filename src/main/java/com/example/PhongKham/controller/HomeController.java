    package com.example.PhongKham.controller;
    import com.example.PhongKham.model.BenhNhan;
    import com.example.PhongKham.service.BenhnhanService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import java.util.List;


    @Controller
    @RequestMapping("/home")
    public class HomeController {
        @Autowired
        private BenhnhanService benhnhanService;

        @GetMapping("/home")
        public String home(Model model) {
            List<BenhNhan> benhNhanList = benhnhanService.findAll();
            model.addAttribute("benhNhan", benhNhanList);
            return "home/home";
        }
       @GetMapping("/AddBenhNhan")
        public String create(Model model){
            model.addAttribute("BenhNhan",new BenhNhan());
            return "home/AddBenhNhan";
       }
       @PostMapping("/AddBenhNhan")
        public String create(BenhNhan benhNhan,Model model){
            benhnhanService.add(benhNhan);
            return "redirect:/home/home";
       }
    }



