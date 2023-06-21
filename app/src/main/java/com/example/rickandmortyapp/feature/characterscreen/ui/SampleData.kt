package com.example.rickandmortyapp.feature.characterscreen.ui

data class Message(val img: String, val title: String, val description: String)
object SampleData {
    val listData = listOf(
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Test...Test...Test..."
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "It's available from API 21+ :)"
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Lexi",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}