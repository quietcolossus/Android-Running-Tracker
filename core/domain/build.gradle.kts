plugins {
    alias(libs.plugins.runique.jvm.library)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.play.services.basement)
}