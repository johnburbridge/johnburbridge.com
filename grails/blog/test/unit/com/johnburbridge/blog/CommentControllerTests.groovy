package com.johnburbridge.blog

import grails.test.*

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
