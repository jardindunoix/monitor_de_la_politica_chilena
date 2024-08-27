package cl.antoinette.monitor_politico_econmico.di

import android.content.Context
import androidx.room.Room
import cl.antoinette.monitor_politico_econmico.data.database.room.MonitorDatabase
import cl.antoinette.monitor_politico_econmico.utilities.StaticUtils.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

   @Singleton
   @Provides
   fun providesRoom(
      @ApplicationContext
      context: Context
   ) = Room
      .databaseBuilder(context, MonitorDatabase::class.java, DATABASE_NAME)
      .build()

   @Singleton
   @Provides
   fun provideDiputadosDao(db: MonitorDatabase)= db.diputadosDao()
}