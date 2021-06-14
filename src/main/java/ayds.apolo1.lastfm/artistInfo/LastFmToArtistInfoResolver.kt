package ayds.apolo1.lastfm.lastFM.artistInfo

import android.util.Log
import com.google.gson.Gson
import ayds.apolo.songinfo.moredetails.model.entities.CardImpl
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

    private fun JsonObject.getArtistName(): String = this[ayds.apolo1.lastfm.lastFM.artistInfo.NAME].asString

    private fun JsonObject.getInfoContent() =
            this[ayds.apolo1.lastfm.lastFM.artistInfo.BIO]
                .asJsonObject[ayds.apolo1.lastfm.lastFM.artistInfo.CONTENT]
                .asString.replace("\\n", "\n")


    private fun JsonObject.getFullArticleUrl() = this[ayds.apolo1.lastfm.lastFM.artistInfo.URL].asString

}