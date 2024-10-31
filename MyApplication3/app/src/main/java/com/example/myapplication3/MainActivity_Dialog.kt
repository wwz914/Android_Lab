package com.example.myapp.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.myapplication3.R

class MainActivity_Dialog : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_base)

        val buttonShowDialog = findViewById<Button>(R.id.btn)
        buttonShowDialog.setOnClickListener {
                showSignInDialog()
        }
    }


    private fun showSignInDialog() {
        val dialogLayout = LayoutInflater.from(this).inflate(R.layout.dialog_main, null)


        // 创建并显示对话框
        val builder = AlertDialog.Builder(this,R.style.MyDialogStyle)
        val alertDialog = builder.setView(dialogLayout)
            .setTitle("Android App")
            .create()
        alertDialog.show()

    }
}