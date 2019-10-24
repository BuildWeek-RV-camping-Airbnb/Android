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

//class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
//    private lateinit var mMap: GoogleMap
//    private lateinit var  mapFragment: SupportMapFragment
//    private lateinit var gpsTracker: GpsTracker
//    private var latitude: Double = 0.toDouble()
//    private var longitude: Double = 0.toDouble()
//    private lateinit var location: Location
//    private lateinit var locationManager: LocationManager
//    val ACCESS_FINE_LOCATION = 1
//    val ACCESS_COARSE_LOCATION= 2
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_maps)
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//    }
//
//    private fun loadMapData() {
//        mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//        gpsTracker = GpsTracker(this)
//    }
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
//    override fun onMapReady(googleMap: GoogleMap) {
//
//
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//            && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
//                ACCESS_FINE_LOCATION
//            )
//
//        } else {
//            gpsTracker(googleMap)
//            //googleMap= googleMap1
//        }
//    }
//
//    private fun gpsTracker(googleMap1: GoogleMap){
//        if (gpsTracker.canGetLoaction()) {
//            locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
//            location = locationManager.getLastKnownLocation(NETWORK_PROVIDER)//This error is all thanks to android studio being weird
//            gpsTracker.onLocationChanged(location)
//            latitude = gpsTracker.getLatitude()
//            longitude = gpsTracker.getLongitude()
//            mMap = googleMap1
//            // Add a marker in Sydney and move the camera
//            Handler().postDelayed({
//                val pune = LatLng(latitude, longitude)
//                mMap.addMarker(MarkerOptions().position(pune).title("Oh geeeeeeez! You found me at my address!\n Please enjoy the music\n While i go hide again"))
//                mMap.moveCamera(CameraUpdateFactory.newLatLng(pune))
//                mMap.animateCamera(CameraUpdateFactory.zoomIn())
//                mMap.animateCamera(CameraUpdateFactory.zoomTo(8.0f))
//                //mMap.setMaxZoomPreference(14.0f);
//                mMap.maxZoomLevel
//            }, 1500)
//            val builder = AlertDialog.Builder(this)
//            builder.setCancelable(true)
//            builder.setTitle("Location")
//            builder.setMessage("This is your current location: Latitude: $latitude Longitude: $longitude")
//            builder.setPositiveButton("OK") { dialogInterface, i -> dialogInterface.dismiss() }
//            builder.show()
//        } else {
//            gpsTracker.openSettings()//Open the settings alert to enable the GPS sevice
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        when (requestCode) {
//            0 -> {
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), ACCESS_COARSE_LOCATION)        //gpsTracker()
//                }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
//                    if (ActivityCompat.shouldShowRequestPermissionRationale(this@MapsActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {
//                        //Show an explanation to the user *asynchronously*
//                        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), ACCESS_FINE_LOCATION)        //gpsTracker()
//                    }else{
//                        val builder = AlertDialog.Builder(this)
//                        builder.setCancelable(true)
//                        builder.setTitle("Alert")
//                        builder.setMessage("Location permission is required")
//                        builder.setPositiveButton("OK") { dialogInterface, i ->
//                            dialogInterface.dismiss() }
//                        builder.show()
//                    }
//                }
//            }
//            1 -> {
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    loadMapData()
//                }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
//                    if (ActivityCompat.shouldShowRequestPermissionRationale(this@MapsActivity, Manifest.permission.ACCESS_COARSE_LOCATION)) {
//                        //Show an explanation to the user *asynchronously*
//                        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), ACCESS_COARSE_LOCATION)        //gpsTracker()
//                    }else{
//                        val builder = AlertDialog.Builder(this)
//                        builder.setCancelable(true)
//                        builder.setTitle("Alert")
//                        builder.setMessage("Location permission is required")
//                        builder.setPositiveButton("OK") { dialogInterface, i ->
//                            dialogInterface.dismiss()
//                        }
//                        builder.show()
//                    }
//                }
//            }
//        }
//    }
//    }