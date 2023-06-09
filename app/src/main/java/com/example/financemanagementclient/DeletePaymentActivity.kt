package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityDeletePaymentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeletePaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeletePaymentBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeletePaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deleteButton.setOnClickListener {
            val id = binding.deleteExpense.text.toString()
            if (id.isNotEmpty())
                deleteData(id)
            else
                Toast.makeText(this, "Please enter the Payment ID", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteData(id: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Expense Directory")
        databaseReference.child(id).removeValue().addOnSuccessListener {
            binding.deleteExpense.text.clear()
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Unable to delete", Toast.LENGTH_SHORT).show()
        }
    }
}