package com.example.myapplication

import android.content.Context
import android.net.Uri
import android.widget.Toast
import android.widget.VideoView

class VideoService {
    companion object {
        fun playRawVideo(context: Context, videoView: VideoView, resName: String) {
            try {
                val packageName = context.packageName;
                val id = context.resources.getIdentifier(resName, "raw", packageName)
                val uri = Uri.parse("android.resource://" + packageName + "/" + id)
                videoView.setVideoURI(uri)
            } catch (e: Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
        }

        fun playLocalVideo(context: Context, videoView: VideoView, path: String) {
            try {
                videoView.setVideoURI(Uri.parse(path))
            } catch (e: Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
        }

        fun playURLVideo(context: Context, videoView: VideoView, path: String) {
            try {
                videoView.setVideoPath(path)
            } catch (e: Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}