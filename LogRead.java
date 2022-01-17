package testcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 String drivepath="C:\\Users\\Avijit Mitra\\Downloads\\Assignment2\\start_assignment.log";
		String desire_string=logreader(drivepath);
		System.out.println(desire_string);
	}
	

	private static String logreader(String drivepath) throws IOException {
		
		// To Read and Fetch the file
		FileReader fr = new FileReader(drivepath);
		BufferedReader br = new BufferedReader(fr);
		String Content = "";
		String searchstr = "beginning of assignment";
		String reqPattern="required_pattern_";
		String patternSearch = "";
		Boolean flag = false;
		
//Searching for the "beginning of assignment" in start_assignment.log file line by line
		
		while ((Content = br.readLine()) != null) {
			if (Content.contains(searchstr)) {
				//System.out.println("beginning of assignment : Found");
				flag = true;
			}
			
/*Searching for the first occurrence of "required_pattern_" in start_assignment.log
  file line by line after "beginning of assignment" has already found */
			
			if (flag == true && Content.contains(reqPattern)) {
				
				//System.out.println("Pattren : Found");
				patternSearch = Content;
				break;
			}
			
		}
		
//Close the log file
		br.close();
		
		// To get the exact pattern 
		
		int len=Content.length();//71
		reqPattern=Content.substring(len-reqPattern.length()-2,len);
		
//Searching for the string "assignment_completed" in "Logs\required_pattern_*" file line by line
		
		FileReader fr_pattern = new FileReader("C:\\Users\\Avijit Mitra\\Downloads\\Assignment2\\Logs\\"+reqPattern);
		BufferedReader br_pattern = new BufferedReader(fr_pattern);
		String desireStr="assignment_completed";
		Content = "";
		while((Content=br_pattern.readLine())!=null) {
			if(Content.contains(desireStr)) {
				Content=br_pattern.readLine();
				break;
			}
		}
		br_pattern.close();
		
//Returning the expected output as String
		return Content;
		
		
	}

}
