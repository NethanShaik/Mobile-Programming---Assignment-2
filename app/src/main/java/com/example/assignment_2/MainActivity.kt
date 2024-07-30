package com.example.assignment_2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var taskList: MutableList<Pair<String,String>>
    private lateinit var adapter: CustomAdapter

    private fun addItem(task: String, feedback: String) {
        taskList.add(Pair(task,feedback))
        adapter.notifyDataSetChanged()
    }

    fun receiveFeedback(task: String,feedback: String){
        //val text: TextView = findViewById(R.id.Text)
        //text.text = feedback;
        addItem(task, feedback)
    }

    private fun clearList(){
        taskList.clear()
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        var text: TextView = findViewById(R.id.Text)
        listView = findViewById(R.id.list)
        taskList= mutableListOf()
        adapter = CustomAdapter(this, taskList)
        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.new_task -> {
                var dialogue = DialogueFragment()
                dialogue.show(supportFragmentManager,"Custom Dialog")
                true
            }
            R.id.view_tasks -> {
                clearList()
                Toast.makeText(this,"Cleared all tasks",Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
