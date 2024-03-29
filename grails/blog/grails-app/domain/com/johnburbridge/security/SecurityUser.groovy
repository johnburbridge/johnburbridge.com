package com.johnburbridge.security

class SecurityUser {

	transient springSecurityService

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<SecurityRole> getAuthorities() {
		SecurityUserSecurityRole.findAllBySecurityUser(this).collect { it.securityRole } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}

	@Override
	public String toString() {
		return "SecurityUser [username=${username}, enabled=${enabled}" 
				+ ", accountExpired=${accountExpired}, accountLocked=${accountLocked}"
				+ ", passwordExpired=${passwordExpired}]";
	}
}
