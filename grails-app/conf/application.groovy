// ACL
//grails.plugin.springsecurity.acl.authority.modifyAuditingDetails = 'ROLE_SYSTEM'
//grails.plugin.springsecurity.acl.authority.changeOwnership = 'ROLE_SYSTEM'
//grails.plugin.springsecurity.acl.authority.changeAclDetails = 'ROLE_SYSTEM'

//rendering json
//grails.converters.json.default.deep = true

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.jait.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.jait.UserRole'
grails.plugin.springsecurity.authority.className = 'com.jait.Role'

//grails.plugin.springsecurity.rest.login.endpointUrl = '/login'
grails.plugin.springsecurity.rest.login.failureStatusCode = 401
grails.plugin.springsecurity.rest.login.useJsonCredentials = true

grails.plugin.springsecurity.rest.token.generation.jwt.algorithm = 'HS512'
grails.plugin.springsecurity.rest.token.validation.useBearerToken = true
grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = true
grails.plugin.springsecurity.rest.token.storage.jwt.useSignedJwt = true

//logout
grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'
//grails.plugin.springsecurity.rest.token.validation.headerName = ''

final String anonymousFilter = 'anonymousAuthenticationFilter, restTokenValidationFilter, restExceptionTranslationFilter, filterInvocationInterceptor'

final String traditionalFilter = 'JOINED_FILTERS, -restTokenValidationFilter, -restExceptionTranslationFilter'

final String statelessFilter = 'JOINED_FILTERS, -anonymousAuthenticationFilter, -exceptionTranslationFilter, -authenticationProcessingFilter, -securityContextPersistenceFilter, -rememberMeAuthenticationFilter'


grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.interceptUrlMap = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        //auth api
        [pattern: '/login/**', access: ['permitAll']],
        [pattern: '/api/login', access: ['ROLE_ANONYMOUS']],
        [pattern: '/logout/**', access: ['isFullyAuthenticated()']],
        [pattern: '/api/logout', access: ['isFullyAuthenticated()']],
        [pattern: '/oauth/access_token', access: ['permitAll']],
        [pattern: '/register', access: ['permitAll']],
        //secure api
        [pattern: '/admin/user', access: ['ROLE_SYSTEM']],
        //public api
        [pattern: '/api/**', access: ['permitAll']],
]

//grails.plugin.springsecurity.filterChain.chainMap = [
//        [pattern: '/assets/**', filters: anonymousFilter],
//        [pattern: '/**/js/**', filters: anonymousFilter],
//        [pattern: '/**/css/**', filters: anonymousFilter],
//        [pattern: '/**/images/**', filters: anonymousFilter],
//        [pattern: '/**/favicon.ico', filters: anonymousFilter],
//
//        //api
//        [pattern: '/admin/**', filters: statelessFilter],
//
//        [pattern: '/**', filters: traditionalFilter]
//]