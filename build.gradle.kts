// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
//   added
    alias(libs.plugins.android.dagger.hilt) apply false
    alias(libs.plugins.android.library) apply false

//    alias(libs.plugins.ksp) apply false
    /*
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    //added
    id("com.android.library") version "8.1.2" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
    id("com.google.dagger.hilt.android") version "2.45" apply false
    */
}
