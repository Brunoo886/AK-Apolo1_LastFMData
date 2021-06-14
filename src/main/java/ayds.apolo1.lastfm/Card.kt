package ayds.apolo1.lastfm

interface Card {
    val description: String
    val infoUrl: String
    val sourceLogoUrl :String
    val source: Int
    var isLocallyStored: Boolean
}

data class CardImpl(
    override val description: String,
    override val infoUrl: String,
    override val sourceLogoUrl: String,
    override val source: Int, //se inicializa en algun valor?
    override var isLocallyStored: Boolean = false
) : Card

object EmptyCard : Card {
    override val description: String = ""
    override val infoUrl: String = ""
    override val sourceLogoUrl: String = ""
    override val source = -1
    override var isLocallyStored: Boolean = false
}