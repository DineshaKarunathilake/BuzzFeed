package me.projects.buzzfeed.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import android.content.res.Resources
import java.io.BufferedReader
import java.io.InputStreamReader


class FeedRepository private constructor() {

    private var gson: Gson? = null
    private var feed = MutableLiveData<Feed?>()

    companion object {

        @Volatile
        private var instance: FeedRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FeedRepository().also { instance = it }
            }
    }

    fun getFeedData(): LiveData<Feed> {

        val gsonBuilder = GsonBuilder()
        gson = gsonBuilder.create()
        feed = MutableLiveData(gson?.fromJson(getFeedString(), Feed::class.java))

        return feed as LiveData<Feed>
    }

    private fun getFeedString(): String {
//
////        val file = "res/raw/feed.txt"
//        val file = "assets/feed.json"
//
//
//        val inputStream =
//            this.javaClass.classLoader.getResourceAsStream(file)
////        Resources.getSystem().assets.open("feed.json")
//
//        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
//        val feed = StringBuilder()
//        val line: String = ""
//        while (bufferedReader.readLine() != null) {
//            feed.append(line).append('\n')
//        }
//
//        return feed.toString()

        return "{\n" +
                "  \"name\": \"Headlines\",\n" +
                "  \"teasers\": [\n" +
                "    {\n" +
                "      \"title\": \"»Jeder einzelne Tag \\nmeines Lebens war schlecht\",\n" +
                "      \"text\": \"Wenn stimmt, was in ihrem Pass eingetragen ist, wird die Tschetschenin\n" +
                "      nächsten Monat 129 Jahre alt. Mit Dankbarkeit erfüllt sie das nicht.\",\n" +
                "      \"isPaid\": true,\n" +
                "      \"type\": \"teaser\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Palast veröffentlicht traurige\\nNachricht von Meghan\",\n" +
                "      \"text\": \"Jetzt ist es offiziell: Der Kensington-Palast veröffentlichte ein Statement der\n" +
                "      Braut. Ihr Vater kann nicht zur Hochzeit kommen.\",\n" +
                "      \"type\": \"teaser\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Buffon verlässt Juve\\nnach 17 Jahren\",\n" +
                "      \"text\": \"Eine Legende sagt „Arrivederci“ – aber verabschiedet sich noch nicht ganz vom\n" +
                "      Fußball. Buffon sprach von „reizvollen Angeboten“.\",\n" +
                "      \"type\": \"teaser\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"YouTuberin isst vom \\nAussterben bedrohte Tiere\",\n" +
                "      \"text\": \"Sie häutet, grillt und isst Schlangen, Haie, Eidechsen, wilde Katzen und seltene\n" +
                "      Vögel. Das bringt gutes Geld – jetzt aber auch richtig Ärger.\",\n" +
                "      \"type\": \"teaser\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Elton John singt für\\nMeghan und Harry!\",\n" +
                "      \"text\": \"Bei dieser Nachricht allein haben wir schon Pipi in den Augen, denn Elton John\n" +
                "      hat mit den Royals eine ganz besondere Beziehung.\",\n" +
                "      \"isPaid\": true,\n" +
                "      \"type\": \"teaser\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"„Es drohen noch\\nweitere Tornados!“\",\n" +
                "      \"text\": \"Der Tornado in Viersen (NRW) hat ein riesiges Chaos hinterlassen! BILD ließ sich\n" +
                "      vom Deutschen Wetterdienst den Tornado erklären.\",\n" +
                "      \"type\": \"teaser\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Patrick (32): „Darum sehe \\nich mir Webcam-Girls an“\",\n" +
                "      \"text\": \"Die Webcam-Branche boomt: Tausende Frauen stehen vor der Kamera und\n" +
                "      spielen mit den erotischen Fantasien der User. Die große Reportage.\",\n" +
                "      \"isPaid\": true,\n" +
                "      \"type\": \"teaser\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Caros Rosen-Rache\\nan Oliver!\",\n" +
                "      \"text\": \"Rache ist schön! 2015 ließ Bachelor Oliver Sanne Finalistin Caro im TV bitterböse\n" +
                "      abblitzen. Jetzt rächte sie sich bei „Bachelor in Paradise“.\",\n" +
                "      \"type\": \"teaser\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Sandro Wagner macht Schluss mit der Nationalelf!\",\n" +
                "      \"text\": \"So schnell hat selten jemand auf seine Nicht-Nominierung reagiert. Nach seinem\n" +
                "      WM-Aus macht Sandro Wagner Schluss mit der Nationalelf!\",\n" +
                "      \"isPaid\": true,\n" +
                "      \"type\": \"teaser\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"So international waren\\nInkas Bauern noch nie\",\n" +
                "      \"text\": \"Moderatorin Inka Bause hilft liebeshungrigen Landwirten aus Kanada und\n" +
                "      Luxemburg auf die Sprünge. BILD stellt sechs der 16 Bauern vor.\",\n" +
                "      \"isPaid\": true,\n" +
                "      \"type\": \"teaser\"\n" +
                "    }\n" +
                "  ]\n" +
                "}"
    }

}