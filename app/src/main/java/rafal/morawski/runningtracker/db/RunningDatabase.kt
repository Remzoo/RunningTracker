package rafal.morawski.runningtracker.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rafal.morawski.runningtracker.RunDAO

@Database(
    entities = [Run::class],
    version = 1
)
@TypeConverters(Coverters::class)
abstract class RunningDatabase : RoomDatabase() {

    abstract fun getRunDao(): RunDAO
}