package com.algebra.services

import android.app.IntentService
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.widget.Toast

const val MY_ACTION   = "com.algebra.services.action.MY_ACTION"
const val EXTRA_PARAM = "com.algebra.services.extra.PARAM"


class MyIntentService : IntentService( "MyIntentService" ) {

    private val TAG = "MyIntentService"
    private val handler = Handler( )

    override fun onHandleIntent( intent: Intent? ) {
        Log.i( TAG, "IntentService started" )
        val extra = intent?.getIntExtra( EXTRA_PARAM, -1 )
        if( intent?.action == MY_ACTION ) {
            handler.post {
                Toast.makeText(this, "Intent servis je startan... (Pročitano: $extra)", Toast.LENGTH_SHORT).show()
            }
            Thread.sleep( 10000 )
        }
    }

    override fun onDestroy( ) {
        Log.i( TAG, "IntentService destroyed" )
        super.onDestroy( )
    }
}