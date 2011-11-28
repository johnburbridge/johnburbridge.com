grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {

        mavenRepo "http://repo.johnburbridge.net:8081/artifactory/remote-repos/"
        mavenRepo "http://repo.johnburbridge.net:8081/artifactory/libs-releases-local/"
        mavenRepo "http://repo.johnburbridge.net:8081/artifactory/plugins-releases-local/"

		grailsPlugins()
		grailsHome()
		grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
    }
}

coverage {
	enabledByDefault = true;
	exclusions = [ "**/com/johnburbridge/security/**" ];
}

codenarc {
	reportName = 'target/test-reports/CodeNarcReport.xml'
	reportType = 'xml'
	// any further settings like maxPriority1Violations=0
}

grails.project.dependency.distribution = {
	remoteRepository(id: "gradleLocal", url: "http://repo.johnburbridge.net:8081/artifactory/gradle-local/") {
		authentication username: "${repo_username}", password: "${repo_password}"
	}
}

