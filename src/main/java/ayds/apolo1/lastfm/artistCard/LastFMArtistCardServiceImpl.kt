package ayds.apolo1.lastfm.artistCard

import ayds.apolo1.lastfm.LastFMArtistCardService
import ayds.apolo1.lastfm.entities.CardImpl
import retrofit2.Response

internal class LastFMArtistCardServiceImpl(
    private val LastFMAPI: LastFMAPI,
    private val lastFMToArtistCardResolver: LastFMToArtistCardResolver,
) : LastFMArtistCardService {

    override fun getArtistCard(artistName: String): CardImpl? {
        val callResponse = getInfoFromService(artistName)
        return lastFMToArtistCardResolver.getArtistCardFromExternalData(callResponse.body())
    }

    private fun getInfoFromService(query: String): Response<String> {
        return LastFMAPI.getArtistInfo(query)
            .execute()
    }
}