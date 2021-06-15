package ayds.apolo1.lastfm.artistInfo

import ayds.apolo1.lastfm.LastFMArtistInfoService
import ayds.apolo1.lastfm.entities.CardImpl
import retrofit2.Response

internal class LastFMArtistInfoServiceImpl(
    private val LastFMAPI: LastFMAPI,
    private val lastFmToArtistInfoResolver: LastFmToArtistInfoResolver,
) : LastFMArtistInfoService {

    override fun getArtistInfo(artistName: String): CardImpl? {
        val callResponse = getInfoFromService(artistName)
        return lastFmToArtistInfoResolver.getArtistInfoFromExternalData(callResponse.body())
    }

    private fun getInfoFromService(query: String): Response<String> {
        return LastFMAPI.getArtistInfo(query)
            .execute()
    }
}