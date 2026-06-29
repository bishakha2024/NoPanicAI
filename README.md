# 🚀 NoPanicAI

An AI-powered Android note-taking application built with **Kotlin**, **Jetpack Compose**, **Firebase**, and **Google Gemini API**.

NoPanicAI allows users to securely save notes in the cloud and generate AI-powered summaries of their notes with one click.

---

# 📱 Features

✅ User Authentication (Sign Up & Login)

✅ Secure Cloud Storage using Firebase Firestore

✅ Create and Save Notes

✅ View All Saved Notes

✅ AI-Powered Note Summaries using Gemini API

✅ Persistent Login (Stay Logged In)

✅ Modern UI built with Jetpack Compose

---

# 🛠 Tech Stack

- Kotlin
- Android Studio
- Jetpack Compose
- Firebase Authentication
- Cloud Firestore
- Gemini API
- Kotlin Coroutines
- Material Design 3

---

# 📂 Project Structure

```text
app/
├── model/
│   └── Note.kt
├── screens/
│   ├── LoginScreen.kt
│   ├── HomeScreen.kt
│   ├── AddNotesScreen.kt
│   ├── ViewNotesScreen.kt
│   └── SummaryScreen.kt
├── services/
│   └── GeminiService.kt
└── MainActivity.kt
```

---

# ⚡ App Workflow

### 1. User Authentication
- Create a new account.
- Login using email and password.
- Firebase Authentication securely manages users.

### 2. Create Notes
- Users can add notes.
- Notes are stored in Firebase Firestore.

### 3. View Notes
- Users can view all saved notes.
- Data is loaded directly from Firestore.

### 4. Generate AI Summary
- User selects a note.
- App sends note content to Gemini API.
- Gemini returns a short summary in bullet points.

---

# 🧠 Gemini API Integration

The application integrates Google's Gemini API to generate intelligent summaries of notes.

Example Prompt:

```text
Summarize shortly in 3 bullet points:
```

---

# 🔥 Firebase Services Used

### Firebase Authentication
- User Registration
- User Login
- Session Management

### Cloud Firestore
- Save Notes
- Retrieve Notes
- Cloud Data Storage

---

# 🖥 Screens

### Login Screen
- Email Authentication
- Account Creation

### Home Screen
- Navigate to Features

### Add Notes Screen
- Add and Save Notes

### View Notes Screen
- Display Saved Notes

### Summary Screen
- Generate AI Summary

---

# 🎯 Learning Outcomes

This project demonstrates:

- Android Development using Kotlin
- Modern UI Development with Jetpack Compose
- Firebase Authentication
- Cloud Firestore Database
- REST API Integration
- Asynchronous Programming with Coroutines
- Clean Project Structure
- State Management in Compose

---

# 🚀 Future Improvements

- Edit Notes
- Delete Notes
- Dark Mode
- Search Notes
- Voice Notes
- Export Notes as PDF
- Offline Mode
- AI Chat Assistant

---

# 📸 Screenshots

Add screenshots of:

1. Login Screen
2. Add Notes Screen
3. View Notes Screen
4. AI Summary Screen

---

# ▶️ How to Run

1. Clone the repository.

```bash
git clone https://github.com/yourusername/NoPanicAI.git
```

2. Open in Android Studio.

3. Add your:

- Firebase `google-services.json`
- Gemini API Key

4. Sync Gradle.

5. Run the application.

---

# ⚠ Important

Do not upload:

- API Keys
- google-services.json
- local.properties

Create your own Firebase project and Gemini API key before running the app.

---

# 👩‍💻 Developer

**Bishakha**

Android Developer | Kotlin | Firebase | Jetpack Compose | AI Integration

---

# 🌟 Resume Highlights

- Developed an AI-powered Android application using Kotlin and Jetpack Compose.
- Integrated Firebase Authentication and Cloud Firestore for secure cloud-based note management.
- Implemented Gemini API integration to generate intelligent summaries of user notes.
- Applied asynchronous programming using Kotlin Coroutines.
- Designed a modern multi-screen Android application following clean project organization principles.
