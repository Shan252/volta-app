package com.example.financemanagementclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.financemanagementclient.databinding.ActivityPaymentBinding

class paymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.expenseInsert.setOnClickListener{
            val intent = Intent(this@paymentActivity, InsertPaymentActivity::class.java)
            startActivity(intent)
//            finish()
        }

        binding.expenseView.setOnClickListener{
            val intent = Intent(this@paymentActivity, ViewPaymentActivity::class.java)
            startActivity(intent)
        }

        binding.expenseUpdate.setOnClickListener{
            val intent = Intent(this@paymentActivity, UpdatePaymentActivity::class.java)
            startActivity(intent)
        }

        binding.expenseDelete.setOnClickListener(View.OnClickListener{
            val intent = Intent(this@paymentActivity, DeletePaymentActivity::class.java)
            startActivity(intent)
        })

    }

}