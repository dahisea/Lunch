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
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("cn.Leaqi:SwipeDrawer:1.6")
    implementation("com.github.bumptech.glide:glide:4.13.2")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("com.blankj:utilcodex:1.31.1")
    implementation(project(":watchface-dev-utils"))
    implementation("com.tencent.bugly:crashreport:4.1.9")
    implementation("com.github.fodroid:XRadioGroup:v1.5")
    implementation(files("./libs/overscroll.jar"))
}
