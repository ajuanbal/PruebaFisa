package management_track;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Conference {
	private List<Session> morningSessions = new ArrayList<Session>();
	private List<Session> afternoonSessions = new ArrayList<Session>();
	private List<Session> networkingSessions = new ArrayList<Session>();
	
	public Conference(int numTracks) {
		for (int i=0; i<numTracks;i++) {
			morningSessions.add(new Session(LocalTime.of(9,0)));
			afternoonSessions.add(new Session(LocalTime.of(13,0)));
			networkingSessions.add(new Session(LocalTime.of(16,0)));
		}
	}
	
	public void scheduleTalks(List<Talk> talks) {
		//ordenar las charlas por duracion decendentemente 
		talks.sort(Comparator.comparingInt(Talk::getDuration).reversed());
		
		for(Talk talk :talks) {
			boolean scheduled = false;
			//agendar la charla en la mañana 
			for (Session session : morningSessions) {
				if(session.getTotalTime()+talk.getDuration()<= 180) {//3 horas
					session.addTalk(talk);
					scheduled = true;
					break;
				}
			}
			//Si la charla no estaba programada en la mañana, intenta en la tarde
			if(!scheduled) {
				for (Session session : afternoonSessions) {
                    if (session.getTotalTime() + talk.getDuration() <= 240) { // 4 hours total
                    	session.addTalk(talk);
                    	scheduled = true;
                    	break;
                    }
                   }
            }
			// Si la charla no estaba programada para la tarde, añádela a una sesión de networking
		   if (!scheduled) {
		       for (Session session : networkingSessions) {
		           if (session.getTotalTime() + talk.getDuration() <= 60) { // 1 hour total
		               session.addTalk(talk);
		               scheduled = true;
		               break;
		           }
		       }
		   }

		   // Si la charla no se pudo programar en absoluto, imprima un mensaje de error
		   if (!scheduled) {
		       System.out.println("ERROR: Could not schedule talk: " + talk);
		   }
		}
	}	
	public void printSchedule() {
		for (int i = 0; i < morningSessions.size(); i++) {
	        System.out.println("Track " + (i+1) + ":");

	        // Morning session
	        System.out.println("Morning Session:");
	        for (Talk talk : morningSessions.get(i).getTalks()) {
	            System.out.println(talk.toString());
	        }

	        // Lunch break
	        System.out.println("12:00PM Lunch");

	        // Afternoon session
	        System.out.println("Afternoon Session:");
	        for (Talk talk : afternoonSessions.get(i).getTalks()) {
	        	toString();
	            System.out.println(talk.toString());
	        }

	        // Networking session
	        System.out.println(networkingSessions.get(i).getStartTime().format(DateTimeFormatter.ofPattern("hh:mma")) + " Networking Event\n");
	    }
	}
}


