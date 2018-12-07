package utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Setters {
	
	public static IPLData dataEntry(LinkedHashMap<String, String> lh) {
		
		IPLData ipD = new IPLData();
		for(Map.Entry<String, String> me:lh.entrySet()){
			switch(me.getKey()) {
			case "id":
				ipD.setId(me.getValue());
				break;
			case "season":
				ipD.setSeason(me.getValue());
				break;
			case "city":
				ipD.setCity(me.getValue());
				break;
			case "date":
				ipD.setDate(me.getValue());
				break;
			case "team1":
				ipD.setTeam1(me.getValue());
				break;
			case "team2":
				ipD.setTeam2(me.getValue());
				break;	
			case "toss_winner":
				ipD.setToss_winner(me.getValue());
				break;
			case "toss_decision":
				ipD.setToss_decision(me.getValue());
				break;
			case "result":
				ipD.setResult(me.getValue());
				break;
			case "dl_applied":
				ipD.setDl_applied(me.getValue());
				break;
			case "winner":
				ipD.setWinner(me.getValue());
				break;
			case "win_by_runs":
				ipD.setWin_by_runs(Integer.parseInt(me.getValue()));
				break;	
			case "win_by_wickets":
				ipD.setWin_by_wickets(me.getValue());
				break;
			case "player_of_match":
				ipD.setPlayer_of_match(me.getValue());
				break;
			case "venue":
				ipD.setVenue(me.getValue());
				break;
			case "umpire1":
				ipD.setUmpire1(me.getValue());
				break;
			case "umpire2":
				ipD.setUmpire2(me.getValue());
				break;
			case "umpire3":
				ipD.setUmpire3(me.getValue());
				break;	
			}
		}
		
		return ipD;
	}
	
	
	
public static String getGroup(LinkedHashMap<String, String> lh) {
		
		IPLData ipD = new IPLData();
		String s= "";
		for(Map.Entry<String, String> me:lh.entrySet()){
			switch(me.getKey()) {
			case "id":
				s = ipD.getId();
				break;
			case "season":
				s = ipD.getSeason();
				break;
			case "city":
				s = ipD.getCity();
				break;
			case "date":
				s = ipD.getDate();
				break;
			case "team1":
				s = ipD.getTeam1();
				break;
			case "team2":
				s = ipD.getTeam2();
				break;	
			case "toss_winner":
				s = ipD.getToss_winner();
				break;
			case "toss_decision":
				s = ipD.getToss_decision();
				break;
			case "result":
				s = ipD.getResult();
				break;
			case "dl_applied":
				s = ipD.getDl_applied();
				break;
			case "winner":
				s = ipD.getWinner();
				break;
			case "win_by_runs":
				s = Integer.toString(ipD.getWin_by_runs());
				break;	
			case "win_by_wickets":
				s = ipD.getWin_by_wickets();
				break;
			case "player_of_match":
				s = ipD.getPlayer_of_match();
				break;
			case "venue":
				s = ipD.getVenue();
				break;
			case "umpire1":
				s = ipD.getUmpire1();
				break;
			case "umpire2":
				s = ipD.getUmpire2();
				break;
			case "umpire3":
				s = ipD.getUmpire3();
				break;	
			}
		}
		
		return s;
		
	}
	
	
	

}

