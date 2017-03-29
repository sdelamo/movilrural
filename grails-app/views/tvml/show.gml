import org.grails.plugins.tvml.BrazilMovieRating
import org.grails.plugins.tvml.MediaItem
import org.grails.plugins.tvml.NewZealandMovieRating
import org.grails.plugins.tvml.ResourceUtil
import org.grails.plugins.tvml.RottenTomatoRating
import org.grails.plugins.tvml.UnitedKingdomMovieRating
import org.grails.plugins.tvml.UnitedStatesMovieRating
import org.grails.plugins.tvml.UnitedStatesTelevisionContentRating

model {
    MediaItem mediaItem
    Iterable<MediaItem> relatedMediaItems
}

document {
    productTemplate {
        banner {
            infoList {
                if ( mediaItem.videographers ) {
                    info {
                        header {
                            title this.g.message(code: 'mediaItem.videographers.label')
                        }
                        mediaItem.videographers.each { videographer ->
                            text "$videographer"
                        }
                    }
                }
                if ( mediaItem.videoEditors ) {
                    info {
                        header {
                            title this.g.message(code: 'mediaItem.videoEditors.label')
                        }
                        mediaItem.videoEditors.each { videoEditor ->
                            text "$videoEditor"
                        }
                    }
                }
                if ( mediaItem.musicCredits ) {
                    info {
                        header {
                            title this.g.message(code: 'mediaItem.musicCredits.label')
                        }
                        mediaItem.musicCredits.each { musicCredit ->
                            text "$musicCredit"
                        }
                    }
                }

            }
            stack {
                title mediaItem.title
                subtitle mediaItem.subtitle
                row {
                    text "${mediaItem.durationMinutes}min ${mediaItem.durationSeconds}sec"
                    text mediaItem.releaseYear
                    if ( mediaItem.highDefinition ) {
                        badge(src: "resource://hd", class: "badge")
                    }
                    if ( mediaItem.closedCaptioning ) {
                        badge(src: "resource://cc", class: "badge")
                    }

                    if ( mediaItem.brazilMovieRating != BrazilMovieRating.UNDEFINED ) {
                        badge(src: "resource://${ResourceUtil.resourceNameForBrazilMovieRating(mediaItem.brazilMovieRating)}", class: "badge")
                    }

                    if ( mediaItem.newZealandMovieRating != NewZealandMovieRating.UNDEFINED ) {
                        badge(src: "resource://${ResourceUtil.resourceNameForNewZealandMovieRating(mediaItem.newZealandMovieRating)}", class: "badge")
                    }

                    if ( mediaItem.unitedKingdomMovieRating != UnitedKingdomMovieRating.UNDEFINED ) {
                        badge(src: "resource://${ResourceUtil.resourceNameForUnitedKingdomMovieRating(mediaItem.unitedKingdomMovieRating)}", class: "badge")
                    }

                    if ( mediaItem.unitedStatesMovieRating != UnitedStatesMovieRating.UNDEFINED ) {
                        badge(src: "resource://${ResourceUtil.resourceNameForUnitedStatesMovieRating(mediaItem.unitedStatesMovieRating)}", class: "badge")
                    }

                    if ( mediaItem.unitedStatesTelevisionContentRating != UnitedStatesTelevisionContentRating.UNDEFINED ) {
                        badge(src: "resource://${ResourceUtil.resourceNameForUnitedStatesTelevisionContentRating(mediaItem.unitedStatesTelevisionContentRating)}", class: "badge")
                    }
                    if ( mediaItem.rottenTomatoRating != RottenTomatoRating.UNDEFINED ) {
                        badge(src: "resource://${ResourceUtil.resourceNameForRottenTomatoRating(mediaItem.rottenTomatoRating)}", class: "badge")
                    }
                }
                description(allowsZooming: "true", moreLabel: "more", "${mediaItem.description}")
                row {
                    buttonLockup(onselect: "playMedia('${mediaItem.url}', 'video')", onplay: "playMedia('${mediaItem.url}', 'video')") {
                        badge(src: "resource://button-play")
                        title "Play"
                    }
                }
            }
            heroImg(src: mediaItem.artworkImageURL, width: 548, height: 308)
        }

        shelf {
            header {
                title this.g.message(code: 'mediaItem.relatedVideos.label')
            }
            section {
                relatedMediaItems?.each { relatedMediaItem ->
                    lockup(onselect: "getDocument('tvml/show/${relatedMediaItem.id}')") {
                        img(src: relatedMediaItem.artworkImageURL, width: 274, height: 154)
                        title relatedMediaItem.title
                    }
                }
            }
        }
    }
}