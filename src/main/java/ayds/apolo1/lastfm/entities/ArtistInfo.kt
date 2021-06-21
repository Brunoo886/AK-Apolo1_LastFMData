package ayds.apolo1.lastfm.entities

/**
 * An interface representing an artist's info
 * @property description a brief description of the artist
 * @property infoUrl the url to the full article on LastFM's web page
 * @property sourceLogoUrl LastFM's logo image url
 */
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