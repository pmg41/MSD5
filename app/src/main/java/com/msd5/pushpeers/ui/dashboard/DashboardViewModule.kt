package com.msd5.pushpeers.ui.dashboard
import android.app.Activity
import com.msd5.pushpeers.ui.dashboard.DashboardActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@InstallIn(ActivityComponent::class)
@Module
object DashboardViewModule {

    @Provides
    fun bindActivity(activity: Activity): DashboardActivity {
        return activity as DashboardActivity
    }

//    @Provides
//    fun categoryAdapter(): MovieCategoryAdapter {
//        return MovieCategoryAdapter()
//    }
//
//    @Provides
//    fun movieAdapter(): MovieAdapter {
//        return MovieAdapter()
//    }
//
//    @Provides
//    fun searchAdapter(): SearchMovieAdapter {
//        return SearchMovieAdapter()
//    }
}
