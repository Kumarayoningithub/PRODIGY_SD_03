# PRODIGY_SD_03
# Contact Management System (Java Swing)

A simple **Contact Management System** built using **Java Swing** that allows users to **add, edit, delete, and store contacts**.  
The application stores contact information such as **Name, Phone Number, and Email** and saves the data locally using **file serialization**.

---

# Project Overview

This project demonstrates how to build a **desktop GUI application in Java** with persistent data storage.  
Users can manage their contacts through a graphical interface, and all contacts are saved to a file so they remain available even after restarting the program.

---

# Features

- ➕ Add new contacts
- ✏️ Edit existing contacts
- ❌ Delete contacts
- 📋 Display contacts in a list
- 💾 Save contacts to file
- 📂 Load saved contacts automatically when the program starts
- 🖥️ Simple and interactive GUI using Java Swing

---

# Technologies Used

- Java
- Java Swing
- AWT
- File Handling
- Object Serialization
- ArrayList
- Event Handling (ActionListener)

---

# How the Application Works

1. The user enters **Name, Phone, and Email** in the input fields.
2. Clicking **Add** will:
   - Create a new contact
   - Add it to the list
   - Save it to the file
3. Selecting a contact allows the user to:
   - **Edit** the contact details
   - **Delete** the contact
4. All contacts are stored in a file named:
