```kotlin name=MainActivity.kt
package com.example.videorecorderapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var viewerLoginButton: Button
    private lateinit var adminLoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewerLoginButton = findViewById(R.id.viewerLoginButton)
        adminLoginButton = findViewById(R.id.adminLoginButton)

        viewerLoginButton.setOnClickListener {
            // Implement viewer login functionality
        }

        adminLoginButton.setOnClickListener {
            // Implement admin login functionality
        }

        checkPermissions()
    }

    private fun checkPermissions() {
        val permissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        val permissionNeeded = permissions.filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }

        if (permissionNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionNeeded.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.any { it != PackageManager.PERMISSION_GRANTED }) {
            Toast.makeText(this, "Permissions are required for the app to function", Toast.LENGTH_SHORT).show()
        }
    }
}
```
