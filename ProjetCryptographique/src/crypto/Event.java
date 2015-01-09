package crypto;

import java.util.Date;

public class Event extends AbsEvent{

	protected String name;
	protected String description;
	protected Date date;
	protected Date fin;

	public Event() {
		this.name = "default event";
		this.description = "default event description";
		this.date = new Date(); // unix time, initialized at the time of
								// creation
		this.setFin(new Date());
	}

	public Event(String name, String description, Date date, Date fin) {
		this.name = name;
		this.description = description;
		this.date = date;
		this.setFin(fin);
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

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	/**
	 * Computes the length of the curent event
	 * @return the length in minutes
	 */
	public long getLength() {
		long lengthms = fin.getTime() - date.getTime();
		
		return lengthms/3600;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", description=" + description
				+ ", date=" + date.toString() + ", length :" + this.getLength() + " min ]\n";
	}

}
