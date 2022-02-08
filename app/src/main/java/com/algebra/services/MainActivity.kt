package com.algebra.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var bStartService        : Button
    private lateinit var bStopService         : Button
    private lateinit var bStartIntentService  : Button
    private lateinit var bTest                : Button

    override fun onCreate( savedInstanceState : Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        initWidgets( )
        setupListeners( )
    }

    private fun setupListeners( ) {
        bStartService.setOnClickListener {
            val intent = Intent( this, MyService::class.java )
            startService( intent )
        }

        bStartIntentService.setOnClickListener {
            val intent = Intent( this, MyIntentService::class.java )
            intent.action = MY_ACTION
            intent.putExtra( EXTRA_PARAM, 5 )
            startService( intent )
/*         ili u stilu funkcionalnog programiranja:
            startService( Intent( this, MyIntentService::class.java ).apply {
                action = MY_ACTION
                putExtra( EXTRA_PARAM, 5 )
            } )
 */
        }

        bStopService.setOnClickListener {
            stopService( Intent( this, MyService::class.java ) )
        }

        bTest.setOnClickListener {
            Toast.makeText( this, "TEST", Toast.LENGTH_SHORT ).show( )
        }
    }

    private fun initWidgets( ) {
        bStartService       = findViewById( R.id.bStartService )
        bStartIntentService = findViewById( R.id.bStartIntentService )
        bStopService        = findViewById( R.id.bStopService )
        bTest               = findViewById( R.id.bTest )
    }
}