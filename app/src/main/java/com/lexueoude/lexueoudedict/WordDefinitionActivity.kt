package com.lexueoude.lexueoudedict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_word_definition.*

class WordDefinitionActivity : AppCompatActivity() {
    private val KEY = "WORD_DEFINITION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_definition)

        val comb = "偶得智能搜索结果：" + intent.getStringExtra(KEY) + "更多内容：关注公众号【乐学偶得】，官网：lexueoude.com"

        definition_text_view.text = comb
        back_image_view.setOnClickListener { finish() }
    }
}


//API(Application Programming Interface)

//Phone  -----word------>       Service Provider(API)
//Phone  <--definition--       Service Provider(API)


//JSON

//{} Object
//Key:Value
//[] Array