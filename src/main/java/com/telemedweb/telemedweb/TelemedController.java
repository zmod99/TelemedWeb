package com.telemed.Telemed;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TelemedController {

    public TelemedController(){
        patientList.add(new Patient("fkjdslfds", "gfgf", new Date(54543L), "gfgf", "gfgf","gfgf" , "fwee"));
        patientList.add(new Patient("Karlo", "gfgf", new Date(54543L), "gfgf", "gfgf","gfgf" , "fwee"));
        patientList.add(new Patient("Damir", "gfgf", new Date(54543L), "gfgf", "gfgf","gfgf" , "fwee"));
    }

    List<Patient> patientList = new ArrayList<>();

    @GetMapping("/addPatient")
    public String addPatient(String fname, String lname, String phone, String email, String password, String mbo, Model model) {
        Patient newPatient = new Patient(fname, lname, new Date(), phone, email, password, mbo);
        patientList.add(newPatient);
        return "redirect:/listPatients";

    }
    @GetMapping("/listPatients")
    public String listPatients(Model model) {
        model.addAttribute(patientList);
        return "doctordashboard.html";

    }



}
