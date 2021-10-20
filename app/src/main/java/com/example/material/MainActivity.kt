package com.example.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.material.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {

    var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // Создаем массив с данными (Обычно список берется из базы данных)
        val items = listOf("Rostov-on-Don", "New York", "Los Angeles", "Tokyo")

        // Поставляем данные адаптером. Здесь создание адаптера.
        val adapter = ArrayAdapter(this, R.layout.item, items)

        // Вешаем авто комплейт
        binding?.autoComplete?.setAdapter(adapter)

        // Кнопка
        binding?.add?.setOnClickListener(this)

    }

    // Обработка нажатий по кнопке
    override fun onClick(view: View) {
        binding?.result?.text = binding?.autoComplete?.text
        binding?.autoComplete?.text?.clear()
    }


}