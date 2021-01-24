package rafal.morawski.runningtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Dao
import dagger.hilt.android.AndroidEntryPoint
import rafal.morawski.runningtracker.db.RunDAO
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var runDao: RunDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("rundao", "onCreate: runDao ${runDao.hashCode()}")
    }
}