# Shape Game

Shape Game is an educational app designed to help users learn and recognize different shapes through quizzes and interactive gameplay.

## Features

- **Quiz Mode**: Answer multiple-choice questions to test your shape knowledge.
- **Levels**: Choose from Grade 1, Grade 2, or Grade 3 to match your learning level.
- **Settings**: Personalize the app by adjusting volume and preferences.
- **Results Screen**: See your score and track your progress.
- **Pause Functionality**: Pause the quiz whenever you need a break.

## Screens

- **Levels Screen**: Select your grade level to start the quiz.
- **Quiz Screen**: Answer shape-related questions with the help of visual aids.
- **Settings Screen**: Manage your preferences such as volume.
- **Results Screen**: View your final score and return to the main menu.

## Technologies

- **Kotlin**: The main programming language used for development.
- **Jetpack Compose**: Used to create the app's user interface.
- **Gradle**: The build system.
- **Android MediaPlayer**: For adding sound effects.

## How to Run

1. **Clone the repository**:
    ```bash
    git clone https://github.com/potato-mush/shape-game.git
    ```

2. Open the project in [Android Studio](https://developer.android.com/studio).

3. Build and run the app on your emulator or a physical device.

## Adding Sound Effects

1. Place your sound files in the `res/raw` directory.

2. Use `MediaPlayer` to play sounds in the app. Example:
    ```kotlin
    val mediaPlayer = MediaPlayer.create(context, R.raw.sound_file)
    mediaPlayer.start()
    ```

## Contributing

We welcome contributions! Feel free to submit issues or pull requests to improve the app.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
