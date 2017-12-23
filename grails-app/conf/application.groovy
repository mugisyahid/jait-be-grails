

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.jait.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.jait.UserRole'
grails.plugin.springsecurity.authority.className = 'com.jait.Role'

grails.plugin.springsecurity.rest.login.endpointUrl = '/login'
grails.plugin.springsecurity.rest.login.failureStatusCode = 401
grails.plugin.springsecurity.rest.login.useJsonCredentials = true

grails.plugin.springsecurity.rest.token.generation.jwt.algorithm = 'HS512'
grails.plugin.springsecurity.rest.token.validation.useBearerToken = true
grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = true
grails.plugin.springsecurity.rest.token.storage.jwt.useSignedJwt = true

//logout
grails.plugin.springsecurity.rest.logout


final String anonymousFilter = 'anonymousAuthenticationFilter,restTokenValidationFilter,' +
		'restExceptionTranslationFilter,filterInvocationInterceptor'

final String tokenFilter = 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,' +
		'-authenticationProcessingFilter,-securityContextPersistenceFilter,' +
		'-rememberMeAuthenticationFilter'

grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.interceptUrlMap = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],

	[pattern: '/login', 	access: ['permitAll']],
	[pattern: '/logout',	access: ['isFullyAuthenticated()']],
	[pattern: '/register', 	access: ['permitAll']],

	[pattern: '/admin/**',	access: ['ROLE_SYSTEM, ROLE_ADMIN']],
]


grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: anonymousFilter],
	[pattern: '/**/js/**',       filters: anonymousFilter],
	[pattern: '/**/css/**',      filters: anonymousFilter],
	[pattern: '/**/images/**',   filters: anonymousFilter],
	[pattern: '/**/favicon.ico', filters: anonymousFilter],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

