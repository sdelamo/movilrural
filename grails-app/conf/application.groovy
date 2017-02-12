grails {
	plugin {
		awssdk {
			s3 {
				region = 'eu-west-1'
				bucket = 'movilrural'
			}
		}
		springsecurity {
			securityConfigType = "InterceptUrlMap"
			filterChain {
				chainMap = [
						[pattern: '/api/**',filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],// <2>
						[pattern: '/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'] // <3>
				]
			}
			userLookup {
				userDomainClassName = 'com.softamo.movilrural.User'
				authorityJoinClassName = 'com.softamo.movilrural.UserRole'
			}
			authority {
				className = 'com.softamo.movilrural.Role'
			}
			interceptUrlMap = [
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
					[pattern: '/login/auth', access: ['ROLE_ANONYMOUS']],
					[pattern: '/api/login',  access: ['ROLE_ANONYMOUS']],
					[pattern: '/oauth/access_token',  access: ['ROLE_ANONYMOUS']],
					[pattern: '/village',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/index',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/show/*',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/create',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/save',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/edit/*',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/update/*',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/editFeaturedImage/*',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/uploadFeaturedImage',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/addImage/*',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/uploadImage',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/deleteFeaturedImageUrl',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/deleteImageUrl',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/delete/*',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/api/villages', httpMethod: 'GET', access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/api/villages', httpMethod: 'POST', access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/api/villages/*', httpMethod: 'GET', access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/api/villages/*', httpMethod: 'DELETE', access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/api/villages/*', httpMethod: 'PUT', access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']]
			]
		}
	}
}