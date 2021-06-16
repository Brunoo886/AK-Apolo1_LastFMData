package ayds.apolo1.lastfm.entities

interface Card {
    val description: String
    val infoUrl: String
    val sourceLogoUrl: String
    val source: Int
    var isLocallyStored: Boolean
}

data class CardImpl(
    override val description: String,
    override val infoUrl: String,
    override val sourceLogoUrl: String,
    override val source: Int,
    override var isLocallyStored: Boolean = false
) : Card