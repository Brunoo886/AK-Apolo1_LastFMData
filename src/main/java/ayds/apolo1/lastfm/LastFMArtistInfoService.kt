package ayds.apolo1.lastfm

import ayds.apolo1.lastfm.entities.CardImpl

interface LastFMArtistInfoService {
    fun getArtistInfo(artistName: String): CardImpl?
}