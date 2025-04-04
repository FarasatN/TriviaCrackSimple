plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    //id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

android {
    namespace = "com.farasatnovruzov.triviacracksimple"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.farasatnovruzov.triviacracksimple"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    //    composeCompiler {
//        enableStrongSkippingMode = true
//    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//    implementation(libs.androidx.runtime.livedata)

    //Material Icons
    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.core.android)
    implementation(libs.androidx.material.icons.extended)

    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.android.compiler)
    ksp(libs.androidx.hilt.compiler)
    //if you"re not using ksp, change it as follows
    //kapt("com.google.dagger:hilt-android-compiler:2.52")

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

//    //Ktor
//    implementation(libs.ktor.client.android)
//    implementation( libs.ktor.client.json)
//    implementation( libs.ktor.client.serialization)
//    implementation( libs.ktor.client.logging)

    //Lifecycle
//    val arch_version = "2.2.0"
    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // ViewModel utilities for Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
//    // LiveData
//    implementation(libs.androidx.lifecycle.livedata.ktx)
    // Lifecycles only (without ViewModel or LiveData)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    // Lifecycle utilities for Compose
    implementation(libs.androidx.lifecycle.runtime.compose)
    // Saved state module for ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    // Annotation processor
    ksp(libs.androidx.lifecycle.compiler)

//    // alternately - if using Java8, use the following instead of lifecycle-compiler
//    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
//    // optional - helpers for implementing LifecycleOwner in a Service
//    implementation("androidx.lifecycle:lifecycle-service:$lifecycle_version")
//    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
//    implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")
//    // optional - ReactiveStreams support for LiveData
//    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version")
//    // optional - Test helpers for LiveData
//    testImplementation("androidx.arch.core:core-testing:$arch_version")
//    // optional - Test helpers for Lifecycle runtime
//    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")

    //Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

//    //WorkManager
//    // Kotlin + coroutines
//    implementation(libs.androidx.work.runtime.ktx)
//    // optional - GCMNetworkManager support
//    implementation(libs.androidx.work.gcm)
//    // optional - Multiprocess support
//    implementation(libs.androidx.work.multiprocess)

    //Data Store
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore.preferences.core)

    //Navigation Compose
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.runtime.ktx)

//    //Easy Navigation Library
//    implementation(libs.core)
//    ksp(libs.ksp)
//// V2 only: for bottom sheet destination support, also add
//    implementation(libs.bottom.sheet)

//    //Lottie Animation
//    implementation(libs.lottie)
//    implementation(libs.lottie.compose)

//    // Room dependencies with KSP
//    implementation(libs.androidx.room.runtime)
//    ksp(libs.androidx.room.compiler)
//    implementation(libs.androidx.room.ktx)

}

//ksp{
//    correctErrorTypes = true
//}