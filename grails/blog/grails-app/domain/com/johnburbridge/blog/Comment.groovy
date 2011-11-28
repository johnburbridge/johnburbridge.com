package com.johnburbridge.blog

/**
 * @author jburbridge
 * @since 11/25/2011
 */
class Comment {

	Post post;
	String visitorName;
	String visitorEmail;
	Date postedDate;
	String body;

	static belongsTo = Post;
	
    static constraints = {
		visitorName blank: false;
		postedDate blank: false;
		body blank: false, maxSize: 1000;
    }
	
	String toString() {
		"$visitorName - [$postedDate]"
	}
}
