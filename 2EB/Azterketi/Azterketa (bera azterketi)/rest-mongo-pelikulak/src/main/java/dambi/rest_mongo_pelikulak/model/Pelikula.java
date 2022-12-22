package dambi.rest_mongo_pelikulak.model;

import java.util.List;

import org.bson.types.ObjectId;

public class Pelikula {
	
	private ObjectId id; //Berdin ei da id zein _id jarri  (Eta eremu hau ez erabiltzea be aukera bat da)
	private String title;
	private String year;
	private List<String> director;
	private List<String> cast;

	
	
	public ObjectId getId() {
		return id; 
		
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<String> getDirector() {
		return director;
	}

	public void setDirector(List<String> director) {
		this.director = director;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	@Override
	public String toString() {
		return "Pelikula [Titulua=" + title + ", Urtea=" + year + ", Zuzendaria=" + director + ", Aktoreak=" + cast + "]";
	}
	
	
}
