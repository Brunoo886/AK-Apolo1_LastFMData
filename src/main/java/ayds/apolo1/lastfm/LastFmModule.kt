package ayds.apolo1.lastfm

import ayds.apolo1.lastfm.artistInfo.LastFMAPI
import ayds.apolo1.lastfm.artistInfo.JsonToArtistInfoResolver
import ayds.apolo1.lastfm.artistInfo.LastFMArtistInfoServiceImpl
import ayds.apolo1.lastfm.artistInfo.LastFmToArtistInfoResolver
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object LastFmModule {
    private const val URL_SERVICE = "https://ws.audioscrobbler.com/2.0/"

    private val lastFmAPIRetrofit = Retrofit.Builder()
        .baseUrl(URL_SERVICE)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val lastFmAPI = lastFmAPIRetrofit.create(LastFMAPI::class.java)
    private val lastFmToArtistInfoResolver: LastFmToArtistInfoResolver = JsonToArtistInfoResolver()

    val lastFMArtistInfoService: LastFMArtistInfoService = LastFMArtistInfoServiceImpl(
        lastFmAPI,
        lastFmToArtistInfoResolver
    )
}
