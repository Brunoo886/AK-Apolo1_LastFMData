package ayds.apolo1.lastfm.artistInfo

import android.util.Log
import ayds.apolo1.lastfm.entities.ArtistInfo
import ayds.apolo1.lastfm.entities.LastFMArtistInfo
import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * The interface of an info resolver that converts the API's responses into ArtistInfo objects
 * @property ARTISTS the property of the API response containing the artist's info
 * @property URL the property of the artist JSON object containing the artist's full article URL
 * @property BIO the property of the artist JSON object containing the artist's bio
 * @property CONTENT the property of the bio JSON object containing the artist's bio content
 * @property SOURCE_LOGO_URL the property of the artist JSON object containing the LastFM's logo image URL
 */
interface LastFMToArtistInfoResolver {
    /**
     * Converts the response's body into an ArtistInfo object
     * @param serviceData the response's body
     * @return the object representing the artist's data, it is null if the query has no result
     */
    fun getArtistInfoFromExternalData(serviceData: String?): ArtistInfo?
}

private const val ARTISTS = "artist"
private const val URL = "url"
private const val BIO = "bio"
private const val CONTENT = "content"
private const val SOURCE_LOGO_URL =
    "https://upload.wikimedia.org/wikispedia/commons/thumb/d/d4/Lastfm_logo.svg/320px-Lastfm_logo.svg.png"

internal class JsonToArtistInfoResolver :
    LastFMToArtistInfoResolver {

    override fun getArtistInfoFromExternalData(serviceData: String?): ArtistInfo? =
        try {
            serviceData?.getFirstResult()?.let { item ->
                LastFMArtistInfo(
                    description = item.getInfoContent(),
                    infoUrl = item.getFullArticleUrl(),
                    sourceLogoUrl = SOURCE_LOGO_URL,
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