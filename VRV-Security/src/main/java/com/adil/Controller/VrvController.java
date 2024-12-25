package com.adil.Controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adil.Service.VrvService;

@RestController
@RequestMapping("/VRV")
public class VrvController {

	@Autowired
	private VrvService vrvService;
	
	@GetMapping("/read-file")
	public String readFile() {
		
		
		try {
			System.out.println(vrvService.readFile());
			return vrvService.readFile();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
			 return "Error: Unable to read the file!";
		}
		
	}
	
}
