import org.grails.plugins.tvml.MediaItem

model {
    Iterable<MediaItem> mediaItemList
    Integer mediaItemCount
    Iterable<String> categories
}

document {
    stackTemplate {
        banner {
            title this.g.message(code: 'movies.title', default: 'Movies')
        }
        collectionList {
            categories.each { sectionTitle ->
                shelf {
                    section {
                        header {
                            title sectionTitle
                        }
                        (mediaItemList as List<MediaItem>).findAll { MediaItem mediaItem ->
                            mediaItem.subtitle == sectionTitle
                        }.each { MediaItem mediaItem ->
                            lockup(onselect: "getDocument('tvml/show/${mediaItem.id}')") {
                                img(src: mediaItem.artworkImageURL, width: 548, height: 308)
                                title mediaItem.title
                            }
                        }
                    }
                }

            }
        }
    }
}