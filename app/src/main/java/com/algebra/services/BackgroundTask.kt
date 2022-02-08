package com.algebra.services

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast

class BackgroundTask( private val context : Context ) : AsyncTask< Int, Int, String >( ) {

    val TAG = "BackgroundTask"

    override fun doInBackground( vararg ulaz : Int? ) : String {
        val taskCount = ulaz[0]
        for( i in 1..taskCount!! ) {
            Thread.sleep( 3000 )
            publishProgress( ( i/taskCount.toDouble( ) * 100 ).toInt( ) )
            Log.i( TAG, "$i od $taskCount gotovo" )
        }
        return "Zadatak je izvršen"
    }

    override fun onProgressUpdate( vararg postotak : Int? ) {
        val progress = postotak[0]
        Toast
            .makeText( context, "$progress% gotovo...", Toast.LENGTH_SHORT )
            .show( )
    }

    override fun onPostExecute( result : String? ) {
        Toast
            .makeText( context, result, Toast.LENGTH_SHORT )
            .show( )
    }
}