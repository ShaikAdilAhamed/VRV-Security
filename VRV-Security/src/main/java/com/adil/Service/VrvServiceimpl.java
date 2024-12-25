package com.adil.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class VrvServiceimpl implements VrvService{

	@Value("${Read.File.path}")
	private String fileData;

	
	public String readFile() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(fileData);
		Scanner sc = new Scanner(fis);
		String s = sc.nextLine();
		System.out.println(s);

		sc.close();
		return s;
	}
}
