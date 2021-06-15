package ayds.apolo1.lastfm.artistInfo

import android.util.Log
import ayds.apolo1.lastfm.entities.CardImpl
import com.google.gson.Gson
import com.google.gson.JsonObject

interface LastFmToArtistInfoResolver {
    fun getArtistInfoFromExternalData(serviceData: String?): CardImpl?
}

private const val ARTISTS = "artist"
private const val NAME = "name"
private const val URL = "url"
private const val BIO = "bio"
private const val CONTENT = "content"

internal class JsonToArtistInfoResolver() :
    LastFmToArtistInfoResolver {

    override fun getArtistInfoFromExternalData(serviceData: String?): CardImpl? =
        try {
            serviceData?.getFirstResult()?.let { item ->
                CardImpl(
                    item.getArtistName(), item.getInfoContent(), item.getFullArticleUrl()
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

    private fun JsonObject.getArtistName(): String = this[NAME].asString

    private fun JsonObject.getInfoContent() =
            this[BIO]
                .asJsonObject[CONTENT]
                .asString.replace("\\n", "\n")


    private fun JsonObject.getFullArticleUrl() = this[URL].asString

}