package management_track;


public class Talk {
	private String title;
	private int duration;
	
	public Talk(String title, int duration) {
		this.title = title;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public int getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return  title + " " + duration + "minutos";
	}
	
}
