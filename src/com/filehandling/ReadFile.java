package com.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	
	public static void main (String[] args)
	{
		File rdFile = new File("abc.txt");
		try {
			Scanner sc = new Scanner(rdFile);
			
			while(sc.hasNext())
			{
				System.out.println(sc.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
