package ayds.apolo1.lastfm

import ayds.apolo.songinfo.moredetails.model.repository.external.lastFM.artistInfo.*
import ayds.apolo1.lastfm.artistInfo.LastFMAPI
import ayds.apolo1.lastfm.lastFM.artistInfo.JsonToArtistInfoResolver
import ayds.apolo1.lastfm.lastFM.artistInfo.LastFMArtistInfoServiceImpl
import ayds.apolo1.lastfm.lastFM.artistInfo.LastFmToArtistInfoResolver
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
