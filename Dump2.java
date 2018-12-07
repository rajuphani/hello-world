package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Dump2 {

	public static void main(String[] args) {
		
		List<Integer> l1 = Arrays.asList(1,2,5);
		List<Integer> l2 = Arrays.asList(1,2,3);
		List<Integer> l3 = Arrays.asList(1,2,3,4);
		List<List<Integer>> main = new ArrayList<>();
		main.add(l1);
		main.add(l2);
		main.add(l3);
		
		List<String> op = new ArrayList<>();
		op.add("and");
		op.add("or");
		
		List<Integer> res = new ArrayList<>();
		res.addAll(main.get(0));
		for(int i=0;i<op.size();i++){
			
			List<Integer> temp2 = main.get(i+1);
			
			List<Integer> temp3 = new ArrayList<>();
			if(op.get(i).equals("and")){
				temp3.addAll(andList(res, temp2));
			}else if(op.get(i).equals("or")){
				temp3.addAll(orList(res, temp2));
			}
			
			res.removeAll(res);
			res.addAll(temp3);
			temp3.removeAll(temp3);
			
			
		}
		
		System.out.println(res);
	
		

	}
	
	
	public static List<Integer> whereParser(List<List<Integer>> lp,List<String> s){
		
		List<Integer> res = new ArrayList<>();
		res.addAll(lp.get(0));
		for(int i=0;i<s.size();i++){
			
			List<Integer> temp2 = lp.get(i+1);
			
			List<Integer> temp3 = new ArrayList<>();
			if(s.get(i).equals("and")){
				temp3.addAll(andList(res, temp2));
			}else if(s.get(i).equals("or")){
				temp3.addAll(orList(res, temp2));
			}
			
			res.removeAll(res);
			res.addAll(temp3);
			temp3.removeAll(temp3);
			
			
		}
		
	return res;
	
		
	}
	
	
	public static List<Integer> comp(List<Integer> l1,List<Integer> l2,String c){
		List<Integer> res = new ArrayList<>();
		if(c.equals("and")){
			res = andList(l1, l2);
		}else if(c.equals("or")){
			res = orList(l1, l2);
		}
		
		return res;
		

	}
	
	public static List<Integer> andList(List<Integer> l1,List<Integer> l2){
		List<Integer> res = new ArrayList<>(l1);
		res.retainAll(l2);
		
		return res;
		
	}
	
	public static List<Integer> orList(List<Integer> l1,List<Integer> l2){
		List<Integer> l3 = new ArrayList<>(l1);
		l3.addAll(l2);
		List<Integer> res = new ArrayList<>(new HashSet<>(l3));
		
		return res;
		
	}

}
