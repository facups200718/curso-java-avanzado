package com.anncode.amazonviewer.model;

import com.anncode.amazonviewer.dao.MovieDAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 */
public class Movie extends Film implements IVisualizable, MovieDAO {

	private int id;
	private int timeViewed;
	private Timestamp dateTimeViewed;

	public Movie() {

	}

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}
	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	public Timestamp getDateTimeViewed() { return dateTimeViewed; }

	public void setDateTimeViewed(Timestamp dateTimeViewed) {
		this.dateTimeViewed = dateTimeViewed;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: MOVIE ::" +
				"\n Title: " + getTitle() +
				"\n Genero: " + getGenre() +
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration() +
				(Objects.nonNull(getDateTimeViewed())
						? "\n Viewed: " + getDateTimeViewed()
						: "");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param dateI Fecha de inicio*/
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param dateI Fecha de inicio
	 * @param dateF Fecha de finalización
	 * */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub

		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeViewed(0);
		}


	}

	public static ArrayList<Movie> makeMoviesList() {
		var movie = new Movie();
		return movie.read();
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void view() {
		this.setMovieViewedStatus(this);
		this.setViewed(true);
		Date dateI = this.startToSee(new Date());

		//Termine de verla
		this.stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + this.toString());
		System.out.println("Por: " + this.getTimeViewed() + " milisegundos");
	}
}







