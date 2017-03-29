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
						[pattern: '/api/**',filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],
						[pattern: '/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
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
					[pattern: '/tvml', access: ['permitAll']],
					[pattern: '/tvml/show/*', access: ['permitAll']],
					[pattern: '/error', access: ['permitAll']],
					[pattern: '/info', access: ['permitAll']],
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
					[pattern: '/hotel',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/index',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/show/*',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/create',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/save',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/edit/*',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/editAddress/*',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/editSocialNetwork/*',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/update/*',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/editFeaturedImage/*',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/updateAddress',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/updateSocialNetwork',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/uploadFeaturedImage',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/addImage/*',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/uploadImage',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/deleteFeaturedImageUrl',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/deleteImageUrl',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/hotel/delete/*',  access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_EDITOR']],
					[pattern: '/restaurant',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/index',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/show/*',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/create',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/save',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/edit/*',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/editAddress/*',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/editSocialNetwork/*',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/updateAddress',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/updateSocialNetwork',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/update/*',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/editFeaturedImage/*',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/uploadFeaturedImage',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/addImage/*',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/uploadImage',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/deleteFeaturedImageUrl',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/deleteImageUrl',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/restaurant/delete/*',  access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/poi',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/index',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/show/*',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/create',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/save',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/edit/*',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/editAddress/*',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/editSocialNetwork/*',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/updateAddress',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/updateSocialNetwork',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/update/*',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/editFeaturedImage/*',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/uploadFeaturedImage',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/addImage/*',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/uploadImage',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/deleteFeaturedImageUrl',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/deleteImageUrl',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/poi/delete/*',  access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
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
					[pattern: '/api/villages/*', httpMethod: 'PUT', access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/api/pois', httpMethod: 'GET', access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/api/pois', httpMethod: 'POST', access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/api/pois/*', httpMethod: 'GET', access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/api/pois/*', httpMethod: 'DELETE', access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/api/pois/*', httpMethod: 'PUT', access: ['ROLE_POI_EDITOR', 'ROLE_POI_MANAGER']],
					[pattern: '/api/restaurants', httpMethod: 'GET', access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/api/restaurants', httpMethod: 'POST', access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/api/restaurants/*', httpMethod: 'GET', access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/api/restaurants/*', httpMethod: 'DELETE', access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_RESTAURANT_MANAGER']],
					[pattern: '/api/restaurants/*', httpMethod: 'PUT', access: ['ROLE_RESTAURANT_EDITOR', 'ROLE_VRESTAURANT_MANAGER']],
					[pattern: '/api/hotels', httpMethod: 'GET', access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/api/hotels', httpMethod: 'POST', access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/api/hotels/*', httpMethod: 'GET', access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/api/hotels/*', httpMethod: 'DELETE', access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']],
					[pattern: '/api/hotels/*', httpMethod: 'PUT', access: ['ROLE_HOTEL_EDITOR', 'ROLE_HOTEL_MANAGER']]
			]
		}
	}
}