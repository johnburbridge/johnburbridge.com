package com.johnburbridge.blog

import grails.test.*

/**
 * @author jburbridge
 * @since 11/27/2011
 */
class PostControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testInstance() {
		def postController = new PostController();
		assertTrue(postController.asBoolean());
	}
}
