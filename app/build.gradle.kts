plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.dudu.wearlauncher"
        minSdk = 19
        targetSdk = 33
        versionCode = 1
        versionName = "Chip"
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
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
        viewBinding = false // 设置为 false 禁用 ViewBinding
    }
}

dependencies {
    // AndroidX Libraries
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Retrofit for network operations
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Other UI libraries
    implementation("cn.Leaqi:SwipeDrawer:1.6")
    implementation("com.github.bumptech.glide:glide:4.13.2")

    // Multidex support
    implementation("androidx.multidex:multidex:2.0.1")

    // Utilities
    implementation("com.blankj:utilcodex:1.31.1")

    // Custom Project Libraries
    implementation(project(":watchface-dev-utils"))

    // Bugly for crash reporting
    implementation("com.tencent.bugly:crashreport:4.1.9")

    // Custom UI components
    implementation("com.github.fodroid:XRadioGroup:v1.5")

    // Local library
    implementation(files("./libs/overscroll.jar"))
}

repositories {
    google()
    mavenCentral()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
