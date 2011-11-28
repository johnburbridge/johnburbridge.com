package com.johnburbridge.blog

import grails.test.*

/**
 * @author jburbridge
 * @since 11/27/2011
 */
class UserControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testInstance() {
		def userController = new UserController();
		assertTrue(userController.asBoolean());
	}
}
