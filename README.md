# Android library - Last FM
A simple android library to fetch info from Last FM's API

With just an artist's name you can obtain an ArtistInfo object containing the info below:
- A brief description of the artist provided
- The URL of the artist's full article on Last FM's web page
- The URL of Last FM's logo image
- A field named 'source', indicating the source of the info, in this case Last FM

## Usage
To get new info use the method ```'getArtistInfo(artistname)'``` from class ```'LastFMArtistInfoService'``` :
- val artistInfoService = LastFMModule.lastFMArtistInfoService
- artistInfoService.getArtistInfo(artistName)

If the API finds a matching artist, the info from said artist is retreived as an ArtistInfo object.

If there is no artist with the required name or no internet connection, null is returned instead.

## Installation
To add this library to your project, follow these steps:

1) Add the library to your libs folder

2) Add the following lines to your settings.graddle file, to specify the library's path:
	- include ':lastfmdata'    
	- project(':lastfmdata').projectDir = new File('libs/LastFMData')

3) Syncronize with 'Sync now'

4) Add the following line to your build.graddle file:
	- implementation project("lastfmdata")

5) Lastly, syncronize with 'Sync now' once more.
