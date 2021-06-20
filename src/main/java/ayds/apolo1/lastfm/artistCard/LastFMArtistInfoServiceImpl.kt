package ayds.apolo1.lastfm.artistCard

import ayds.apolo1.lastfm.LastFMArtistInfoService
import ayds.apolo1.lastfm.entities.ArtistInfo
import retrofit2.Response

internal class LastFMArtistInfoServiceImpl(
    private val LastFMAPI: LastFMAPI,
    private val lastFMToArtistCardResolver: LastFMToArtistCardResolver,
) : LastFMArtistInfoService {

    override fun getArtistCard(artistName: String): ArtistInfo? {
        val callResponse = getInfoFromService(artistName)
        return lastFMToArtistCardResolver.getArtistCardFromExternalData(callResponse.body())
    }

    private fun getInfoFromService(query: String): Response<String> {
        return LastFMAPI.getArtistInfo(query)
            .execute()
    }
}