package ayds.apolo1.lastfm.artistInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * An interface to perform GET requests to LastFM's API
 */
public interface LastFMAPI {

    /**
     * The function to perform GET requests
     * @param artist the artist's name
     * @return the API's response
     */
    @GET("?method=artist.getinfo&api_key=0a657854db69e551c97d541ca9ebcef4&format=json")
    Call<String> getArtistInfo(@Query("artist") String artist);

}