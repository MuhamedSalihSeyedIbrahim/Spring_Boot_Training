package com.cognizant.jpa.hip.demo.ui;

import java.util.TreeSet;

import javax.persistence.EntityManager;

import com.cognizant.jpa.hip.demo.model.manytomany.Artist;
import com.cognizant.jpa.hip.demo.model.manytomany.Movie;
import com.cognizant.jpa.hip.demo.util.JPAUtil;

public class MoviesApp {
	
	public static void main(String args[]) {
		
		Artist a1=new Artist(101,"fsdkbfksdf",new TreeSet<Movie>());
		Artist a2=new Artist(102,"gfdsgfsdg",new TreeSet<Movie>());
		Artist a3=new Artist(103,"fghfdh",new TreeSet<Movie>());
		
		Movie m1=new Movie(101,"fsdfsfsdgd",new TreeSet<Artist>());
		Movie m2=new Movie(102,"fsdfsfsdgd",new TreeSet<Artist>());
		
		m1.getArtists().add(a1);
		m1.getArtists().add(a2);
		m1.getArtists().add(a3);
		
		a1.getMovies().add(m1);
		a2.getMovies().add(m2);
		a3.getMovies().add(m2);
		
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.getTransaction().commit();
		
		System.out.println("Data Saved");
		JPAUtil.shutdown();
	}

}
