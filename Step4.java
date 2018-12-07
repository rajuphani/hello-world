package step4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import utils.csvFunctions;

public class Step4 {



	
	public static void main(String[] args) {
		String csvFile = "test1.csv";
		//mapping all lines of CSV file to an array list
		List<String> ar1 = csvFunctions.csvReader(csvFile);
		String header = ar1.get(0);
		String base = ar1.get(1);
		LinkedHashMap<String, String> mp = csvFunctions.getMapperBaseClass2(header, base);
		for(Map.Entry<String, String> entry : mp.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	
	
	
	

}
