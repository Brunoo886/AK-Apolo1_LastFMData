package ayds.apolo1.lastfm

import ayds.apolo1.lastfm.entities.ArtistInfo

interface LastFMArtistInfoService {
    fun getArtistCard(artistName: String): ArtistInfo?
}