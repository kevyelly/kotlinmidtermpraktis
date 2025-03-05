package com.example.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DataEntryActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dataentry)

        val app = application as MyApp

        val et_employeename = findViewById<EditText>(R.id.et_employeename)
        val et_department = findViewById<EditText>(R.id.et_employeedepartment)
        val et_salary = findViewById<EditText>(R.id.et_salary)
        val et_joiningdate = findViewById<EditText>(R.id.et_joiningdate)
        val et_performance = findViewById<EditText>(R.id.et_performance)
        val et_password = findViewById<EditText>(R.id.et_password)
        val et_username = findViewById<EditText>(R.id.et_username)
        val btnedit = findViewById<Button>(R.id.btnedit)
        val btnsave = findViewById<Button>(R.id.btnsave)

        btnedit.isEnabled = false

        et_employeename.setText(app.employeeName)
        et_department.setText(app.department)
        et_salary.setText(app.salary)
        et_joiningdate.setText(app.joiningDate)
        et_performance.setText(app.performance)
        et_password.setText(app.password)
        et_username.setText(app.username)
        et_password.setText(app.password)
        et_username.setText(app.username)
        disable(et_password)
        disable(et_username)

        btnsave.setOnClickListener{
            val employeeName = et_employeename.text.toString()
            val department = et_department.text.toString().trim()
            val salary = et_salary.text.toString()
            val joiningDate = et_joiningdate.text.toString()
            val performance = et_performance.text.toString()

            if(employeeName.isEmpty() || department.isEmpty() || salary.isEmpty() || joiningDate.isEmpty() || performance.isEmpty()){
                Toast.makeText(this, "Please input all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                app.employeeName = employeeName
                app.department = department
                app.salary = salary
                app.joiningDate = joiningDate
                app.performance = performance
                Toast.makeText(this, "Saved Succesfully!", Toast.LENGTH_SHORT).show()
                btnedit.isEnabled = true
                disable(et_department)
                disable(et_employeename)
                disable(et_joiningdate)
                disable(et_performance)
                disable(et_salary)
                btnsave.isEnabled = false


            }
        }
        btnedit.setOnClickListener {
            startActivity(Intent(this, DataEditActivity::class.java))
            finish()
        }
    }
    fun disable(et: EditText){
        et.isClickable = false
        et.isFocusable = false
    }

}