package pl.polsl.tm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import pl.polsl.tm.R

class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        var act = view?.context as? MainActivity
        if (parent.getItemAtPosition(pos).toString() == "Wybierz dzialanie")
            return
        else
            act?.dzialanie(parent.getItemAtPosition(pos).toString())
    }
    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}

class MainActivity : AppCompatActivity() {

    var created: Boolean = false
    private var text_box_a_re: EditText? = null
    private var text_box_a_im: EditText? = null
    private var text_box_b_re: EditText? = null
    private var text_box_b_im: EditText? = null
    private var spinner: Spinner? = null
    private var button_minus: Button? = null
    private var button_plus: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //przyporzadkowanie referencji
        text_box_a_re = findViewById(R.id.editTextARE)
        text_box_a_im = findViewById(R.id.editTextAIM)
        text_box_b_re = findViewById(R.id.editTextBRE)
        text_box_b_im = findViewById(R.id.editTextBIM)
        spinner = findViewById(R.id.spinner)
        button_minus = findViewById(R.id.button_minus)
        button_plus = findViewById(R.id.button_plus)
        //Koniec przyporzadkowania referencji

        //Przyporzadkuj metody przy wybraniu/kliknieciu
        spinner?.onItemSelectedListener = SpinnerActivity()
        button_plus?.setOnClickListener {
            dzialanie( button_plus?.text.toString())
        }
        button_minus?.setOnClickListener{
            dzialanie( button_minus?.text.toString())
        }
    }

    fun dzialanie(dzialanie: String = "+"){
        var textARE = text_box_a_re?.text.toString()
        var textAIM = text_box_a_im?.text.toString()
        var textBRE = text_box_b_re?.text.toString()
        var textBIM = text_box_b_im?.text.toString()
        if (textARE == "") textARE = "0.0"
        if (textAIM == "") textAIM = "0.0"
        if (textBRE == "") textBRE = "0.0"
        if (textBIM== "") textBIM = "0.0"

        var wynikRE: Double
        var wynikIM: Double
        if (dzialanie == "-") {
            wynikRE = textARE.toDouble() - textBRE.toDouble()
            wynikIM = textAIM.toDouble() - textBIM.toDouble()
        }
        else{
            wynikRE = textARE.toDouble() + textBRE.toDouble()
            wynikIM = textAIM.toDouble() + textBIM.toDouble()
        }

        var wynik_tekst = wynikRE.toString()

        if (wynikIM >= 0)
            wynik_tekst += "+"

        wynik_tekst += wynikIM.toString()
        wynik_tekst += "i"
        Toast.makeText(applicationContext, wynik_tekst, Toast.LENGTH_LONG).show()
        //Wyswietl druga aktywnosc z wykresem
        val intent = Intent(this, Graph::class.java).apply{
            putExtra("WYNIKI", arrayOf(wynikRE.toDouble(), wynikIM.toDouble()))
        }
        startActivity(intent)
    }
}