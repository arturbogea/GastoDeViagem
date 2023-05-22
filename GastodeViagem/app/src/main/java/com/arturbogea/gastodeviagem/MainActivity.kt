package com.arturbogea.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.arturbogea.gastodeviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btcalcular.setOnClickListener {
            calcularPreco()
        }
    }

    fun calcularPreco(){
        val distancia = binding.txtDist
        val preco = binding.txtPreco
        val kmLitro = binding.txtKmlitro

        val distanciaTotal = java.lang.Float.parseFloat(distancia.text.toString())
        val precoFinal = java.lang.Float.parseFloat(preco.text.toString())
        val kmLitros = java.lang.Float.parseFloat(kmLitro.text.toString())

        val mensagem = binding.txtFinal

        var valorTotal = (distanciaTotal * precoFinal) / kmLitros

        valorTotal.toString()

        mensagem.setText("R$ ${"%.2f".format(valorTotal)}")


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // nesse caso é para criar um botão de menu. Vou criar outra sobreescrita de metodos para limpar os dados na tela
        var inflate = menuInflater
        inflate.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //aqui coloquei a logica, para limpar os dados informados
        when(item.itemId){
            R.id.reset -> {
                val limparDistancia = binding.txtDist
                val limparPreco = binding.txtPreco
                val limparAutonomia = binding.txtKmlitro
                val limparMensagem = binding.txtFinal

                limparDistancia.setText("")
                limparPreco.setText("")
                limparAutonomia.setText("")
                limparMensagem.setText("")
            }
        }

        return super.onOptionsItemSelected(item)
    }

}