import com.johnburbridge.blog.domain.Person;
import com.johnburbridge.blog.domain.Post;
import com.johnburbridge.blog.domain.User

class BootStrap {

    def init = { servletContext ->
		def user = new User(
			firstName: 'John',
			lastName: 'Burbridge',
			userName: 'jburbridge',
			password: 'secret',
			email: 'jburbridge@johnburbridge.net',
			bio: '''Software Engineer & Fun Loving Person'''
		);
		if (!user.save()) {
			person.errors.allErrors.each { error ->
				println "An error occured while bootstrapping user: ${error}"
			}
		} 
		def post1 = new Post(
			title: 'Welcome to your blog',
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
    }
    def destroy = {
    }
}
