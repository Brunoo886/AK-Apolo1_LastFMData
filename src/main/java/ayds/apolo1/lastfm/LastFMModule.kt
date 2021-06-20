package ayds.apolo1.lastfm

import ayds.apolo1.lastfm.artistCard.JsonToArtistCardResolver
import ayds.apolo1.lastfm.artistCard.LastFMAPI
import ayds.apolo1.lastfm.artistCard.LastFMArtistInfoServiceImpl
import ayds.apolo1.lastfm.artistCard.LastFMToArtistCardResolver
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object LastFMModule {
    private const val URL_SERVICE = "https://ws.audioscrobbler.com/2.0/"

    private val lastFmAPIRetrofit = Retrofit.Builder()
        .baseUrl(URL_SERVICE)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val lastFMAPI = lastFmAPIRetrofit.create(LastFMAPI::class.java)
    private val lastFMToArtistCardResolver: LastFMToArtistCardResolver = JsonToArtistCardResolver()

    val lastFMArtistInfoService: LastFMArtistInfoService = LastFMArtistInfoServiceImpl(
        lastFMAPI,
        lastFMToArtistCardResolver
    )
}
