# Ktor CORS Any

Pretty straight forward:
```kotlin
install(CORS) {
    anyMethod()
    anyHeader()
    anyHost() // <-- that's already inside Ktor libs
    any() // <-- all the 3 above.
}
```

## Install 
```kotlin
repositories {
    maven(url="https://jitpack.io")
}
```
```kotlin
dependencies {
    implementation("com.github.lamba92", "ktor-cors-any", "1.0.0")
}
```