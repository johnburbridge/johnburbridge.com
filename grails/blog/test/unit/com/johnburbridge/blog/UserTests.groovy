package com.johnburbridge.blog

import grails.test.*

/**
 * @author jburbridge
 * @since 11/27/2011
 */
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
		assertEquals('Duncan Idaho <didaho@choam.com>', user.toString());
    }
	
	public static User getNewUser() {
		String username = 'd' + new Random().nextLong().toString();
		new User(
			firstName: 'Duncan',
			lastName: 'Idaho',
			username: username,
			password: 'secret',
			email: 'didaho@choam.com',
			bio: 'Poet & Assassin!'
		);
	}
}
