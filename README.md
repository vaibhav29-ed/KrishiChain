# KrishiChain

KrishiChain is an Android blockchain‑enabled mobile application that lets farmers record and trace produce batches using QR codes. It stores batch data locally with Room and interacts with a backend via Retrofit, while leveraging Jetpack Compose for UI and Hilt for dependency injection.

## Overview

KrishiChain is a blockchain‑based mobile app that enables farmers to track and manage produce batches from farm to market with transparent, tamper‑proof records. Each batch is associated with a unique QR code for easy verification throughout the supply chain.

## Features

- QR code generation for each batch (see `BatchDetailScreen`).
- Create and view batch history (see `BatchHistoryScreen`).
- Transfer ownership of batches via API.
- Offline data persistence with Room.
- Mock API implementation for development and testing.
- Navigation between multiple role‑specific dashboards.
- Dependency injection with Hilt.
- Compose‑based UI with modern Android components.

## Architecture

The app follows a layered architecture:

1. **Presentation Layer** – Jetpack Compose screens and navigation (`KrishiChainAppNav`, `NavRoutes`).
2. **Domain Layer** – Simple data classes (`Batch`, `UserProfile`) and repository interfaces (`BatchRepository`, `UserProfileRepository`).
3. **Data Layer** – Room database (`AppDatabase`) with DAOs (`BatchDao`, `UserProfileDao`).
4. **Network Layer** – Retrofit `ApiService` with a `MockApi` fallback for local testing.
5. **Dependency Injection** – Hilt (`@HiltAndroidApp`, `@AndroidEntryPoint`).
6. **Application Entry** – `KrishiChainApp` extends `Application` and bootstraps Hilt.

This separation enables testability and clear responsibilities across the codebase.

## Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose
- **Dependency Injection:** Hilt
- **Local Database:** Room (with TypeConverters)
- **Networking:** Retrofit (with a `MockApi` implementation)
- **QR Code:** ZXing library
- **Image Loading:** Coil
- **Coroutines:** Kotlinx Coroutines
- **Testing:** JUnit, AndroidX Test, Compose UI testing

## Prerequisites

- Android SDK **minSdkVersion 24** and **targetSdkVersion 36**.
- Gradle build system (wrapper included in the repository).
- Java 17 compatible JDK (required by the Android toolchain).

## Installation

Installation instructions are not documented in the repository.

## API Reference

- **POST `/uploadBatch`** – Upload a new `Batch` object. Returns `ApiResponse` with transaction ID.
- **POST `/transferOwnership`** – Transfer a batch to another retailer. Body: `TransferRequest` (batchId, toRetailerId). Returns `ApiResponse`.
- **GET `/fetchBatch/{id}`** – Retrieve a batch by its ID. Returns a `Batch` or `null`.
- **POST `/simulateTx`** – Simulate a blockchain transaction for a batch. Body: `SimulateTxRequest` (batchId). Returns `ApiResponse`.

## Testing

The project includes an instrumented test (`ExampleInstrumentedTest.kt`) that verifies the application context. Tests can be executed with the Gradle command:

```
gradle test
```

The `testImplementation` dependency on JUnit is declared in the Gradle build file.
