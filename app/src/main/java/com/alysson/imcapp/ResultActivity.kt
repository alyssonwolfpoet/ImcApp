package com.alysson.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        Log.w("Lifecycle","entrei no Create - estou criando a tela")
    }

    override fun onStart() {
        super.onStart()
        Log.w("Lifecycle","entrei no START - deixei a tela visivel pra você")
    }

    override fun onResume() {
        super.onResume()
        Log.w("Lifecycle","entrei no RESUME - agora voce pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("Lifecycle","PAUSA - a tela perdeu o foco, voce não pode mais interagir")
    }

    override fun onStop() {
        super.onStop()
        Log.w("Lifecycle","STOP - a tela não esta visivel mais ainda existe")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("Lifecycle","\nEntrei no RESTART - a tela esta retomando o foco")
    }

    override fun onDestroy() {
        Log.w("Lifecycle","\noh não a tela foi destruida")
        super.onDestroy()
    }
}