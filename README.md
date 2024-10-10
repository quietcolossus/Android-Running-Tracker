# Android Running Tracker

## Description

**Android Running Tracker** is a native Android app built in Kotlin that tracks users' runs, displaying detailed analytics such as location data, average speed, distance, and altitude. The app allows users to activate tracking during their run and saves this data for future reference. Each run is tied to a specific user ID, enabling personalized run tracking and historical insights.

This project showcases advanced Android development techniques, clean architecture principles, and dynamic feature integration, built entirely using **Jetpack Compose** and following the **MVVM** (Model-View-ViewModel) design pattern.

## Key Features

- **Run Tracking**: Tracks user location in real-time, providing statistics like speed, distance, and altitude.
- **Analytics**: Provides detailed analytics for each saved run, including a map view of the running route.
- **Multi-Modular Architecture**: Organized into multiple modules for clear separation of concerns and scalability.
- **Dynamic Feature Delivery**: Analytics feature is dynamically installed on demand, demonstrating the use of Play Feature Delivery.
- **Data Persistence**: Utilizes Room for efficient local data storage and retrieval.
- **Dependency Injection**: Koin is used for streamlined dependency injection, reducing boilerplate and improving testability.
- **Modern Android UI**: Built entirely with Jetpack Compose for a declarative, reactive user interface.

## Technologies

- **Kotlin**: Entirely written in Kotlin for clean, modern Android development.
- **Jetpack Compose**: Provides a modern, declarative UI framework.
- **MVVM Architecture**: Ensures a clean separation between UI and business logic.
- **Room Database**: Used for local persistence of run data, ensuring fast and efficient storage and retrieval.
- **Koin**: Manages dependency injection, promoting modular design and easier testing.
- **Play Feature Delivery**: Demonstrates dynamic feature delivery by enabling the analytics feature to be installed only when required, reducing initial APK size.
- **Jetpack Components**: Utilizes Android Jetpack libraries such as LiveData and ViewModel for best practices in app architecture.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/android-running-tracker.git
   cd android-running-tracker
