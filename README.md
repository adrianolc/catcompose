# 🐱 CatCompose

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/9e26fd783e774515a033268513035550)](https://app.codacy.com/gh/adrianolc/catcompose/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)

**CatCompose** is a modern Android app built to demonstrate a clean, scalable, and pragmatic approach to app development using **Jetpack Compose**.  
It displays a list of cat breeds and detailed information for each one — serving as a showcase of **modular architecture**, **state management**, and **Compose-first UI design**.

## 📸 Screenshots

<img width="200" alt="Screenshot_20251023_105633" src="https://github.com/user-attachments/assets/9a2539c8-b103-4f53-ba63-3e2ba90d53fe" />
<img width="200" alt="Screenshot_20251023_110505" src="https://github.com/user-attachments/assets/9b920b99-84e4-4558-9cc5-f58c9cec41f7" />
<img width="200" alt="Screenshot_20251023_110522" src="https://github.com/user-attachments/assets/62604e16-9a71-4a3a-9ace-a08c4843af1f" />

## 🐾 Features

- Browse a list of cat breeds
- View detailed information about each breed
- Clean, reactive UI built entirely with **Jetpack Compose**
- Modular and scalable architecture for maintainable code
- Example of modern Android development best practices

## 💡 Why CatCompose?

CatCompose was created as a personal showcase project — a way to explore and apply **modern Android development** principles in a realistic setup.  
It focuses on **feature modularization**, **clean architecture**, and **Compose-based UI**, showing how to keep an app both elegant and easy to scale.

## 🏗️ Architecture

The project is designed with **maintainability** and **scalability** in mind, following **SOLID principles** and a **feature-first** approach.  
It keeps a clear separation between UI, state, and data, while staying flexible enough for real-world development.

- **UI**: Fully built with **Jetpack Compose**, using a declarative and reactive design. Composables are stateless and observe changes from the ViewModel.
- **State Management**: **ViewModels** manage and expose UI state using `StateFlow`, handling data loading and user actions.
- **Data Flow**: The UI observes the state from the ViewModel. User interactions trigger ViewModel functions, which communicate with repositories to fetch or update data.

## 🧩 Modularization

The codebase is organized into **feature-based modules**, helping reduce build times and improve separation of concerns.

- `:app` — The main application module. It integrates all features and handles high-level navigation and dependency injection.
- `:features:list` — Contains everything related to the cat breed list screen and its related components.
- `:features:details` — Handles the cat breed detail screen and its related components.

## 🛠️ Tech Stack & Key Libraries

CatCompose uses a modern Android stack for performance, readability, and ease of development:

- **[Kotlin](https://kotlinlang.org/)** — Primary language
- **[Jetpack Compose](https://developer.android.com/jetpack/compose)** — Declarative UI toolkit
- **[Hilt](https://dagger.dev/hilt/)** — Dependency injection
- **[Jetpack Navigation 3](https://developer.android.com/guide/navigation/navigation-3)** — For navigating between composable screens
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)** — Lifecycle-aware state management
- **[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)** & **[Flow](https://kotlinlang.org/docs/flow.html)** — For asynchronous and reactive data handling
- **[Retrofit](https://square.github.io/retrofit/)** — REST API client
- **[Coil](https://coil-kt.github.io/coil/)** — Lightweight image loading library

## 🚀 Getting Started

To build and run CatCompose:

1. Clone this repository
2. Open it in Android Studio
3. Let Gradle sync and download all dependencies
4. Run the app on an emulator or physical device

---

## 🎯 Summary

CatCompose is a focused demonstration of how to combine **Jetpack Compose**, **modular architecture**, and **clean code practices** into a cohesive Android project.  
It’s built as a learning and portfolio project — not just to show *what works*, but to explore *why* it works.
