    package com.example.PhongKham.controller;
    import com.example.PhongKham.model.BenhNhan;
    import com.example.PhongKham.model.LichHen;
    import com.example.PhongKham.model.PhienKham;
    import com.example.PhongKham.service.BenhnhanService;
    import com.example.PhongKham.service.LichHenService;
    import com.example.PhongKham.service.PhienKhamService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;


    @Controller
    @RequestMapping("/home")
    public class HomeController {
        @Autowired
        private BenhnhanService benhnhanService;

        @Autowired
        private LichHenService lichHenService;

        @Autowired
        private PhienKhamService phienKhamService;

        @GetMapping("/home")
        public String home(Model model) {
            List<BenhNhan> benhNhanList = benhnhanService.findAll();
            model.addAttribute("benhNhan", benhNhanList);
            List<LichHen> lichhenList = lichHenService.findAll();

            model.addAttribute("lichhen", lichhenList);
            List<PhienKham> phienKhamList = phienKhamService.findAll();
            model.addAttribute("phienkham", phienKhamList);
            return "home/home";
        }
//        @GetMapping("/home")
//        public List<BenhNhan> getBenhNhanList(
//                @RequestParam(name = "limit", defaultValue = "10") int limit,
//                @RequestParam(name = "offset", defaultValue = "0") int offset) {
//            return benhnhanService.pageBenhNhan(limit, offset);
//        }
    }



