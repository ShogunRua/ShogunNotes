plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.shogunrua.shogunnotesapp"
        minSdk = 24
        targetSdk = 32
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
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources.excludes += "META-INF/LICENSE*"
        resources.excludes += "META-INF/NOTICE.txt"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":data"))
    implementation(project(":domain"))

    //Compose Version
    val composeVersion = "1.1.1"

    //Kapt
    val roomVersion = "2.3.0"
    val daggerHilt = "2.37"
    val hilt = "1.0.0"

    api("androidx.core:core-ktx:1.7.0")
    api("androidx.appcompat:appcompat:1.4.1")
    api("com.google.android.material:material:1.5.0")
    api("androidx.compose.ui:ui:$composeVersion")
    api("androidx.compose.material:material:$composeVersion")
    api("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    api("androidx.activity:activity-compose:1.4.0")

    //Test
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

    // Compose dependencies
    api("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0-alpha06")
    api("androidx.navigation:navigation-compose:2.5.0-alpha04")
    api("androidx.compose.material:material-icons-extended:$composeVersion")
    api("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    //Dagger - Hilt
    api("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHilt")
    api("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:$hilt")

    // Room
    api("androidx.room:room-runtime:$roomVersion")
    api("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:2.4.2")
    kapt("android.arch.persistence.room:compiler:1.1.1")

    // Kotlin Extensions and Coroutines support for Room
    api("androidx.room:room-ktx:2.4.2")
}
