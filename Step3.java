package step3;

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

public class Step3 {


/*In step 2, you split a query and created a bunch of classes to hold the parts of the query, along with the needed methods to access these properties. Now let us start working with data.

In this step, we will extend the previous assignment step and identify the header as well as datatype of each field and display the output in console.

Now, why would this be difficult? Well two reasons - the header row only contains names of the fields, not the data types. in fact the only way you can figure the data type of a column is to read a row (the first row works) and then each column in that row and then determine the data type. So some interesting code to do.*/
	
	public static void main(String[] args) {
		String csvFile = "test1.csv";
		//mapping all lines of CSV file to an array list
		List<String> ar1 = csvFunctions.csvReader(csvFile);
		String header = ar1.get(0);
		String base = ar1.get(1);
		LinkedHashMap<String, String> mp = csvFunctions.getMapperBaseClass(header, base);
		for(Map.Entry<String, String> entry : mp.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	
	
	
	

}
