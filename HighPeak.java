package com.Assignment_Question;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Iterator;

public class HighPeak {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many job you want to enter:  ");
		int n=sc.nextInt();
		File inputFile=new File("C:\\Users\\CG-DTE\\Desktop\\Data\\inputFile.txt");
		try {
			//Reading input from the user and saving it into input file
			FileWriter writer =new FileWriter(inputFile);
			for(int i=0;i<n;i++) {
				
					System.out.println("Enter start time: ");
					String startTime=sc.next();
					writer.write(startTime+"\n");
					System.out.println("Enter end time: ");
					String endTime=sc.next();
					if(Integer.parseInt(startTime)>Integer.parseInt(endTime))
						throw new WrongTimingException("Start time is greater than end time");
					writer.write(endTime+"\n");
					System.out.println("Enter profit: ");
					String profit=sc.next();
					writer.write(profit+"\n");
			}
			writer.close();
			
			ArrayList<String> arr=new ArrayList<String>();
			//Reading the values from the input file and add to a ArrayList
			String line=null;
			BufferedReader reader=new BufferedReader(new FileReader(inputFile));
			while((line = reader.readLine())!=null) {
				arr.add(line);
			}
			
			//Iterate the arrayList
			//Getting the profits and saving to a profit ArrayList.
			ArrayList<Integer> profit = new ArrayList<Integer>();
			for(int i = 2; i <arr.size();i+=3) {
				profit.add(Integer.parseInt(arr.get(i)));
			}
			//Finding the maximum profit.
			 int maximum = profit.get(0);
		        for (int i = 1; i < profit.size(); i++) {
		            if (maximum < profit.get(i))
		                maximum = profit.get(i);
		        }
		        
		        profit.remove(profit.indexOf(maximum));
		        //For counting other employee profit
		        //Iterate the profit list
		        Iterator<Integer> itr=profit.iterator();
		        int sum=0;
		        int count=0;
		        while(itr.hasNext()) {
		        	sum=sum+itr.next();
		        	count++;
		        }
		        //Writting the output into the Output file.
		        FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\CG-DTE\\\\Desktop\\\\Data\\\\outputFile.txt");
			      
		        String s = count+"\n"+sum;
		        //Convert s to byte array because FileOutputStream write method will take byte or byte[] as argument.
		        byte[] b = s.getBytes();
		        fos.write(b);
		        System.out.println("Task: "+s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class WrongTimingException extends RuntimeException{
	public WrongTimingException(String s) {
		super(s);
	}
}