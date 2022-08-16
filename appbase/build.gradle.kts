plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.me.guanpj.appbase"
    compileSdk = 32

    defaultConfig {
        minSdk = 24
        targetSdk = 32

        kapt {
            arguments {
                arg("AROUTER_MODULE_NAME", project.name)
            }
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        isEnabled = true
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation(files(arrayOf("libs/pinyin4j-2.5.0.jar")))

    api(Libs.livedata_ktx)
    api(Libs.viewmodel_ktx)
    api(Libs.viewmodel)
    api(Libs.fragment_ktx)

    api(Libs.retofit)
    api(Libs.converter_gson)
    api(Libs.logging_interceptor)
    api(Libs.coroutines)
    api(Libs.coroutines_android)
    implementation(Libs.arouter_api)
    implementation(Libs.arouter_compiler)
}