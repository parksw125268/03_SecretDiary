package com.example.a03_secretdiary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private val numPicker1 : NumberPicker by lazy {//메인액티비티가 생성될 시점에는 아직 뷰가 그려지지 않음
        findViewById<NumberPicker>(R.id.numPicker1)//뷰가 다 그려졌다고 알려주는 시점이 onCreate임. onCreate가 된 이후에 View에 접근해야함.
            .apply {
                this.minValue=0
                this.maxValue=9
            }
    }
    private val  numPicker2 : NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numPicker2)
            .apply {
                this.minValue = 0
                this.maxValue = 9
            }
    }
    private val numPicker3 : NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numPicker3)
            .apply {
                this.minValue = 0
                this.maxValue = 9
            }
    }
    private val openButton : AppCompatButton by lazy {
        findViewById<AppCompatButton>(R.id.openButton)
    }
    private val changePasswordButton : AppCompatButton by lazy {
        findViewById<AppCompatButton>(R.id.changePWButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numPicker1 //numberPicker를 lazy하게 선언해줘서 사용될때 apply되는데 numberPikcer를 직접 사용하지는 않아서 여기서 한번 써줘서 apply 하도록
        numPicker2
        numPicker3
        openButton.setOnClickListener {                    //파일이름 ,  mode
            val pwPreference = getSharedPreferences("password", Context.MODE_PRIVATE)//preference파일을 다른 앱과 share해서 사용하도록 해주는 함수. //MODEPRIVATE으로 이 앱에서만 사용하겟따.
            val passwordFromUser = "${numPicker1.value}${numPicker2.value}${numPicker3.value}" //입력하려는 pw
            if(pwPreference.getString("pw","000").equals(passwordFromUser)) {//password파일안에 pw라는 키로 초기값 "000"으로  저장.
                //성공
                //TODO 다이어리 페이지 작성 후에 넘겨줘야 함.
                //startActivity()
            } else {
                //실패
                AlertDialog.Builder(this)
                    .setTitle("실패")
                    .setMessage("비밀번호가 잘목되었습니다.")
                    .setPositiveButton("확인"){ _, _ ->   }  //람다 함수로 해야할일을 바로 적어줌.
                    .create()
                    .show()
            }
        }
    }
}