# Keep main entry points
-keep public class dev.spaxter.** { *; }

# Ignore warnings as dependencies are provided by the server
-ignorewarnings

# Keep annotations
-keepattributes *Annotation*

# Allow optimizations
-optimizations *
-optimizationpasses 5
-allowaccessmodification
-optimizeaggressively
-overloadaggressively

# Remove debugging information and unnecessary attributes
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-renamesourcefileattribute
-adaptclassstrings
