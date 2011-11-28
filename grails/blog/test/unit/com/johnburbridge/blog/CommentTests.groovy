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
		assertTrue(getNewComment().validate());
		assertFalse(new Comment().validate());
	}

    void testToString() {
		def comment = getNewComment();
		assertEquals('anonymous - [Wed Dec 31 16:00:00 PST 1969]', comment.toString());
    }
	
	static Comment getNewComment() {
		def post = PostTests.getNewPost();
		new Comment(
			post: post,
			visitorName: 'anonymous',
			visitorEmail: 'foo@bar.com',
			postedDate: new Date(0),
			body: 'I like it!'
		);
	}
}
