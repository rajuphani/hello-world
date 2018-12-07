package step2;

import java.util.ArrayList;
import java.util.List;

import utils.StringFunctions;

public class QueryParser {
	
public static String queryString1 = "select team1, sum(win_by_runs) from ipl.csv where season > 2016 and city = 'Bangalore'";
	
	public QueryParameter parseQuery(String queryString){
		//Creating Query parameter object
		QueryParameter qp = new QueryParameter();
		//Creating an array list to store Restrictions
		List<String> ar1 = new ArrayList<String>();
		//Creating an array list of Restrictions
		List<Restriction> rest1 = new ArrayList<Restriction>();
		
		ar1.addAll(StringFunctions.getRestrictionsList(queryString));
		for(String s:ar1){
			Restriction r = new Restriction();
			r = StringFunctions.splitRestrictionString(s);
			rest1.add(r);
			
		}
		
		
		
		
		qp.setQueryString(queryString);
		qp.setFile(StringFunctions.getFileName(queryString));
		qp.setBaseQuery(StringFunctions.getBasePart(queryString));
		qp.setLogicalOperators(StringFunctions.getLogicalOperators(queryString));
		qp.setGroup_by_field(StringFunctions.getGroupByFields(queryString));
		qp.setFields(StringFunctions.getSelectedFields(queryString));
		qp.setRestrictions(rest1);
		qp.setOrder_by_field(StringFunctions.getOrderByFields(queryString));
		
		
		
		
		
		
		return qp;
	}
	
	public static void main(String[] args){
		
		QueryParser qps = new QueryParser();
		
		System.out.println(qps.parseQuery(queryString1).toString());
	}
	

}
