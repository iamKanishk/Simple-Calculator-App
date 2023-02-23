package com.example.calculator
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var button0: Button
    lateinit var buttonbuallclear: Button
    lateinit var buttonclear: Button
    lateinit var buttonminus: Button
    lateinit var buttonplus: Button
    lateinit var buttonmultiply: Button
    lateinit var buttondivide: Button
    lateinit var buttonpercent: Button
    lateinit var buttonequals: Button
    lateinit var buttondot: Button
    lateinit var buttonback: Button
    lateinit var solutionview: TextView
    lateinit var resultview: TextView
    var check = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonplus = findViewById(R.id.buttonplus);
        buttonminus = findViewById(R.id.buttonminus);
        buttonmultiply = findViewById(R.id.buttonmultiply);
        buttondivide = findViewById(R.id.buttondivide);
        buttonpercent = findViewById(R.id.buttonpercent);
        buttondot = findViewById(R.id.buttondot);
        buttonclear = findViewById(R.id.buttonclear);
        buttonback = findViewById(R.id.buttonback);
        buttonequals = findViewById(R.id.buttonequals);
        solutionview = findViewById(R.id.solutionview);
        resultview = findViewById(R.id.resultview);
        solutionview.movementMethod = ScrollingMovementMethod()
        solutionview.setActivated(true)
        solutionview.setPressed(true)
        var text: String


        button0.setOnClickListener {
            text = solutionview.text.toString() + "0"
            solutionview.setText(text)
            result(text)
        }
        button1.setOnClickListener {
            text = solutionview.text.toString() + "1"
            solutionview.setText(text)
            result(text)
        }
        button2.setOnClickListener {
            text = solutionview.text.toString() + "2"
            solutionview.setText(text)
            result(text)
        }
        button3.setOnClickListener {
            text = solutionview.text.toString() + "3"
            solutionview.setText(text)
            result(text)
        }
        button4.setOnClickListener {
            text = solutionview.text.toString() + "4"
            solutionview.setText(text)
            result(text)
        }
        button5.setOnClickListener {
            text = solutionview.text.toString() + "5"
            solutionview.setText(text)
            result(text)
        }
        button6.setOnClickListener {
            text = solutionview.text.toString() + "6"
            solutionview.setText(text)
            result(text)
        }
        button7.setOnClickListener {
            text = solutionview.text.toString() + "7"
            solutionview.setText(text)
            result(text)
        }
        button8.setOnClickListener {
            text = solutionview.text.toString() + "8"
            solutionview.setText(text)
            result(text)
        }
        button9.setOnClickListener {
            text = solutionview.text.toString() + "9"
            solutionview.setText(text)
            result(text)
        }
        buttondot.setOnClickListener {
            text = solutionview.text.toString() + "."
            solutionview.setText(text)
            result(text)
        }

        buttonplus.setOnClickListener {
            text = solutionview.text.toString() + "+"
            solutionview.setText(text)
            check=check+1
        }
        buttonminus.setOnClickListener {
            text = solutionview.text.toString() + "-"
            solutionview.setText(text)
            check=check+1
        }
        buttonmultiply.setOnClickListener {
            text = solutionview.text.toString() + "*"
            solutionview.setText(text)
            check=check+1
        }
        buttondivide.setOnClickListener {
            text = solutionview.text.toString() + "/"
            solutionview.setText(text)
            check=check+1
        }
        buttonpercent.setOnClickListener {
            text = solutionview.text.toString() + "%"
            solutionview.setText(text)
            check=check+1
        }

        buttonequals.setOnClickListener {
            text = resultview.text.toString()
            solutionview.setText(text)
            resultview.setText(null)
        }
        buttonclear.setOnClickListener {
            solutionview.setText(null)
            resultview.setText(null)

        }
        buttonback.setOnClickListener {
            var backspace: String? = null
            if (solutionview.text.length>0)
            {
                val stringBuilder: StringBuilder = StringBuilder(solutionview.text)
                val find=solutionview.text.toString()
                val find2=find.last()

                if (find2.equals('+') || find2.equals('-') || find2.equals('*') || find2.equals('/') || find2.equals('%'))
                {
                    check=check-1

                }

                stringBuilder.deleteCharAt(solutionview.text.length-1)
                backspace = stringBuilder.toString()
                solutionview.setText(backspace)



            }


        }


    }

    private fun result(text: String) {


        val engine: ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any=engine.eval(text)
            val mainr=result.toString()
            if (check==0) {

                resultview.setText(null)

            } else {
                resultview.setText(mainr)
            }
        } catch (e: ScriptException) {
            Log.d("TAG", "ERROR")
        }


    }


        }





