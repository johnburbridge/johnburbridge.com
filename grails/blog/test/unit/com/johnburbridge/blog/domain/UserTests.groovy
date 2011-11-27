package com.johnburbridge.blog.domain

import grails.test.*

class UserTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		mockDomain(User)
    }

    protected void tearDown() {
        super.tearDown()
    }

	void testConstraints() {
		assertTrue(getNewUser().validate());
		assertFalse(new User().validate());
	}

    void testToString() {
		def user = getNewUser();
		assertEquals('didaho', user.toString());
    }
	
	public static User getNewUser() {
		new User(
			firstName: 'Duncan',
			lastName: 'Idaho',
			userName: 'didaho',
			password: 'secret',
			email: 'didaho@choam.com',
			bio: 'Poet & Assassin!'
		);
	}
}
