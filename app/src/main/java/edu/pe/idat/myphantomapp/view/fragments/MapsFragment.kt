package edu.pe.idat.myphantomapp.view.fragments

import android.graphics.Color
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import edu.pe.idat.myphantomapp.R

class MapsFragment : Fragment(), GoogleMap.OnMarkerDragListener, GoogleMap.OnMapClickListener {

    private lateinit var mMap: GoogleMap
    private var lstLatLong = ArrayList<LatLng>()

    private val callback = OnMapReadyCallback { googleMap ->

        mMap = googleMap
        mMap.setOnMarkerDragListener(this)
        mMap.setOnMapClickListener(this)
        val puntoFijo1 = LatLng(-12.1319623, -77.0327153)
        val puntoFijo2 = LatLng(-12.1118554, -77.0140394)
        mMap.addMarker(
            MarkerOptions()
                .position(puntoFijo1)
                .title("Marker in Phantom")
                .draggable(true)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.gps))
        )
        mMap.addMarker(
            MarkerOptions()
                .position(puntoFijo2)
                .title("Marker in Phantom")
                .draggable(true)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.gps))
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(puntoFijo2, 16.0F))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun onMarkerDragStart(p0: Marker) {
        p0.showInfoWindow()
    }

    override fun onMarkerDrag(p0: Marker) {
        var posicion = p0.position
        p0.snippet = "${posicion.latitude} - ${posicion.longitude}"
        p0.showInfoWindow()
        mMap.animateCamera(CameraUpdateFactory.newLatLng(posicion))
    }

    override fun onMarkerDragEnd(p0: Marker) {
        p0.title = "Nueva ubicación de referencia"
        p0.showInfoWindow()
        mMap.animateCamera(CameraUpdateFactory.newLatLng(p0.position))
    }

    override fun onMapClick(p0: LatLng) {
        mMap.addMarker(
            MarkerOptions()
                .position(p0)
                .title("Nuevo marcador")
        )
        mMap.animateCamera(CameraUpdateFactory.newLatLng(p0))
        lstLatLong.add(p0)
        val polyLinea = PolylineOptions()
        polyLinea.color(Color.RED)
        polyLinea.width(6F)
        polyLinea.addAll(lstLatLong)
        mMap.addPolyline(polyLinea)
    }
}