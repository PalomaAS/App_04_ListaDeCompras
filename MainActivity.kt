package com.example.app_04_lista_de_compras

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val listViewProduto = findViewById<ListView>(R.id.listViewProdutos)


        listViewProduto.adapter = produtosAdapter


        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtProduto = findViewById<TextView>(R.id.txtProduto)


        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if(produto.isNotEmpty()){
                produtosAdapter.add(produto)
                txtProduto.editableText.clear()

            } else{
                txtProduto.error = "Coloque um Produto"
            }

        }

        listViewProduto.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)

        }
    }
}