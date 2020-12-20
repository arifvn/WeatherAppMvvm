package com.squareit.weatherapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

open class BaseActivity : AppCompatActivity() {

    companion object {
        private const val FINE_LOCATION_RQ = 11
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        checkForPermission(Manifest.permission.ACCESS_FINE_LOCATION, FINE_LOCATION_RQ)
    }

    private fun checkForPermission(permission: String, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                ContextCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                }

                shouldShowRequestPermissionRationale(permission) -> showDialog(
                    permission,
                    requestCode
                )

                else -> ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
            }
        }
    }

    private fun showDialog(permission: String, requestCode: Int) {
        val builder = AlertDialog.Builder(this)

        builder.apply {
            setMessage("Permission to access your location is required")
            setTitle("Permission Required")
            setPositiveButton("OK") { _, _ ->
                ActivityCompat.requestPermissions(
                    this@BaseActivity,
                    arrayOf(permission),
                    requestCode
                )
            }
        }

        val dialog = builder.create()
        dialog.show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == FINE_LOCATION_RQ)
            if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Permission Refused", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
    }
}