plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.quietcolossus.analytics.presentation"
}

dependencies {

    implementation(projects.analytics.domain)
}