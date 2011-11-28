package com.johnburbridge.blog

import grails.test.*

/**
 * @author jburbridge
 * @since 11/25/2011
 */
class CommentControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testInstance() {
		def commentController = new CommentController();
		assertTrue(commentController.asBoolean());
	}
}
