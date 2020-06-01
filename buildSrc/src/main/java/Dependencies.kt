
object Versions {
    const val compile_sdk = 29
    const val build_tools = "29.0.3"
    const val min_sdk = 25
    const val target_sdk = 29
    const val nav_components = "2.3.0-beta01"
    const val material = "1.2.0-beta01"
    const val room = "2.2.5"
    const val appcompat = "1.1.0"
    const val core_ktx = "1.3.0"
    const val constraint_layout = "1.1.3"
    const val legacy_support = "1.0.0"
    const val lifecycle = "2.2.0"
    const val recyclerview = "1.1.0"
}

object Dependencies {
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_components}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_components}"
    const val material_design = "com.google.android.material:material:${Versions.material}"
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val legacy_support = "androidx.legacy:legacy-support-v4:${Versions.legacy_support}"
    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
}

object Application {
    const val id = "com.john.seiri"
    const val version_code = 1
    const val version_name = "Alpha 0.1"
    const val test_instrumentation = "androidx.test.runner.AndroidJUnitRunner"
}