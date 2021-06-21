package ayds.apolo1.lastfm

import ayds.apolo1.lastfm.entities.ArtistInfo

interface LastFMArtistInfoService {
    fun getArtistInfo(artistName: String): ArtistInfo?
}