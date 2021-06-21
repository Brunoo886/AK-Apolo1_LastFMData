package ayds.apolo1.lastfm.artistInfo

import ayds.apolo1.lastfm.LastFMArtistInfoService
import ayds.apolo1.lastfm.entities.ArtistInfo
import retrofit2.Response


/**
 * An implementation for the external service
 * @property LastFMAPI the interface to perform GET requests
 * @property lastFMToArtistInfoResolver a class to convert the API's responses into ArtistInfo objects
 */
internal class LastFMArtistInfoServiceImpl(
    private val LastFMAPI: LastFMAPI,
    private val lastFMToArtistInfoResolver: LastFMToArtistInfoResolver,
) : LastFMArtistInfoService {

    /**
     * Method implementation
     */
    override fun getArtistInfo(artistName: String): ArtistInfo? {
        val callResponse = getInfoFromService(artistName)
        return lastFMToArtistInfoResolver.getArtistInfoFromExternalData(callResponse.body())
    }

    /**
     * Calls the API interface
     * @param query the artist's name
     * @return the API's response
     */
    private fun getInfoFromService(query: String): Response<String> {
        return LastFMAPI.getArtistInfo(query)
            .execute()
    }
}