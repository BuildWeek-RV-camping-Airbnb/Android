package com.Lambda.rv_camping.ui.activities

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.location.LocationManager.NETWORK_PROVIDER
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.Lambda.rv_camping.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    companion object {
        private const val FINE_LOCATION_REQUEST_CODE = 5
       
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            FINE_LOCATION_REQUEST_CODE
        )


    }

    /* private fun loadMapData() {
        mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }*/

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        //LONDON BABY
        val london = LatLng(51.509865, -0.118092)
        //sets marker position
        mMap.addMarker(MarkerOptions().position((london)))
        //moves camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(london))
        //googleMap= googleMap1
    }
}


/*
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            0 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), ACCESS_COARSE_LOCATION)        //gpsTracker()
                }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this@MapsActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {
                        //Show an explanation to the user *asynchronously*
                        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), ACCESS_FINE_LOCATION)        //gpsTracker()
                    }else{
                        val builder = AlertDialog.Builder(this)
                        builder.setCancelable(true)
                        builder.setTitle("Alert")
                        builder.setMessage("Location permission is required")
                        builder.setPositiveButton("OK") { dialogInterface, i ->
                            dialogInterface.dismiss() }
                        builder.show()
                    }
                }
            }
            1 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadMapData()
                }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this@MapsActivity, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                        //Show an explanation to the user *asynchronously*
                        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), ACCESS_COARSE_LOCATION)        //gpsTracker()
                    }else{
                        val builder = AlertDialog.Builder(this)
                        builder.setCancelable(true)
                        builder.setTitle("Alert")
                        builder.setMessage("Location permission is required")
                        builder.setPositiveButton("OK") { dialogInterface, i ->
                            dialogInterface.dismiss()
                        }
                        builder.show()
                    }
                }
            }
        }
    }*/
