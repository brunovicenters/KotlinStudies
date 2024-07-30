package com.example.aula3

import android.app.AlertDialog
import android.content.Context


fun alert(title: String, msg: String, ctx: Context) {
    AlertDialog.Builder(ctx)
        .setTitle(title)
        .setMessage(msg)
        .setPositiveButton("OK", null)
        .create()
        .show()
}