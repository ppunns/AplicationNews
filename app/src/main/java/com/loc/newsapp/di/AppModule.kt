package com.loc.newsapp.di
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import android.app.Application
import com.loc.newsapp.domain.manger.LocalUserManger
import com.loc.newsapp.data.manger.LocalUserMangerImpl
import com.loc.newsapp.data.remote.dto.NewsApi
import com.loc.newsapp.data.repository.NewsRepositoryImpl
import com.loc.newsapp.domain.repository.NewsRepository
import dagger.Provides
import com.loc.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.loc.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.loc.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.loc.newsapp.domain.usecases.news.GetNews
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import com.loc.newsapp.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManger(application: Application):LocalUserManger = LocalUserMangerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCase(localUserManger: LocalUserManger) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )


    @Provides
    @Singleton
    fun provideNewsApi():NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ):NewsRepository = NewsRepositoryImpl(newsApi)



    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository):NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }

}