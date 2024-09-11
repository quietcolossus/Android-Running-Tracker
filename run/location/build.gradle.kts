plugins {
    alias(libs.plugins.runique.android.library)

//    alias(libs.plugins.android.library)
//    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.quietcolossus.run.location"
}

dependencies {
    implementation(libs.androidx.core.ktx)

    implementation(libs.bundles.koin)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)

    implementation(projects.core.domain)
    implementation(projects.run.domain)
}