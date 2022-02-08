package com.algebra.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service( ) {

    var started = false


    override fun onStartCommand( intent: Intent?, flags: Int, startId: Int ): Int {
        if( started ) {
            Toast.makeText( this, "Service already running...", Toast.LENGTH_SHORT ).show( )
        } else {
            started = true
            Toast.makeText( this, "Service started...", Toast.LENGTH_SHORT ).show( )
            BackgroundTask( this ).execute( 6 )
            // Thread.sleep( 10000 )
        }
        return super.onStartCommand( intent, flags, startId )
    }

    override fun onDestroy( ) {
        Toast.makeText( this, "Service destroyed...", Toast.LENGTH_SHORT ).show( )
        super.onDestroy( )
    }
    override fun onBind( intent: Intent ): IBinder {
        TODO("Return the communication channel to the service.")
    }
}