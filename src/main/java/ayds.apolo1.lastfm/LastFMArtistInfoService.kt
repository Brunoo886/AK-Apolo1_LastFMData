package ayds.apolo1.lastfm

interface LastFMArtistInfoService {
    fun getArtistInfo(artistName: String): CardImpl?
}