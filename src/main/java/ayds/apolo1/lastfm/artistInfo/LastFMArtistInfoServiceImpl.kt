package ayds.apolo1.lastfm.artistInfo

import ayds.apolo1.lastfm.LastFMArtistInfoService
import ayds.apolo1.lastfm.entities.ArtistInfo
import retrofit2.Response

internal class LastFMArtistInfoServiceImpl(
    private val LastFMAPI: LastFMAPI,
    private val lastFMToArtistInfoResolver: LastFMToArtistInfoResolver,
) : LastFMArtistInfoService {

    override fun getArtistInfo(artistName: String): ArtistInfo? {
        val callResponse = getInfoFromService(artistName)
        return lastFMToArtistInfoResolver.getArtistInfoFromExternalData(callResponse.body())
    }

    private fun getInfoFromService(query: String): Response<String> {
        return LastFMAPI.getArtistInfo(query)
            .execute()
    }
}