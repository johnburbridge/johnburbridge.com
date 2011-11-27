package com.johnburbridge.blog

/**
 * @author jburbridge
 * @since 11/25/2011
 */
class Post {

	String title;
	User author;
	Date postedDate;
	String body;
	
	static belongsTo = User;
	static hasMany = [comments: Comment];
	
    static constraints = {
		title blank: false;
		author blank: false;
		postedDate blank: false;
		body blank: false, maxSize: 5000;
    }
	
	String toString() {
		"${title} - [${postedDate}]";
	}
}
