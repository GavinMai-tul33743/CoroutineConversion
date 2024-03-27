package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //TODO (Refactor to replace Thread code with coroutines)

    lateinit var cakeImageView: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeImageView = findViewById(R.id.imageView)

        val scope = CoroutineScope(Job() + Dispatchers.Default)

        findViewById<Button>(R.id.revealButton).setOnClickListener{
            scope.launch { showImage() }
        }
    }
    suspend fun showImage(){
        repeat(100) {
            cakeImageView.alpha = it / 100f
            delay(40)
        }
    }
}

//val handler = Handler(Looper.getMainLooper(), Handler.Callback {
//    cakeImageView.alpha = it.what / 100f
//    true
//})

//Thread{
//    repeat(100) {
//        handler.sendEmptyMessage(it)
//        Thread.sleep(40)
//    }
//}.start()