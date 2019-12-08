package me.projects.buzzfeed.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.google.gson.Gson





//class HeadlineRepository private constructor (private val headlineDao: HeadlineDao) {
//
//    fun getHeadlineData() = headlineDao.getHeadlineData()
//
//    companion object {
//
//        @Volatile private var instance: HeadlineRepository? = null
//
//        fun getInstance(quoteDao: HeadlineDao) =
//            instance ?: synchronized(this) {
//                instance ?: HeadlineRepository(quoteDao).also { instance = it }
//            }
//    }
//
//}

class HeadlineRepository private constructor () {

    private var gson: Gson? = null
    private var headline = MutableLiveData<Headline?>()

    companion object {

        @Volatile private var instance: HeadlineRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: HeadlineRepository().also { instance = it }
            }
    }

    fun getHeadlineData(): LiveData<Headline> {

//        val headlineSring: String = androidContext.assets.open("headline.json").bufferedReader().use {it.readText()}

        val gsonBuilder = GsonBuilder()
        gson = gsonBuilder.create()

        headline =  MutableLiveData(gson?.fromJson(getHeadlineString(), Headline::class.java))

        return headline as LiveData<Headline>
    }

    fun getHeadlineString(): String {
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