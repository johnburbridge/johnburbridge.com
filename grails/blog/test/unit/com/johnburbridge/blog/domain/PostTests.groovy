package com.johnburbridge.blog.domain

import grails.test.*

class PostTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testToString() {
		def person = PersonTests.getNewPerson();
		def post = new Post(
			title: 'hello world!',
			postedDate: new Date(0),
			body: 'this is the body',
			author: person
		);
		assertEquals('hello world! - [Wed Dec 31 16:00:00 PST 1969]', post.toString());
    }
}
