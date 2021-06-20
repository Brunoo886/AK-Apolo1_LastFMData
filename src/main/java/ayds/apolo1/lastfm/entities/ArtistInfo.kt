package ayds.apolo1.lastfm.entities

interface ArtistInfo {
    val artist: String
    val info: String
    val url: String
}

data class LastFMArtistInfo(
    override val artist: String,
    override val info: String,
    override val url: String,
) : ArtistInfo

object EmptyArtistInfo : ArtistInfo {
    override val artist: String = ""
    override val info: String = ""
    override val url: String = ""
}