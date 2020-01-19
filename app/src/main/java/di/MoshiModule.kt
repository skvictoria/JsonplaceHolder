package di

import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import dagger.Module
import dagger.Provides
import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import javax.inject.Singleton

@Module
class MoshiModule{

    class MoshiModelAdapters{
        @FromJson
        fun localDate(value: String): LocalDate = try{
            LocalDate.parse(value)
        }catch (e: DateTimeParseException){
            LocalDate.parse(value, DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        }
        @ToJson
        fun localDateToJson(localDate: LocalDate): String = localDate.toString()

        @FromJson
        fun instant(value:String): Instant = Instant.parse(value)

        @ToJson
        fun instantToJson(instant: Instant): String = instant.toString()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(MoshiModelAdapters())
        .build()
}