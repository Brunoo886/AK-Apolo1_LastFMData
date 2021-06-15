package ayds.apolo1.lastfm

import ayds.apolo1.lastfm.entities.CardImpl

interface LastFMArtistCardService {
    fun getArtistCard(artistName: String): CardImpl?
}