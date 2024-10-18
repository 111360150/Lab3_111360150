package com.example.a111360150_lab2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var editTextText2: EditText
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView
    private lateinit var radioButton: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextText2 = findViewById<EditText>(R.id.editTextText2);

        textView3 = findViewById<TextView>(R.id.textView3);
        textView4 = findViewById<TextView>(R.id.textView4);
        textView5 = findViewById<TextView>(R.id.textView5);
        textView6 = findViewById<TextView>(R.id.textView6);
        textView7 = findViewById<TextView>(R.id.textView7);

        radioButton = findViewById<RadioButton>(R.id.radioButton);
        radioButton2 = findViewById<RadioButton>(R.id.radioButton2);
        radioButton3 = findViewById<RadioButton>(R.id.radioButton3);

        button2 = findViewById<Button>(R.id.button2);

        button2.setOnClickListener(View.OnClickListener {
            if (editTextText2.length() < 1) {
                textView3.setText("請輸入玩家姓名")
            } else {
                textView4.setText(String.format("名字\n%s", editTextText2.getText().toString()))

                if (radioButton.isChecked()) {
                    textView6.setText("我方出拳\n剪刀")
                } else if (radioButton2.isChecked()) {
                    textView6.setText("我方出拳\n石頭")
                } else {
                    textView6.setText("我方出拳\n布")
                }
                val computer_random = (Math.random() * 3).toInt()
                if (computer_random == 0) {
                    textView7.setText("電腦出拳\n剪刀")
                } else if (computer_random == 1) {
                    textView7.setText("電腦出拳\n石頭")
                } else {
                    textView7.setText("電腦出拳\n布")
                }

                if ((radioButton.isChecked() && computer_random == 2) ||
                    (radioButton2.isChecked() && computer_random == 0) ||
                    (radioButton3.isChecked() && computer_random == 1)
                ) {
                    textView5.setText(
                        """
                            勝利者
                            ${editTextText2.getText()}
                            """.trimIndent()
                    )
                    textView3.setText("恭喜您獲勝了！！！")
                } else if ((radioButton.isChecked() && computer_random == 1) ||
                    (radioButton2.isChecked() && computer_random == 2) ||
                    (radioButton3.isChecked() && computer_random == 0)
                ) {
                    textView5.setText("勝利者\n電腦")
                    textView3.setText("可惜，電腦獲勝了！")
                } else {
                    textView5.setText("勝利者\n平手")
                    textView3.setText("平局，請再試一次！")
                }
            }
        })
    }
}