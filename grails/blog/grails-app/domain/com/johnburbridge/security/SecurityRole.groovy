package com.johnburbridge.security

class SecurityRole {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
	
	String toString() {
		authority
	}
}
