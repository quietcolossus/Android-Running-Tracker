# Android Running Tracker

## Description

**Android Running Tracker** is a native Android app built in Kotlin that tracks users' runs, displaying detailed analytics such as location data, average speed, distance, and altitude. The app allows users to activate tracking during their run and saves this data for future reference. Each run is tied to a specific user ID, enabling personalized run tracking and historical insights.

This project showcases various modern Android development techniques, clean architecture, SOLID principles, and dynamic feature integration. Built entirely using **Jetpack Compose** and following the **MVVM** (Model-View-ViewModel) design pattern.

## Key Features & Technologies

- **Run Tracking**: Tracks user location in real-time, providing statistics like speed, distance, and altitude.
- **Analytics**: Provides detailed analytics for each saved run, including a map view of the running route.
- **Multi-Modular Architecture**: Organized into multiple modules for clear separation of concerns and scalability.
- **Dynamic Feature Delivery**: Analytics feature is dynamically installed on demand, demonstrating the use of Play Feature Delivery.
- **Offline First**: Utilizes Room for data persistence and efficient local data storage and retrieval.
- **Dependency Injection**: Koin is used for streamlined dependency injection, reducing boilerplate and improving testability.
- **Modern Android UI**: Built entirely with Jetpack Compose for a declarative, reactive user interface.
- **Gradle Convention Plugins**: Follows standardized build logic with Gradle convention plugins, ensuring a consistent and maintainable build configuration across modules.
- **Google Maps API Integration**: Displays the running route on a map, leveraging Google Maps for visualizing user paths and locations.


## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/android-running-tracker.git
   cd android-running-tracker
