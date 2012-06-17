package com.johnburbridge.blog

import grails.test.*

/**
 * @author jburbridge
 * @since 11/27/2011
 */
class CommentTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		mockDomain(Comment)
    }

    protected void tearDown() {
        super.tearDown()
    }

	void testConstraints() {
		assertTrue(getNewComment(new Date()).validate());
		assertFalse(new Comment().validate());
	}

    void testToString() {
		def date = new Date();
		def comment = getNewComment(date);
		assertEquals(new String("anonymous - [${date}]"), comment.toString());
    }
	
	static Comment getNewComment(Date date) {
		def post = PostTests.getNewPost();
		new Comment(
			post: post,
			visitorName: 'anonymous',
			visitorEmail: 'foo@bar.com',
			postedDate: date,
			body: 'I like it!'
		);
	}
}
