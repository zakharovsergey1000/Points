package com.example.graph.di

import com.example.graph.ui.point.PointsFragment
import com.example.graph.ui.search.SearchFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeRepoFragment(): PointsFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}
