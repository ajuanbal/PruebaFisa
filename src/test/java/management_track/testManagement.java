package management_track;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testManagement {

	@Test
	public void testScheduleTalks1() {
	    List<Talk> talks = new ArrayList<>();		
	    talks.add(new Talk("Talk A", 57));
	    talks.add(new Talk("Talk B", 48));
	    talks.add(new Talk("Talk C", 32));
	    
	    Conference conference = new Conference(1);
	    conference.scheduleTalks(talks);
	}
	
	@Test
	public void testScheduleTalks2() {		
	    List<Talk> talks = new ArrayList<>();		
	    talks.add(new Talk("Talk A", 35));
	    talks.add(new Talk("Talk B", 25));
	    talks.add(new Talk("Talk C", 1));
	    
	    Conference conference = new Conference(1);
	    conference.scheduleTalks(talks);
	}
	@Test
	public void testScheduleTalks3() {
	    List<Talk> talks = new ArrayList<>();		
	    talks.add(new Talk("Talk A", 60));
	    talks.add(new Talk("Talk B", 30));
	    talks.add(new Talk("Talk C", 12));
	    
	    Conference conference = new Conference(1);
	    conference.scheduleTalks(talks);
	}
}
