package com.example.myapplication3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuPopupHelper
import com.example.myapplication3.R.*

class MainActivity_Menu : ComponentActivity() {
    private lateinit var textView: TextView
    private lateinit var btn:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.menu_main)

        textView =findViewById<TextView>(id.test_text_view)
        btn = findViewById<Button>(id.showPopup)
        btn.setOnClickListener{ view ->
               showPopup(view)
        }

        registerForContextMenu(textView)
    }

    @SuppressLint("RestrictedApi")
    private fun showPopup(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_test, popupMenu.menu)
//        popupMenu.menu.findItem(checkedItemId).isChecked = true

        try {
            val field = PopupMenu::class.java.getDeclaredField("mPopup")
            field.isAccessible = true
            val mHelper = field.get(popupMenu) as MenuPopupHelper
//            mHelper.forceShowIcon = true
        } catch (e: Exception) {
            e.printStackTrace()
        }

        popupMenu.show()

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.font_size_small -> textView.textSize = 10f
                R.id.font_size_medium -> textView.textSize = 16f
                R.id.font_size_large -> textView.textSize = 20f
                R.id.normal_menu_item -> Toast.makeText(this,"普通菜单项被点击",Toast.LENGTH_SHORT).show()
                R.id.font_color_red -> textView.setTextColor(resources.getColor(color.red))
                R.id.font_color_black -> textView.setTextColor(resources.getColor(color.black))
            }
            true
        }

    }
//    override fun onCreateContextMenu(
//        menu: ContextMenu?,
//        v: View?,
//        menuInfo: ContextMenu.ContextMenuInfo?
//    ) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        val inflater =menuInflater
//        inflater.inflate(R.menu.menu_test,menu)
//    }
//
//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            id.font_size_small -> textView.textSize = 10f
//            id.font_size_medium -> textView.textSize = 16f
//            id.font_size_large -> textView.textSize = 20f
//            id.normal_menu_item -> Toast.makeText(this,"普通菜单项被点击",Toast.LENGTH_SHORT).show()
//            id.font_color_red -> textView.setTextColor(resources.getColor(color.red))
//            id.font_color_black -> textView.setTextColor(resources.getColor(color.black))
//        }
//        return true
//    }
}