# Oblig 1 & 2 Quiz

Oblig 1 & 2for DAT153 📱. 

Group 7️⃣
<br />&emsp;Members: 👨‍👨‍👧‍👧
<br />&emsp;&emsp;        Bjørn Eide
<br />&emsp;&emsp;        Carl Alfred Emanuel Nordqvist
<br />&emsp;&emsp;        Maksim Ohvrill
<br />&emsp;&emsp;        Batuhan Titrek

This is a prompt for an Android app development assignment. 📳  

The app is a quiz game where users match names and photos
 The app should have three core activities:
 
 a "database" activity that shows all names and pictures and allows the user to add, remove, and sort entries. 🖥
 
 a "quiz" activity that randomly selects a photo and presents the correct name and two wrong names, 🕹
 
 an "add entry" activity where the user can add new photos and names to the database. ➕
 
 The main menu should have a switch for easy or hard mode, and the app should keep track of the score in the quiz activity.
 
 Now featuring DATABASE technologies.
 
 implementing data storage using Android Room DAOs to save user data and ensure that it is not lost when the app is restarted.
 
 The third task involves writing test cases using Espresso for the app. 
 
 At least three test cases are required, including one that checks if the correct button is clicked to take the user to the right sub-activity,
 
 Useing Android Room DAO to create a easy to manage database for the application.
 The database will store new pictures and the user score.
 
# Tests: 🧪
## Test 1: Access the game view from main view.
 - Open mainActivity
 - Click on Quiz button
 - Verify that Gameview (quiz) is opened
 - Close the Activities
 - Release()
 
## Test 2  Access the gameview and assert that when an option is selected.
 - Open gameView.
 - Press the right alternative to the corresponding image
 - Verify that popup window displays "Correct!"
 - Verify that popuo windows displays the score with 1 additional point to before.
 - Close gameView.
 - Release()
 
 ## Test 3 Access the database and uploade a new item and verify that the size is updated, and is size is 1- when the entry is deleted.
 - Open databaseView
 - Click add new item
 - Fill inn name and upload an image.
 - Press submit.
 - Verify size is +1.
 - Delete the entry.
 - Verify the size is back to before.
 - close databaseView
 - Release()

# Task 3 APK & ADB

### APK used when running the test
INFO: Installing APK: C:\Users\maksi\Documents\git_repos\Oblig1_Quiz\app\build\outputs\apk\androidTest\debug\app-debug-androidTest.apk
Mar 20, 2023 4:35:01 PM com.google.testing.platform.plugin.android.AndroidDevicePlugin beforeAll
INFO: Installing APK: C:\Users\maksi\Documents\git_repos\Oblig1_Quiz\app\build\outputs\apk\debug\app-debug.apk

and the APK for the application itself with version 1.0

### ADB 
- ADB install
-- Installs the APK for testing on the device using usual commands as
adb -s emulator-5554 install -r <path-to-test-apk> to install the test APK on the device or emulator.
adb -s emulator-5554 shell am instrument -w <test-runner-arguments> to execute the test cases.
the adb executes them in the background and they were not visible in the output while running the testers with ./gradlew connectedAndroidTest --info

