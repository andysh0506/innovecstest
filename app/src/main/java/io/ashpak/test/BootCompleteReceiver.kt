package io.ashpak.test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BootCompleteReceiver : BroadcastReceiver() {
    override fun onReceive(context : Context?, intent : Intent?) {
        Log.d("BootCompleteReceiver","onReceive")
        Toast.makeText(context,"BootCompleteReceiver",Toast.LENGTH_LONG).show()
    }
}