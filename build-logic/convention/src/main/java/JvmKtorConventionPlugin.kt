import com.android.build.gradle.LibraryExtension
import com.quietcolossus.convention.ExtensionType
import com.quietcolossus.convention.configureBuildTypes
import com.quietcolossus.convention.configureKotlinAndroid
import com.quietcolossus.convention.configureKotlinJvm
import com.quietcolossus.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class JvmKtorConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")

            dependencies {
                "implementation"(libs.findBundle("ktor").get())
            }
        }
    }
}