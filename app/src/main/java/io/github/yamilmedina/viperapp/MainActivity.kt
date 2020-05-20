package io.github.yamilmedina.viperapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        buttonNewPhrase.setOnClickListener {
            findNavController(R.id.nav_host_container).navigate(R.id.phraseFeedFragment)
        }
    }
}
