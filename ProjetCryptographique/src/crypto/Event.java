package crypto;

import java.util.Date;

public class Event extends AbsEvent{

	protected String name;
	protected String description;
	protected Date date;

	public Event() {
		this.name = "default event";
		this.description = "default event description";
		this.date = new Date(); // unix time, initialized at the time of
								// creation
	}

	public Event(String name, String description, Date date) {
		this.name = name;
		this.description = description;
		this.date = date;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", description=" + description
				+ ", date=" + date.toString() + "]\n";
	}
}
