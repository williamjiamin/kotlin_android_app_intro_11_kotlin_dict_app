package com.lexueoude.lexueoudedict

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private val KEY = "WORD_DEFINITION"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val queue = Volley.newRequestQueue(this)

        search_button.setOnClickListener {
            val url = getUrl()
            val stringRequest = StringRequest(Request.Method.GET, url,
                { response ->
//                    extractDefinitionFromJson(response)
//                    response
                    try {
                        extractDefinitionFromJson(response)
                    }catch (exception : Exception){
                        exception.printStackTrace()
                    }
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                }

            )

            queue.add(stringRequest)
        }


    }

    private fun getUrl(): String {
        val word = word_edit_text.text
        val apiKey = "19f6bfa6-24d7-4ce0-9138-991eda966f77"

        val url =
            "https://www.dictionaryapi.com/api/v3/references/learners/json/$word?key=$apiKey"

        return url

    }

    private fun extractDefinitionFromJson(response: String) {
        val jsonArray = JSONArray(response)
        val firstIndex = jsonArray.getJSONObject(0)
        val getOurShortDef = firstIndex.getJSONArray("shortdef")
        val ourFirstShortDef = getOurShortDef.get(0)


        val intent = Intent(this, WordDefinitionActivity::class.java)
        intent.putExtra(KEY, ourFirstShortDef.toString())
        startActivity(intent)

    }


}