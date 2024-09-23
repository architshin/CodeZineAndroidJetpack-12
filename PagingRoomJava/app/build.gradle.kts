plugins {
	alias(libs.plugins.android.application)
}

android {
	namespace = "com.websarva.wings.android.pagingroomjava"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.websarva.wings.android.pagingroomjava"
		minSdk = 24
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
	buildFeatures {
		viewBinding = true
	}
}

dependencies {
	implementation(libs.paging.runtime)
	implementation(libs.room.runtime)
	annotationProcessor(libs.androidx.room.compiler)
	implementation(libs.room.paging)

	implementation(libs.appcompat)
	implementation(libs.material)
	implementation(libs.activity)
	implementation(libs.constraintlayout)
	testImplementation(libs.junit)
	androidTestImplementation(libs.ext.junit)
	androidTestImplementation(libs.espresso.core)
}