package com.johnburbridge.blog

import grails.test.*

/**
 * @author jburbridge
 * @since 11/27/2011
 */
class PostTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		mockDomain(Post)
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testConstraints() {
		assertTrue(getNewPost(new Date()).validate());
		assertFalse(new Post().validate());
	}

    void testToString() {
		def date = new Date();
		def post = getNewPost(date);
		assertEquals(new String("hello world! - [$date]"), post.toString());
    }
	
	static Post getNewPost(Date date) {
		def user = UserTests.getNewUser();
		new Post(
			title: 'hello world!',
			postedDate: date,
			body: 'this is the body',
			author: user
		);
	}
}
