package com.adil.Controller;

import com.adil.Service.VrvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VrvController {

    @Autowired
    private VrvService vrvService;

    @GetMapping("/VRV/read-file")
    public String readFile() {
        try {
            return vrvService.readFile();  // Call the service method
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();  // Return error message
        }
    }
}
