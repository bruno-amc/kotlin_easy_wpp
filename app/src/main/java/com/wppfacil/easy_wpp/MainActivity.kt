package com.wppfacil.easy_wpp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.net.Uri
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageEditText: EditText = findViewById(R.id.messageEditText)
        val numberEditText: EditText = findViewById(R.id.numberEditText)
        val generateButton: Button = findViewById(R.id.generateButton)
        val clearButton: Button = findViewById(R.id.botaoLimpar)
        val checkBox: CheckBox = findViewById(R.id.checkBox1)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                generateButton.isEnabled =
                    messageEditText.text.isNotEmpty() && numberEditText.text.isNotEmpty()
            }
        }

        messageEditText.addTextChangedListener(textWatcher)
        numberEditText.addTextChangedListener(textWatcher)

        generateButton.setOnClickListener {
            val message = messageEditText.text.toString()
            val number = numberEditText.text.toString()
            val url = "https://api.whatsapp.com/send?phone=55$number&text=$message"


            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        clearButton.setOnClickListener {
            // Limpa o texto dos dois EditText
            messageEditText.text.clear()
            numberEditText.text.clear()
            // Desmarca o CheckBox
            checkBox.isChecked = false
        }


        val defaultMessageEditText: EditText = findViewById(R.id.defaultMessageEditText)

        // Carregar a mensagem salva
        val sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)
        defaultMessageEditText.setText(sharedPreferences.getString("defaultMessage", ""))
        // Salvar a mensagem sempre que ela for alterada
        defaultMessageEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Não é necessário implementar nada aqui
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Não é necessário implementar nada aqui
            }

            override fun afterTextChanged(s: Editable?) {
                val editor = sharedPreferences.edit()
                editor.putString("defaultMessage", s.toString())
                editor.apply()
            }
        })

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            var textFromTheSavedEditText = defaultMessageEditText.text.toString()
            if(isChecked){
                messageEditText.setText(textFromTheSavedEditText)
            }else {
                // Se o CheckBox estiver desmarcado, limpa o messageEditText
                messageEditText.setText("")
            }

        }

    }
}
