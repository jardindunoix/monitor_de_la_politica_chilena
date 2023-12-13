plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //    added
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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
            resValue("string", "app_name", "Monitor Politico")
            applicationIdSuffix = ".MonitorPolitico"
            versionNameSuffix = "1_MonitorPolitico"
            buildConfigField("String", "URL_BASE", "\"https://back.sellers-info.cl/api/charger/\"")
        }
    }
}

dependencies {
    val navVersion = "2.6.0"
    val picassoVersion = "2.71828"
    val lifecycleVersion = "2.6.2"
    val retrofitVersion = "2.9.0"
    val roomVersion = "2.6.1"
    val coroutinesVersion = "1.7.3"
    val daggerHiltVersion = "2.48"
    val animation = "2.4@aar"
    val materialVersion = "1.10.0"
    val jsoupVersion = "1.13.1"
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    /*splashscreen*/
    implementation("androidx.core:core-splashscreen:1.0.1")
    /*navigation NO CAMBIAR LA VERSION "2.6.0" **************/
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    /*picasso*/
    implementation("com.squareup.picasso:picasso:$picassoVersion")
    // constraint layout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //    coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    //   coroutine lifecycle scopes
    implementation("androidx.activity:activity-ktx:1.8.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    // KTX - Viewmodel Y Livedata NO ACTUALIZAR: 2.5.1
    implementation("androidx.lifecycle:lifecycle-livedata-ktx: 2.5.1")
    //    data store
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    //    retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
    //Room
    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    //Hilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    //    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    annotationProcessor("com.google.dagger:hilt-compiler:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")
    kapt("androidx.hilt:hilt-compiler:1.1.0")
    /*implementacion para el carrousel*/
    // Optional: Circle Indicator (To fix the xml preview "Missing classes" error)
    implementation("me.relex:circleindicator:2.1.6")
    implementation("org.imaginativeworld.whynotimagecarousel:whynotimagecarousel:1.3.0")
    // animation
    implementation("com.daimajia.easing:library:$animation")
    implementation("com.daimajia.androidanimations:library:$animation")
    /*material design*/
    implementation("com.google.android.material:material:$materialVersion")
    /* implementation("org.jsoup:jsoup:$jsoup_version")*/
    implementation("org.jsoup:jsoup:$jsoupVersion")
}

kapt { correctErrorTypes = true }