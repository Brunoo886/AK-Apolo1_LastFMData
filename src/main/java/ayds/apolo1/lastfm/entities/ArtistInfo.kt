package ayds.apolo1.lastfm.entities

interface ArtistInfo {
    val description: String
    val infoUrl: String
    val sourceLogoUrl: String
}

data class LastFMArtistInfo(
    override val description: String,
    override val infoUrl: String,
    override val sourceLogoUrl: String,
) : ArtistInfo