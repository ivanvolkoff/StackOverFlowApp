package com.example.stackoverflowapp.common.di.application

import android.app.Application
import com.example.stackoverflowapp.common.di.activity.ActivityComponent
import com.example.stackoverflowapp.common.di.activity.ActivityModule
import com.example.stackoverflowapp.common.di.service.ServiceComponent
import com.example.stackoverflowapp.common.di.service.ServiceModule
import com.example.stackoverflowapp.networking.StackOverflowApi
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

   fun newActivityComponent(): ActivityComponent.Builder
   fun newServiceComponent(serviceModule: ServiceModule): ServiceComponent
}