package ayds.apolo1.lastfm.artistInfo

import android.util.Log
import ayds.apolo1.lastfm.entities.CardImpl
import com.google.gson.Gson
import com.google.gson.JsonObject

interface LastFmToArtistCardResolver {
    fun getArtistCardFromExternalData(serviceData: String?): CardImpl?
}

private const val ARTISTS = "artist"
private const val URL = "url"
private const val BIO = "bio"
private const val CONTENT = "content"
private const val SOURCE_LOGO_URL =
    "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Lastfm_logo.svg/320px-Lastfm_logo.svg.png"

internal class JsonToArtistCardResolver() :
    LastFmToArtistCardResolver {

    override fun getArtistCardFromExternalData(serviceData: String?): CardImpl? =
        try {
            serviceData?.getFirstResult()?.let { item ->
                CardImpl(
                    description = item.getInfoContent(),
                    infoUrl = item.getFullArticleUrl(),
                    sourceLogoUrl = SOURCE_LOGO_URL,
                    source = 1
                )
            }
        } catch (e: Exception) {
            Log.e("Info resolver", "Error $e")
            null
        }

    private fun String?.getFirstResult(): JsonObject {
        val jobj = Gson().fromJson(this, JsonObject::class.java)
        return jobj[ARTISTS].asJsonObject
    }

    private fun JsonObject.getInfoContent() =
        this[BIO]
            .asJsonObject[CONTENT]
            .asString.replace("\n", "\n")


    private fun JsonObject.getFullArticleUrl() = this[URL].asString

}