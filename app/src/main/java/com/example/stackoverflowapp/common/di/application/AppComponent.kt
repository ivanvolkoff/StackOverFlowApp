package com.example.stackoverflowapp.common.di.application

import com.example.stackoverflowapp.common.di.activity.ActivityComponent
import com.example.stackoverflowapp.common.di.service.ServiceComponent
import com.example.stackoverflowapp.common.di.service.ServiceModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

   fun newActivityComponent(): ActivityComponent.Builder
   fun newServiceComponent(serviceModule: ServiceModule): ServiceComponent
}