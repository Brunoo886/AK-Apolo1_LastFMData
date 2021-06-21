package ayds.apolo1.lastfm

import ayds.apolo1.lastfm.entities.ArtistInfo

interface LastFMArtistInfoService {
    /**
    * Retrieves artists' info from LastFM's API
    * @param artistName the name of the artist whose info is required
    * @return the nullable ArtistInfo object corresponding to the selected artist
    */
    fun getArtistInfo(artistName: String): ArtistInfo?
}