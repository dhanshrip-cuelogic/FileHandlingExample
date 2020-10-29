package com.example.filehandlingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createFileButton = findViewById<Button>(R.id.create_file_button)
        val writeIntoFileButton = findViewById<Button>(R.id.write_into_file_button)
        val readFromFileButton = findViewById<Button>(R.id.read_from_file_button)
        val writeTextResult = findViewById<TextView>(R.id.write_result)
        val createFileResult = findViewById<TextView>(R.id.create_file_result)
        val writeTextIntoFile = findViewById<EditText>(R.id.content_to_write)
        val readFromFileResult = findViewById<TextView>(R.id.read_from_file_result)

        val path = filesDir
        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()
        val fileName = "Demo.txt"
        val file = File(letDirectory,fileName)

        createFileButton.setOnClickListener {
            println("Button clicked")
            println("Going to create new file")
            val createdFile = file.createNewFile()

            if(createdFile) {
                createFileResult.text = "File created"
            }else {
                createFileResult.text = "File already exists"
            }
        }

        writeIntoFileButton.setOnClickListener {
            val writeText = writeTextIntoFile.text.toString()
            file.appendText(" ")
            file.appendText(writeText)
            writeTextResult.text = "Text added into file."
        }

        readFromFileButton.setOnClickListener {
            val textFromFile = file.readText()
            readFromFileResult.text = textFromFile
        }



    }
}