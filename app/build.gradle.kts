plugins {
   alias(libs.plugins.android.application)
   alias(libs.plugins.jetbrains.kotlin.android)
   //    added
   alias(libs.plugins.android.dagger.hilt)
//   alias(libs.plugins.ksp)


   id("kotlin-android")
   id("kotlin-kapt")

   /*
   id("com.android.application")
   id("org.jetbrains.kotlin.android")
   //    added
   id("kotlin-android")
   id("kotlin-kapt")
   id("dagger.hilt.android.plugin")
   */
}

android {
   namespace = "cl.antoinette.monitor_politico_econmico"
   compileSdk = 34

   defaultConfig {
      applicationId = "cl.antoinette.monitor_politico_econmico"
      minSdk = 28
      targetSdk = 34
      versionCode = 1
      versionName = "1.0"

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
   }

   buildTypes {
      debug {
         applicationIdSuffix = ".debug"
         isDebuggable = true
         isMinifyEnabled = false
      }
      release {
         isMinifyEnabled = true
         isDebuggable = false
         proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro"
         )
      }
   }

   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }

   kotlinOptions {
      jvmTarget = "1.8"
   }

   buildFeatures {
      buildConfig = true
      viewBinding = true
   }

   flavorDimensions += "version"
   productFlavors {
      create("MonitorPolitico") {
         resValue(
            "string",
            "app_name",
            "Monitor Politico"
         )
         applicationIdSuffix = ".MonitorPolitico"
         versionNameSuffix = "1_MonitorPolitico"
         buildConfigField(
            "String",
            "URL_BASE",
            "\"https://back.sellers-info.cl/api/charger/\""
         )
      }
   }

   //    no se si sirve
   hilt {
      enableAggregatingTask = true
   }
}

dependencies {
   implementation(libs.androidx.appcompat)

   //*splashscreen*//*
   implementation(libs.androidx.splash)
   //*navigation NO CAMBIAR LA VERSION "2.6.0" **************//*
   implementation(libs.androidx.navigation.fragment)
   implementation(libs.androidx.navigation.fragmentktx)
   implementation(libs.androidx.legacy)
   //*picasso*//*
   implementation(libs.androidx.picasso)
   // constraint layout
   implementation(libs.androidx.constraintlayout)
   //    coroutines
   implementation(libs.androidx.coroutines)
   implementation(libs.androidx.coroutinesandroid)
   //   coroutine lifecycle scopes
   implementation(libs.androidx.activityktx)
   implementation(libs.androidx.lifecyclesextensions)
   implementation(libs.androidx.lifecycle)
   // KTX - Viewmodel Y Livedata NO ACTUALIZAR: 2.5.1
   implementation(libs.androidx.lifecycle.livedata)
   //    data store
   implementation(libs.androidx.datastore)
   //    retrofit
   implementation(libs.androidx.retrofit)
   implementation(libs.androidx.retrofitgson)

   implementation(libs.googlegson)

   implementation(libs.okhttp)
   implementation(libs.okhttp.interceptor)
   //*implementacion para el carrousel*//*
   // Optional: Circle Indicator (To fix the xml preview "Missing classes" error)
   implementation(libs.circleindicator)
   implementation(libs.carrousel)
   //*material design*//*
   implementation(libs.materialgoogle)
   implementation(libs.jsoup)
   //Room
   implementation(libs.room)
   // kapt genera el codigo para la base de datos
   kapt(libs.roomkaptcompiler)
// migrating to ksp
   /* <><><><> *//* <><><><> *//* <><><><> *//* <><><><> */
   implementation(libs.androidx.core.ktx)
   implementation(libs.androidx.lifecycle.runtime.ktx)
   implementation(libs.androidx.activity.compose)
   implementation(platform(libs.androidx.compose.bom))
   implementation(libs.androidx.ui)
   implementation(libs.androidx.ui.graphics)
   implementation(libs.androidx.ui.tooling.preview)
   implementation(libs.androidx.material3)
// TEST unitarios
   testImplementation(libs.junit)

//   added tests MOKK y mockito
   testImplementation(libs.mokk)
   testImplementation(libs.mockitocore)
   testImplementation(libs.mockitoinline)
// TEST unitarios
   androidTestImplementation(libs.androidx.junit)
   androidTestImplementation(libs.androidx.espresso.core)
   androidTestImplementation(platform(libs.androidx.compose.bom))
   androidTestImplementation(libs.androidx.ui.test.junit4)

   debugImplementation(libs.androidx.ui.tooling)
   debugImplementation(libs.androidx.ui.test.manifest)


   //   dagger hilt
   implementation(libs.dagger.google)
   implementation(libs.androidx.hilt.navigation.compose.v120)
   annotationProcessor(libs.androidx.google.compiler)
   kapt(libs.androidx.google.dagger.kapt.android)
   kapt(libs.androidx.google.compiler)
   kapt(libs.androidx.hilt.compiler.v120)

   /*

    implementation("androidx.core:core-ktx:1.9.0")

    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")



//    implementation("androidx.room:room-runtime:$roomVersion")
    //Hilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    //    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    annotationProcessor("com.google.dagger:hilt-compiler:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")
    kapt("androidx.hilt:hilt-compiler:1.1.0")

*/

}

kapt { correctErrorTypes = true }