package cl.antoinette.monitor_politico_econmico.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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
      .databaseBuilder(
         context,
         MonitorDatabase::class.java,
         DATABASE_NAME
      )
      .fallbackToDestructiveMigration() // this make me loose data
      // .addMigrations(MIGRATION_1_2) // this prevents data loose
      .build()

   @Singleton
   @Provides
   fun provideDiputadosDao(db: MonitorDatabase) = db.diputadosDao()

}

val MIGRATION_1_2 = object : Migration(
   1,
   2
) {
   override fun migrate(database: SupportSQLiteDatabase) {
      // database.execSQL(...) EXAMPLE
      /*
      Migration using temporary table

        // Remove first and last name column from profile
        // create new table
        database.execSQL("CREATE TABLE IF NOT EXISTS `profile_new` (`id` INTEGER NOT NULL, `nickName` TEXT NOT NULL, `bio` TEXT NOT NULL, PRIMARY KEY(`id`))")
        // create nickname if needed
        database.execSQL("UPDATE `profile` SET `nickName` = `firstName` || ' ' || `lastName` WHERE `nickName` IS NULL")
        // copy data to new table
        database.execSQL("INSERT INTO `profile_new` (`id`, `nickName`, `bio`) SELECT `id`, `nickName`, `bio` FROM `profile`")
        // remove the old table
        database.execSQL("DROP TABLE `profile`")
        // rename new table
        database.execSQL("ALTER TABLE `profile_new` RENAME TO `profile`")
      * */
   }
}
