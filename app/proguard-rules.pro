# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to the flags specified
# in /usr/local/Cellar/android-sdk/..../proguard-android-optimize.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Preserve all annotations
-keepattributes *Annotation*

# Keep the main activity
-keep class com.example.loancalculator.MainActivity { *; }

# Keep all classes that extend AppCompatActivity
-keep public class * extends androidx.appcompat.app.AppCompatActivity
