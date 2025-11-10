# 💼 REST Client Banking App

> **Author:** Saad Karzouz  
> **Project Type:** Android Native Application  
> **Tech Stack:** Java + Retrofit + Material Design

---



https://github.com/user-attachments/assets/a23766e6-93b2-4c6b-882e-107c59bfea1e


## 🎯 Project Overview

A modern Android banking application that demonstrates REST API integration with full CRUD capabilities for managing bank accounts.

### ✨ Key Features

- 🏦 **Account Management** - Create, read, update, and delete bank accounts
- 💰 **Account Types** - Support for both COURANT (checking) and EPARGNE (savings) accounts  
- 📊 **Real-time Sync** - Live data synchronization with backend server
- 🎨 **Material Design** - Clean and intuitive user interface
- ⚡ **Fast Performance** - Optimized with RecyclerView and efficient network calls

---

## 🛠 Technical Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| **Language** | Java | 11 |
| **Build Tool** | Gradle | 8.13 |
| **Min SDK** | Android | 24 |
| **Target SDK** | Android | 33 |
| **HTTP Client** | Retrofit | 2.9.0 |
| **JSON Parser** | Gson | 2.10.1 |
| **UI Framework** | Material Components | 1.9.0 |

### 📚 Dependencies

```gradle
// Networking
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.squareup.okhttp3:logging-interceptor:4.11.0'

// UI Components
implementation 'androidx.recyclerview:recyclerview:1.3.0'
implementation 'com.google.android.material:material:1.9.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
```

---

## 📂 Project Structure

```
restclient/
├── adapter/
│   └── CompteAdapter.java          # RecyclerView adapter for account list
├── models/
│   ├── Compte.java                 # Account data model
│   └── TypeCompte.java             # Account type enum (COURANT/EPARGNE)
├── network/
│   ├── ApiService.java             # REST API interface
│   └── RetrofitClient.java         # Retrofit configuration
└── MainActivity.java               # Main activity & UI logic
```

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Arctic Fox or newer
- JDK 11+
- Android SDK with API 24+
- Running backend server (default: http://10.0.2.2:8080/)

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   ```

2. **Open in Android Studio**
   - File → Open → Select project directory

3. **Configure Backend URL**
   - Edit `RetrofitClient.java`
   - Update `BASE_URL` to your server address

4. **Sync & Build**
   ```bash
   ./gradlew build
   ```

5. **Run the app**
   - Click Run button or press Shift+F10

---

## 💡 Usage Guide

### Viewing Accounts
- Launch the app to see all existing accounts
- Pull down to refresh the list

### Adding an Account
1. Tap the floating action button (+)
2. Enter the initial balance
3. Select account type
4. Click "Save"

### Editing an Account
1. Tap the edit icon on any account card
2. Modify the details
3. Click "Save"

### Deleting an Account
1. Tap the delete icon on any account card  
2. Confirm the deletion

---

## 🔌 API Endpoints

The app consumes the following REST endpoints:

```
GET    /banques/comptes         # Fetch all accounts
POST   /banques/comptes         # Create new account
PUT    /banques/comptes/{id}    # Update account
DELETE /banques/comptes/{id}    # Delete account
```

### Request/Response Format

**Account Model:**
```json
{
  "id": 1,
  "solde": 5000.00,
  "dateCreation": "2025-11-10T14:30:00",
  "type": "COURANT"
}
```

---

## 🎨 UI Components

- **MainActivity** - Main screen with account list
- **RecyclerView** - Scrollable list of accounts
- **FloatingActionButton** - Add new account trigger
- **AlertDialog** - Custom dialog for add/edit operations
- **Material Toolbar** - App bar with title
- **ProgressBar** - Loading indicator

---

## 🔒 Permissions

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

---

## 🐛 Troubleshooting

**Connection Issues:**
- Verify backend server is running
- Check BASE_URL configuration
- Ensure network permissions are granted

**Build Errors:**
- Clean and rebuild: `./gradlew clean build`
- Invalidate caches: File → Invalidate Caches / Restart
- Update Gradle dependencies

---

## 📝 License

This project is developed for educational purposes.

---

## 👨‍💻 Author

**Saad Karzouz**  
📧 Contact: [GitHub Profile]  
📅 Date: November 2025

---

<div align="center">
  <p>Built with ❤️ using Android & Java</p>
  <p>⭐ Star this repo if you find it helpful!</p>
</div>
│       │   │   ├── colors.xml                → Color palette
│       │   │   ├── strings.xml               → Text resources
│       │   │   └── themes.xml                → App theme
│       │   └── 📂 drawable/                  → Icons & shapes
│       │
│       └── 📄 AndroidManifest.xml            → App manifest
│
├── 📂 gradle/
│   └── 📄 libs.versions.toml                 → Version catalog
│
└── 📄 build.gradle.kts                       → Project configuration
```

### 📚 Package Overview

| Package | Purpose | Key Components |
|---------|---------|----------------|
| **`models/`** | Data classes | Compte, TypeCompte |
| **`network/`** | API communication | ApiService, RetrofitClient |
| **`adapter/`** | UI adapters | CompteAdapter for RecyclerView |

---

## 🌐 REST API Integration

### API Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| `GET` | `/banque/comptes` | Fetch all accounts | - |
| `GET` | `/banque/comptes/{id}` | Fetch account by ID | - |
| `POST` | `/banque/comptes` | Create new account | `Compte` object |
| `PUT` | `/banque/comptes/{id}` | Update account | `Compte` object |
| `DELETE` | `/banque/comptes/{id}` | Remove account | - |

### 📋 Data Models

**Account Object (Compte)**
```json
{
  "id": 1,
  "solde": 5000.00,
  "dateCreation": "2025-10-27T14:30:00",
  "type": "COURANT"
}
```

**Create Request Example**
```json
{
  "solde": 10000.00,
  "dateCreation": "2025-10-27T14:30:00",
  "type": "EPARGNE"
}
```

### 🔐 HTTP Status Codes

| Code | Meaning | Usage |
|------|---------|-------|
| `200` | OK | Request successful |
| `201` | Created | Resource created |
| `204` | No Content | Delete successful |
| `400` | Bad Request | Invalid data |
| `404` | Not Found | Resource not found |
| `500` | Server Error | Backend error |

---

## 💾 Core Data Structures

### `Compte.java` - Account Entity

```java
public class Compte {
    private Long id;              // Unique identifier
    private double solde;         // Account balance
    private String dateCreation;  // Creation date (ISO 8601)
    private TypeCompte type;      // COURANT or EPARGNE
    
    // Getters, setters, and constructors...
}
```

### `TypeCompte.java` - Account Type Enum

```java
public enum TypeCompte {
    COURANT,   // Checking account
    EPARGNE    // Savings account
}
```

---

## 🐛 Troubleshooting Guide

### Common Issues & Solutions

<details>
<summary><b>⚠️ Connection Failed: "Failed to connect to /10.0.2.2:8080"</b></summary>

**Possible Causes:**
- Backend server not running
- Incorrect BASE_URL in `RetrofitClient.java`
- Firewall blocking the connection

**Solutions:**
1. ✅ Start your backend server
2. ✅ Verify the URL matches your API endpoint
3. ✅ For physical devices, use your machine's local IP (e.g., `192.168.x.x`)
4. ✅ Check firewall settings and allow port 8080
</details>

<details>
<summary><b>⚠️ HTTP 404 Not Found</b></summary>

**Possible Causes:**
- Incorrect endpoint paths
- API route mismatch

**Solutions:**
1. ✅ Verify endpoints in `ApiService.java` match your backend
2. ✅ Check OkHttp logs for the full request URL
3. ✅ Ensure backend routes are properly configured
</details>

<details>
<summary><b>⚠️ JSON Parsing Error: "Expected BEGIN_OBJECT but was BEGIN_ARRAY"</b></summary>

**Possible Causes:**
- Model class mismatch with API response
- Incorrect Gson annotations

**Solutions:**
1. ✅ Verify Java models match the JSON structure
2. ✅ Check `@SerializedName` annotations
3. ✅ Review OkHttp logs to see actual JSON response
4. ✅ Use tools like Postman to validate API responses
</details>

<details>
<summary><b>⚠️ App Crashes on Launch</b></summary>

**Possible Causes:**
- Missing permissions
- Network configuration issues

**Solutions:**
1. ✅ Verify `INTERNET` permission in `AndroidManifest.xml`
2. ✅ Check `android:usesCleartextTraffic="true"` is set
3. ✅ Review logcat for detailed error messages
</details>

---

## 📖 Additional Resources

- 📚 [Retrofit Documentation](https://square.github.io/retrofit/)
- 🎨 [Material Design Guidelines](https://m3.material.io/)
- 🤖 [Android Developer Docs](https://developer.android.com/)
- 📦 [Gson User Guide](https://github.com/google/gson/blob/master/UserGuide.md)

---

## 👨‍💻 Developer

<div align="center">

### **Saad Karzouz**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/saadkarz)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/saadkarzouz)

---

<sub>Built with ❤️ using Android Studio | Last updated: November 2025</sub>

</div>

