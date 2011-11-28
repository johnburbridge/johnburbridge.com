import com.johnburbridge.blog.Comment
import com.johnburbridge.blog.User;
import com.johnburbridge.blog.Post;
import com.johnburbridge.security.SecurityRole;
import com.johnburbridge.security.SecurityUserSecurityRole;

class BootStrap {

	// def springSecurityService;
	
    def init = { servletContext ->
		
		def user = new User(
			firstName: 'John',
			lastName: 'Burbridge',
			username: 'jburbridge',
			password: 'foobarbaz',
			enabled: true,
			email: 'jburbridge@johnburbridge.net',
			bio: '''Software Engineer & Fun Loving Person'''
		);
		if (user.validate()) {
			println "Creating user $user...";
			if (!user.save()) {
				person.errors.allErrors.each { error ->
					println "An error occured while bootstrapping user: ${error}"
				}
			} 
		}
		
		// first check if we already have these roles created and if not, populate the database
		def userRole = SecurityRole.findByAuthority("ROLE_USER") ?: new SecurityRole(authority: "ROLE_USER").save();
		def adminRole = SecurityRole.findByAuthority("ROLE_ADMIN") ?: new SecurityRole(authority: "ROLE_ADMIN").save();
		
		SecurityUserSecurityRole.create(user, userRole);
		SecurityUserSecurityRole.create(user, adminRole);
		
		// now add a couple of posts
		def post1 = new Post(
			title: 'Welcome to my blog',
			postedDate: new Date(),
			body: '''The purpose of this blog application is to test the 
                     functionality contained in Grails while at the same time
                     documenting the development process. It's very meta, in the sense
                     that I am posting about developing the application while doing
                     the development of the application. More on that later... :)''',
			author: user
		);
		if (!post1.save()) {
			post1.errors.allErrors.each { error ->
				println "An error occured while bootstrapping post1: ${error}"
			}
		} 
		def post2 = new Post(
			title: 'Writing bootstrapping code',
			postedDate: new Date(),
			body: '''One of the cool things about Grails is the how seriously the framework
                     enforces the idea of test-driven development. It seems as if a lot of thought
                     was devoted to the methodology driving the tooling (as opposed to the other
                     way around). I would expect that this would be incredibly easy to share with
                     other developers as the unit tests and data bootstraps do a great job of 
                     demonstrating how it all works.''',
			author: user
		);
		if (!post2.save()) {
			post2.errors.allErrors.each { error ->
				println "An error occured while bootstrapping post2: ${error}"
			}
		} 
		
		// and add a few comments to the posts
		def comment1 = new Comment(
			post: post1,
			visitorName: 'anonymous',
			visitorEmail: 'foo@bar.com',
			postedDate: new Date(),
			body: 'Yay! Finally!'
		);
		if (!comment1.save()) {
			comment1.errors.allErrors.each { error ->
				println "An error occured while bootstrapping comment1: ${error}"
			}
		} 
		

		def comment2 = new Comment(
			post: post1,
			visitorName: 'elena',
			visitorEmail: 'eleeena@mac.com',
			postedDate: new Date(),
			body: 'Wheeeeeee!'
		);
		if (!comment2.save()) {
			comment2.errors.allErrors.each { error ->
				println "An error occured while bootstrapping comment2: ${error}"
			}
		} 
		

		def comment3 = new Comment(
			post: post2,
			visitorName: 'elena',
			visitorEmail: 'eleeena@mac.com',
			postedDate: new Date(),
			body: 'What\'s bootstrapping?!'
		);
		if (!comment3.save()) {
			comment3.errors.allErrors.each { error ->
				println "An error occured while bootstrapping comment3: ${error}"
			}
		} 
    }
    def destroy = {
    }
}
