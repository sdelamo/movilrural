package com.softamo.movilrural

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/api/${controller}s"(version: '1.0', namespace: 'v1', method: 'GET')
        "/api/${controller}s/$id"(version: '1.0', action: 'show', namespace: 'v1', method: 'GET')
        "/api/${controller}s/create"(version: '1.0', action: 'create', namespace: 'v1', method: 'GET')
        "/api/${controller}s"(action: 'save', version: '1.0', namespace: 'v1', method: 'POST')
        "/api/${controller}s/$id/edit"(action: 'edit', version: '1.0', namespace: 'v1', method: 'GET')
        "/api/${controller}s/$id"(action: 'update', version: '1.0', namespace: 'v1', method: 'PUT')
        "/api/${controller}s/$id"(action: 'delete', version: '1.0', namespace: 'v1', method: 'DELETE')

        '/'(redirect: '/village/index')
        '500'(view: '/error')
        '404'(view: '/notFound')
    }
}
