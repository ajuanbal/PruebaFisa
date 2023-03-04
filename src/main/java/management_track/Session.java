package management_track;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Session {
	private LocalTime startTime;
	private Set<Talk> talks = new HashSet<Talk>();
	private int totalTime =0;
	
	public Session(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	public Set<Talk> getTalks(){
		return talks;
	}
	
	public int getTotalTime() {
		return totalTime;
	}
	
	public void addTalk(Talk talk) {
		talks.add(talk);
		totalTime += talk.getDuration();
	}
	
	@Override
	public String toString() {
		 String str = startTime.format(DateTimeFormatter.ofPattern("hh:mma"))+ "";
		 for (Talk talk: talks) {
			 str += talk +" \n";
		 }
		 return str;
	}
	
	
}
