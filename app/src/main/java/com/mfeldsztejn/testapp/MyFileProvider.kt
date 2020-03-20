package com.mfeldsztejn.testapp

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.View
import androidx.core.content.FileProvider
import androidx.core.view.drawToBitmap
import java.io.File
import java.io.FileOutputStream

class MyFileProvider : FileProvider()

fun shareViewAsScreenshot(
    context: Context,
    view: View,
    filename: String,
    useCustomFileProvider: Boolean
) {
    val bitmap = view.drawToBitmap()
    val file = File(context.filesDir, "${filename}.jpg")
    if (file.exists()) file.delete()
    FileOutputStream(file).use {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
    }

    val uri = if (useCustomFileProvider) {
        FileProvider.getUriForFile(context, "${context.applicationInfo.packageName}.provider.custom", file)
    } else {
        FileProvider.getUriForFile(context, "${context.applicationInfo.packageName}.provider", file)
    }
    val intent = Intent(Intent.ACTION_SEND).apply {
        flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        putExtra(Intent.EXTRA_STREAM, uri)
        clipData = ClipData.newUri(context.contentResolver, filename, uri)
        type = context.contentResolver.getType(uri)
    }
    context.startActivity(Intent.createChooser(intent, filename))
}