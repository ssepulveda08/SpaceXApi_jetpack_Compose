package com.ssepulveda.utility.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openUrl(url: String) {
    val webIntent = Intent(
        Intent.ACTION_VIEW, Uri.parse(
        url
    ))
    startActivity(webIntent)
}