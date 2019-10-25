package com.Lambda.rv_camping.ui.activities

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.Properties
import com.Lambda.rv_camping.model.RvLocation
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
class ShowMapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_map)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        Companion.checkPermission(this)
        loadLocation()
    }

    var ACCESSLOCATION = 123
    fun getUserLocation() {
        Toast.makeText(this, "User Location Access on", Toast.LENGTH_LONG).show()
        var myLocation = MyLocationListener()
        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3, 3f, myLocation)
        var myThread = MyThread()
        myThread.start()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            ACCESSLOCATION -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getUserLocation()
                } else {
                    Toast.makeText(this, "We can't access your location", Toast.LENGTH_LONG).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

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
    }

    var location: Location? = null

    // Get User location
    inner class MyLocationListener : LocationListener {
        init {
            location = Location("Start")
            location!!.longitude = 0.0
            location!!.latitude = 0.0
        }

        override fun onLocationChanged(p0: Location?) {
            location = p0
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderEnabled(p0: String?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderDisabled(p0: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    var oldLocation: Location? = null

    inner class MyThread : Thread() {
        init {
            oldLocation = Location("Start")
            oldLocation!!.longitude = 0.0
            oldLocation!!.latitude = 0.0
        }

        override fun run() {
            while (true) {
                try {
                    if (oldLocation!!.distanceTo(location) == 0f) {
                        continue
                    }
                    oldLocation = location
                    runOnUiThread {
                        mMap.clear()
                        //show my location
                        val sydney = LatLng(location!!.latitude, location!!.longitude)
                        mMap.addMarker(
                            MarkerOptions()
                                .position(sydney)
                                .title("Me")
                                .snippet("This is my Location")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.campfire))
                        )
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14f))
                        // show locations
                        for (i in 0..listLocation.size - 1) {
                            var newLocation = listLocation[i]
                            val rvLocation = LatLng(
                                newLocation.location!!.latitude,
                                newLocation.location!!.longitude
                            )
                            mMap.addMarker(
                                MarkerOptions()
                                    .position(rvLocation)
                                    .title(newLocation.name)
                                    .snippet(newLocation.des)
                                    .icon(BitmapDescriptorFactory.fromResource(newLocation.image!!))
                            )
                            listLocation[i] = newLocation
                            Toast.makeText(
                                applicationContext,
                                "Feel Free To Explore the map",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    Thread.sleep(1000)
                } catch (ex: Exception) {
                }
            }
        }
    }

    var listLocation = ArrayList<RvLocation>()
    fun loadLocation() {
        listLocation.add(
            RvLocation(
                "UFO Site",
                "Here is UFO Site",
                R.drawable.campfire,
                37.778999,
                -122.401846
            )
        )
        listLocation.add(
            RvLocation(
                "Camping Site in Utah",
                "Not too far from you",
                R.drawable.campfire,
                37.794956,
                -122.410494
            )
        )
        listLocation.add(
            RvLocation(
                "Forestry",
                "Its always raining there",
                R.drawable.campfire,
                37.781662,
                -122.412253
            )
        )
    }

    companion object {
        fun checkPermission(mapsActivity: ShowMapActivity) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (ActivityCompat.checkSelfPermission(
                        mapsActivity,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    mapsActivity.requestPermissions(
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        mapsActivity.ACCESSLOCATION
                    )
                    return
                }
            }
            mapsActivity.getUserLocation()
        }
    }
}
