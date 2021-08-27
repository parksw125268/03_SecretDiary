package com.example.a03_secretdiary

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener


class privateText: AppCompatActivity() {
    private val privateText: EditText by lazy {
        findViewById(R.id.privateText)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
        val detailPreference = getSharedPreferences("detail", MODE_PRIVATE)
        privateText.setText(detailPreference.getString("detail", ""))

        //쓰레드 기능 이용
      //  val runnable : Runnable


        privateText.addTextChangedListener {
            detailPreference.edit {
                putString("detail", privateText.text.toString())
            }
        }
    }
}