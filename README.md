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

## Install [![](https://jitpack.io/v/lamba92/ktor-cors-any.svg)](https://jitpack.io/#lamba92/ktor-cors-any)

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