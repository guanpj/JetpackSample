plugins {
    if (isModule) {
        id("com.android.application")
    } else {
        id("com.android.library")
    }
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.me.guanpj.module_city"
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
        //consumerProguardFiles(arrayOf("consumer-rules.pro"))
    }

    sourceSets["main"].manifest {
        if (isModule) {
            srcFile("src/main/module/AndroidManifest.xml")
        } else {
            srcFile("src/main/AndroidManifest.xml")
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
    implementation("com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava")

    implementation(project(":appbase"))

    implementation(Libs.arouter_api)
    implementation(Libs.arouter_compiler)
}