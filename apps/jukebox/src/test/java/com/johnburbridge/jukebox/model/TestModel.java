package com.johnburbridge.jukebox.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestModel {

	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void setUp() {
		sessionFactory = new Configuration()
			.configure() // configures settings from hibernate.cfg.xml
			.buildSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAlbum() {
		// create a couple of events...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save( new Album( "Our very first album!", new Date() ) );
		session.save( new Album( "The second album", new Date() ) );
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
        session.beginTransaction();
        List<Album> result = session.createQuery( "from Album" ).list();
		for ( Album album : (List<Album>) result ) {
			System.out.println( "Album (" + album.getReleaseDate() + ") : " + album.getName() );
		}
		assertEquals(2,result.size());
        session.getTransaction().commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testArtist() {
		// create a couple of events...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save( new Artist( "Primus") );
		session.save( new Artist( "Tool") );
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
        session.beginTransaction();
        List<Artist> result = session.createQuery( "from Artist" ).list();
		for ( Artist artist : (List<Artist>) result ) {
			System.out.println( "Artist (" + artist.getId() + ") : " + artist.getName() );
		}
		assertEquals(2,result.size());
        session.getTransaction().commit();
        session.close();
	}
	

	@AfterClass
	public static void tearDown() {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

}
