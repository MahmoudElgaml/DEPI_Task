import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.UserData
import com.example.room.user

@Database(entities = [user::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): UserData

    companion object {
        private var instance: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                val localInstance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java, "user_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                instance = localInstance
                localInstance
            }
        }
    }
}
