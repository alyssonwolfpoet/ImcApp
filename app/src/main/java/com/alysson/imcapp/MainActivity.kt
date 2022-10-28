package com.alysson.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("Lifecycle","entrei no Create - estou criando a tela")
        setListenerns()
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

    private fun setListenerns(){
        alturaEDT.doAfterTextChanged { text ->
            Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        pesoEDT?.doOnTextChanged { text, start, before, count ->
            result?.text = text
        }
        calcularBTN?.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(),alturaEDT.text.toString())
        }

    }

    private fun calcularIMC( peso: String,altura: String){
        var peso = peso.toFloatOrNull()
        var altura = altura.toFloatOrNull()

        if (peso != null && altura != null){
            var imc = peso / (altura*altura)
            result.text = "imc é: %.2f".format(imc)
            statusfun(imc)

        }
    }
    fun statusfun(x: Float){
        if (x<=16.9)
            status.text = "Muito abaixo do peso: menor que 16,9 kg/m2"
        else if (x>=17 && x<=18.4)
            status.text = "Abaixo do peso: 17 a 18,4 kg/m2"
        else if (x>=18.5 && x<=24.9)
            status.text = "Peso normal: 18,5 a 24,9 kg/m2"
        else if (x>=25.0 && x<=29.9)
            status.text = "Acima do peso: 25 a 29,9 kg/m2"
        else if (x>=30.0 && x<=34.9)
            status.text = "Obesidade Grau I: 30 a 34,9 kg/m2"
        else if (x>=35.0 && x<=40.0)
            status.text = "Obesidade Grau II: 35 a 40 kg/m2"
        else if (x>40.0)
            status.text = "Obesidade Grau III: maior que 40 kg/m2"
        else
            status.text = "Dados invalidos tente novamente"

    }
}