package rafal.morawski.runningtracker.di

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped
import rafal.morawski.runningtracker.R
import rafal.morawski.runningtracker.other.Constants
import rafal.morawski.runningtracker.ui.MainActivity

@Module
@InstallIn(ServiceComponent::class)
object ServiceModule {

    @ServiceScoped
    @Provides
    fun provideFusedLocationProviderClient(@ApplicationContext appContext: Context) =
        FusedLocationProviderClient(appContext)

    @ServiceScoped
    @Provides
    fun provideMainActivityPendingIntent(@ApplicationContext appContext: Context) =
        PendingIntent.getActivity(
            appContext,
            0,
            Intent(appContext, MainActivity::class.java).also {
                it.action = Constants.ACTION_SHOW_TRACKING_FRAGMENT
            },
            PendingIntent.FLAG_UPDATE_CURRENT
        )

    @ServiceScoped
    @Provides
    fun provideBaseNotificationBuilder(
        @ApplicationContext appContext: Context,
        pendingIntent: PendingIntent
    ) = NotificationCompat.Builder(appContext, Constants.NOTIFICATION_CHANNEL_ID)
        .setAutoCancel(false)
        .setOngoing(true)
        .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
        .setContentTitle("Running App")
        .setContentText("00:00:00")
        .setContentIntent(pendingIntent)
}