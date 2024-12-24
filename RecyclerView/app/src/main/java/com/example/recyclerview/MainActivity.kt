package com.example.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ColorData(name: String, hex: Int) {
    val colorName: String = name
    val colorHex: Int = hex
}

class MainActivity : AppCompatActivity(), CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf<ColorData>(
            ColorData("WHITE", Color.WHITE),
            ColorData("BLACK", Color.BLACK),
            ColorData("BLUE", Color.BLUE),
            ColorData("RED", Color.RED),
            ColorData("MAGENTA", Color.MAGENTA),
        )

        val rView = findViewById<RecyclerView>(R.id.rView)

        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = Adapter(this, list = list, this)
    }

    override fun onCellClickListener(data: ColorData) {
        Toast.makeText(this, "IT’S " + data.colorName, Toast.LENGTH_SHORT).show()
    }
}