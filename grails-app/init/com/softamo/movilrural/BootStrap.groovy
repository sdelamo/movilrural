package com.softamo.movilrural

import grails.util.Environment
import org.grails.plugins.tvml.MediaItem

class BootStrap {

    final static List<String> VISITOR_AUTHORITIES = ['ROLE_VILLAGE_VISITOR',
                                             'ROLE_POI_VISITOR',
                                             'ROLE_HOTEL_VISITOR',
                                             'ROLE_RESTAURANT_VISITOR',
                                             'ROLE_VIDEO_VISITOR',
                                             'ROLE_ROUTE_VISITOR']

    final static List<String> EDITOR_AUTHORITIES = ['ROLE_VILLAGE_EDITOR',
                       'ROLE_POI_EDITOR',
                       'ROLE_HOTEL_EDITOR',
                       'ROLE_RESTAURANT_EDITOR',
                       'ROLE_VIDEO_EDITOR',
                       'ROLE_ROUTE_EDITOR']

    final static List<String> MANAGER_AUTHORITIES =
                       ['ROLE_VILLAGE_MANAGER',
                       'ROLE_POI_MANAGER',
                       'ROLE_HOTEL_MANAGER',
                       'ROLE_RESTAURANT_MANAGER',
                       'ROLE_VIDEO_MANAGER',
                       'ROLE_ROUTE_MANAGER']

    def init = { servletContext ->
        saveRoles()
        saveAdminUser()
        def server = 'http://adelsierranorte.s3.amazonaws.com'
        def mediaServerPreffix = "${server}/videos/"
        def artworkServerPreffix = "${server}/videos/images/"
        adelVideos().each {
            if ( !MediaItem.findByTitle(it.title) ) {
                new MediaItem(type: 'video',
                    releaseYear: it.releaseYear,
                    durationSeconds: it.durationSeconds,
                    durationMinutes: it.durationMinutes,
                    highDefinition: true,
                    title: it.title,
                    subtitle: it.category,
                    description: it.description,
                    videoEditors: it.videoEditors,
                    videographers: it.videographers,
                    musicCredits: it.musicCredits,
                    artworkImageURL: it.name ? "${artworkServerPreffix}${it.name}.png" : null,
                    url: "${mediaServerPreffix}${it.name}.mp4").save(failOnError: true)
            }
        }
    }

    def destroy = {
    }

    void saveAdminUser() {
        if ( Environment.DEVELOPMENT == Environment.current) {
            if ( !User.findByUsername('admin') ) {
                def user = new User('admin', 'admin')
                user.save failOnError: true
                allAuthorities().each { String authority ->
                    def role = Role.findByAuthority(authority)
                    def userRole = new UserRole(user, role)
                    userRole.save failOnError: true
                }
            }
        }
    }

    static List<String> allAuthorities() {
        def authorities = []
        authorities += VISITOR_AUTHORITIES
        authorities += EDITOR_AUTHORITIES
        authorities += MANAGER_AUTHORITIES
        authorities
    }

    void saveRoles() {
        allAuthorities().each { String authority ->
            if ( !Role.findByAuthority(authority) ) {
                new Role(authority).save()
            }
        }
    }

    @SuppressWarnings(['LineLength', 'MethodSize'])
    List<Map> adelVideos() {
        [[
                 title: 'Románico Rural',
                 name: 'Albendiego',
                 category: 'Patrimonio',
                 image: 'albendiego.jpg',
                 releaseYear: 2013,
                 durationSeconds: 6,
                 durationMinutes: 2,
                 description: 'Miguel Ángel, director del Museo Diocesano de arte antiguo de Siguenza, habla sobre la iglesia de Santa Coloma en Albendiego',

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],
                 musicCredits: ['Apples + Orange']

         ],
        
                [
                        title: 'Clip Sierra Norte',
                        name: 'clip_sierra_carlos_morales',
                        category: 'Certamen de Cortos Publicitarios Sierra Norte de Guadalajara',
                        image: 'clip_sierra_carlos_morales.png',
                        releaseYear: 2017,
                        durationSeconds: 29,
                        durationMinutes: 2,
                        description: 'Segundo premio del Certamen de Cortos Publicitarios Sierra Norte de Guadalajara',
                        videographers: ['Carlos Morales'],
                        videoEditors: [],
                        musicCredits: []
                ],
                [
                        title: 'Serranía Limite Infinito',
                        name: 'serrania_limite_infinito',
                        category: 'Certamen de Cortos Publicitarios Sierra Norte de Guadalajara',
                        image: 'serrania_limite_infinito.png',
                        releaseYear: 2017,
                        durationSeconds: 0,
                        durationMinutes: 3,
                        description: 'Primer premio del I Certamen de Cortos Publicitarios Sierra Norte de Guadalajara 2017',
                        videographers: ['Alberto Molinero'],
                        videoEditors: [],
                        musicCredits: []
                ],
                [
                        title: 'Spot sierra',
                        name: 'spot_sierranorte_filar',
                        category: 'Certamen de Cortos Publicitarios Sierra Norte de Guadalajara',
                        image: 'spot_sierranorte_filar.png',
                        releaseYear: 2017,
                        durationSeconds: 7,
                        durationMinutes: 1,
                        description: 'Tercer premio del I Certamen de Cortos Publicitarios Sierra Norte de Guadalajara 2017',
                        videographers: ['Lukasz Filar', 'Carlos Calvo'],
                        videoEditors: [],
                        musicCredits: []
                ],
         [
                 title: 'Taller de arqueología experimental',
                 name: 'ArqueologiaExperimental',
                 category: 'Etnografía',
                 image: 'arqueologiaExperimental.jpg',
                 releaseYear: 2013,
                 durationSeconds: 30,
                 durationMinutes: 2,
                 description: 'En este vídeo se muestra como mediante la extración de una lasca de un nucleo de Silex (de Guadalajara) se puede realizar una raederera o punta de flecha',

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Arquitectura dorada',
                 description: 'Antolín, muestra la construcción de un muro de cuarcita en Valverde de los Arroyos - Zarzuela de Galve.',
                 name: 'ArquitecturaDorada',
                 category: 'Etnografía',
                 image: 'arquitecturaDorada.jpg',
                 releaseYear: 2013,
                 durationSeconds: 49,
                 durationMinutes: 2,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],
                 musicCredits: 'Puerto viejo. Candelaria'

         ],
         [
                 title: 'Artesano madera',
                 description: 'José, un artesano de Cantalojas, muestra como hacer un gamello',
                 name: 'ArtesanoMadera',
                 category: 'Etnografía',
                 image: 'artesanoMadera.jpg',
                 releaseYear: 2013,
                 durationSeconds: 46,
                 durationMinutes: 1,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Atienza',
                 name: 'Atienza',
                 category: 'Patrimonio',
                 image: 'atienza.jpg',
                 releaseYear: 2013,
                 durationSeconds: 44,
                 durationMinutes: 1,
                 description: 'Este video muestra la Villa de Atienza, frontera de reinos Cristianos y Musulmanes, con su famosa fiesta "la Caballada"',

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],
                 musicCredits: 'Dan Warren - The Turtle'

         ],
         [
                 title: 'Bota Tradicional',
                 description: 'Jesús Blasco en la Botería de Sigüenza muestra la realización una bota tradicional',
                 name: 'Botero',
                 category: 'Etnografía',
                 image: 'botero.jpg',
                 releaseYear: 2013,
                 durationSeconds: 56,
                 durationMinutes: 3,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Románico Rural - Campisabalos',
                 description: 'Servino, vecino de Campisabalos, cuenta la historía de la iglesia de San Bartolomé',
                 name: 'CampisabalosSeverino',
                 category: 'Patrimonio',
                 image: 'campisabalosSeverino.jpg',
                 releaseYear: 2013,
                 durationSeconds: 33,
                 durationMinutes: 2,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Cincelador',
                 description: 'Canfranc Lucea, cincelador de Sigüenza, muestra el paso de un dibujo desde papel al metal (plata o cobre) y el posterior cincelado',
                 name: 'Cincelador',
                 category: 'Etnografía',
                 image: 'cincelador.jpg',
                 releaseYear: 2013,
                 durationSeconds: 40,
                 durationMinutes: 3,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Fragua de Sigüenza',
                 description: 'José, un herrero de Sigüenza, muestra el trabajo en una fragua',
                 name: 'FraguaDeSiguenza',
                 category: 'Etnografía',
                 image: 'fraguaDeSiguenza.jpg',
                 releaseYear: 2013,
                 durationSeconds: 13,
                 durationMinutes: 2,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Hayedo de la Tejera Negra',
                 description: 'Joaquín nos enseña el Parque Natural del Hayedo de la Tejera Negra, Cantalojas',
                 name: 'Hayedo',
                 category: 'Naturaleza',
                 image: 'hayedo.jpg',
                 releaseYear: 2013,
                 durationSeconds: 43,
                 durationMinutes: 3,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Beleña de Sorbe',
                 description: 'Explicación del Mensario de la Iglesia de San Miguel en Beleña de Sorbe',
                 name: 'MensarioDeBelegna',
                 category: 'Patrimonio',
                 image: 'mensarioDeBelegna.jpg',
                 releaseYear: 2013,
                 durationSeconds: 51,
                 durationMinutes: 1,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Campisabalos',
                 description: 'Explicación del Mensario de la Capilla de San Galindo en Campisabalos',
                 name: 'MensarioDeCamisabalos',
                 category: 'Patrimonio',
                 image: 'mensarioDeCamisabalos.jpg',
                 releaseYear: 2013,
                 durationSeconds: 42,
                 durationMinutes: 2,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Hiendelancina',
                 description: 'Recorrido por Hiendelancina y sus Minas',
                 name: 'MinasHiendelaencina',
                 category: 'Patrimonio',
                 image: 'minasHiendelaencina.jpg',
                 releaseYear: 2013,
                 durationSeconds: 19,
                 durationMinutes: 2,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Mirilla de Dios',
                 description: '''Miguel Ángel, director del Museo Diocesano de arte antiguo de Siguenza, habla sobre la Mirilla de Dios en la Capilla de San Galindo''',
                 name: 'MirillaDeDios',
                 category: 'Patrimonio',
                 image: 'mirillaDeDios.jpg',
                 releaseYear: 2013,
                 durationSeconds: 3,
                 durationMinutes: 1,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Río Pelagallinas',
                 description: 'Joaquín nos muestra la reserva Fluvial del río Pelagallinas en Prádenas de Atienza',
                 name: 'Pelagallinas',
                 category: 'Naturaleza',
                 image: 'pelagallinas.jpg',
                 releaseYear: 2013,
                 durationSeconds: 53,
                 durationMinutes: 1,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Parque Natural del Río Dulce',
                 description: 'Joaquín nos descubre el Parque natural del Barranco del Río Dulce, Pelegrina',
                 name: 'RioDulce',
                 category: 'Naturaleza',
                 image: 'riodulce.jpg',
                 releaseYear: 2013,
                 durationSeconds: 37,
                 durationMinutes: 1,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],
                 musicCredits: ['Our eyes are blue - Mindthings']

         ],
         [
                 title: 'La Marca Media',
                 description: 'Miguel Ángel, director del Museo Diocesano de arte antiguo de Siguenza, nos habla sobre las influencias del románico en la Marca Media - Sierra de Guadalajara',
                 name: 'RomanicoYLaMarca',
                 category: 'Patrimonio',
                 image: 'romanicoYLaMarca.jpg',
                 releaseYear: 2013,
                 durationSeconds: 48,
                 durationMinutes: 1,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Guitarra Romanillos',
                 description: 'Jose Luis Romanillos, violero de Sigüenza, nos habla de la guitarra española',
                 name: 'RomanillosGuitarras',
                 category: 'Etnografía',
                 image: 'romanillosGuitarras.jpg',
                 releaseYear: 2013,
                 durationSeconds: 53,
                 durationMinutes: 2,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],
                 musicCredits: [
                         'Franciso de Tarrega - Studio di velocitá - Maurizio Oddone',
                         'Evgeny Malahov'
                 ]

         ],
         [
                 title: 'Museo Romanillos',
                 description: 'Jose Luis Romanillos, violero de Sigüenza, habla sobre el Centro de la vihuela de mano y la guitarra Española en la Casa del Doncel de Sigüenza',
                 name: 'RomanillosMuseo',
                 category: 'Etnografía',
                 image: 'romanillosMuseo.jpg',
                 releaseYear: 2013,
                 durationSeconds: 55,
                 durationMinutes: 1,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],
                 musicCredits: ['Alhaja - Victor Iniesta']

         ],
         [
                 title: 'Sabinar y ciudad encantada',
                 description: 'Joaquín nos habla del Sabinar y la ciudad encantada en Tamajón',
                 name: 'SabinarDeTamajon',
                 category: 'Naturaleza',
                 image: 'sabinarDeTamajon.jpg',
                 releaseYear: 2013,
                 durationSeconds: 9,
                 durationMinutes: 1,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],
                 musicCredits: ['Arizono Kazuhiro - July 04']

         ],
         [
                 title: 'Salinas',
                 name: 'Salinas',
                 description: 'Joaquín Latova de Hiendelancina nos habla sobre las Salinas',
                 category: 'Naturaleza',
                 image: 'salinas.jpg',
                 releaseYear: 2013,
                 durationSeconds: 58,
                 durationMinutes: 2,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],

         ],
         [
                 title: 'Sigüenza Medieval',
                 description: 'Mª Pilar Martínez, profesora titular de Arte Medieval por la Universidad de Castilla-La Mancha nos descubre la Sigüenza medieval',
                 name: 'SiguenzaMedieval',
                 category: 'Patrimonio',
                 image: 'siguenzaMedieval.jpg',
                 releaseYear: 2013,
                 durationSeconds: 41,
                 durationMinutes: 4,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],
                 musicCredits: ['Cooley Reel - Adam R Sweet']

         ],
         [
                 title: 'Trabajando la Pizarra',
                 description: 'Miguel nos enseña como rehacer un muro a piedra seca de pizarra en Campillo de Rana',
                 name: 'TrabajandoLaPizarra',
                 category: 'Etnografía',
                 image: 'trabajandoLaPizarra.jpg',
                 releaseYear: 2013,
                 durationSeconds: 23,
                 durationMinutes: 2,

                 videographers: ['Paco Quintans'],
                 videoEditors: ['Paco Quintáns', 'Daniel Blazquez'],
         ],
         //[title: '',
         // name: 'YacimientosArqueologicos.mp4',
         // category: 'Patrimonio',
         // releaseYear: 2013,
         // durationSeconds: 48,
         // durationMinutes: 3]
        ]
    }
}
