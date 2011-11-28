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
		assertTrue(getNewPost().validate());
		assertFalse(new Post().validate());
	}

    void testToString() {
		def post = getNewPost();
		assertEquals('hello world! - [Wed Dec 31 16:00:00 PST 1969]', post.toString());
    }
	
	static Post getNewPost() {
		def user = UserTests.getNewUser();
		new Post(
			title: 'hello world!',
			postedDate: new Date(0),
			body: 'this is the body',
			author: user
		);
	}
}
