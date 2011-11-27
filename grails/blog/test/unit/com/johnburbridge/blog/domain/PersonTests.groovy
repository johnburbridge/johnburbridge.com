package com.johnburbridge.blog.domain

import grails.test.*

class PersonTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		mockDomain(Person)
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testConstraints() {
		assertTrue(getNewPerson().validate());
		assertFalse(new Person().validate());
	}

    void testToString() {
		def person = getNewPerson();
		assertEquals('Paul Atreides <patreides@choam.com>', person.toString());
    }
	
	public static Person getNewPerson() {
		new Person(
			firstName: 'Paul',
			lastName: 'Atreides',
			userName: 'muadib',
			password: 'secret',
			email: 'patreides@choam.com',
			bio: '''Blind Prophet & Kwisatz Haderach'''
		);
	}
}