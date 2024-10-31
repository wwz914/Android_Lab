package com.example.myapplication3

import MyListAdapter
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Context : ComponentActivity() {
    private lateinit var listView: ListView
    private var actionMode: ActionMode? = null
    private val items = listOf("One", "Two", "Three", "Four", "Five")
    private lateinit var adapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.context_main)

        listView = findViewById(R.id.listView)
        adapter = MyListAdapter(this, items, this)
        listView.adapter = adapter
    }

    fun onItemClick(position: Int) {
        if (actionMode == null) {
            startActionMode()
        } else {
            actionMode?.invalidate()
        }
    }

    private fun startActionMode() {
        actionMode = listView.startActionMode(object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                mode.menuInflater.inflate(R.menu.contextual_menu, menu)
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_delete -> {
                        // Handle delete action here
                        mode.finish()
                        return true
                    }
                }
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode) {
                actionMode = null
                adapter.selectedItemPosition = -1
                adapter.notifyDataSetChanged()
            }
        })
    }
}