package my.test.twich.app03_data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import my.test.twich.app03_data.db.GameDao
import my.test.twich.app03_data.db.GameDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
/*Эта аннотация сообщает Hilt, что зависимости,
предоставляемые через этот модуль, должны оставаться активными,
пока приложение работает.
PS: здесть ранее был ApplicationComponent (устарел), такой коментарий говорит нам, что последующий
модуль будет доступен для полного жизненного цикла приложения, а не только для некоторых Activity
или Fragment. Как и класс ApplicationComponent, у нас есть классы ActivityComponent
и FragmentComponent, а также для области жизненного цикла действий и фрагментов.*/
@Module
/*Эта аннотация сообщает Hilt, что этот класс вносит вклад
в граф объекта внедрения зависимостей.*/
class DatabaseModule {

    @Provides
            /*Эта аннотация отмечает метод provideGameDao как поставщик GameDao.*/
    fun provideGameDao(gameDatabase: GameDatabase): GameDao {
        return gameDatabase.gameDao()
    }

    @Provides
    @Singleton
            /*Аннотация @Singleton сообщает Hilt, что GameDatabase следует инициализировать только один раз.
            И один и тот же экземпляр должен предоставляться каждый раз, когда его нужно вводить.*/
    fun provideGameDatabase(@ApplicationContext appContext: Context): GameDatabase {
        /*@ApplicationContext позволяет Hilt предоставлять контекст приложения
        без необходимости явно указывать, как его получить.*/
        return Room.databaseBuilder(
            appContext,
            GameDatabase::class.java,
            "GameReader"
        ).allowMainThreadQueries().build()
    }
}