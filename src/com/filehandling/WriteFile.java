package com.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteFile {
	
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		File output = new File ("xyz.txt");
		String name;
		name  = sc.nextLine();
		try {
			PrintWriter out = new PrintWriter(output);
			while(!name.equalsIgnoreCase("done"))
			{
				
				out.println(name);
				name  = sc.nextLine();
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
}
