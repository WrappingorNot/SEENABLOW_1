package com.example.seenablow

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class DataAdapter(var context: Context, var layout: Int, var data: List<DataVO>) : BaseAdapter() {
    var inflater //xml파일을 view객체로 변환하는 역활
            : LayoutInflater
    var intent: Intent? = null
    var isclick = false

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(i: Int): Any {
        return data[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View, viewGroup: ViewGroup): View {
        var view = view
        if (view == null) {
            view = inflater.inflate(layout, null)
        }
        val title = view.findViewById<TextView>(R.id.lock_word)
        val contect = view.findViewById<TextView>(R.id.acc_mean)
        val textView2 = view.findViewById<TextView>(R.id.tv_quizNum)
        val textView3 = view.findViewById<TextView>(R.id.mean)
        val btn = view.findViewById<Button>(R.id.btn_start)
        title.text = data[i].title
        textView2.text = data[i].word
        textView3.text = data[i].mean
        contect.text = data[i].content


        // 글자 가운데 정렬
        contect.textAlignment = View.TEXT_ALIGNMENT_CENTER
        btn.setOnClickListener {
            var find: String? =
                "https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=1&acr=1&acq=skaldi&qdt=0&ie=utf8&query="
            find += title.text
            val uri = Uri.parse(find)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
        val card_flip = view.findViewById<CardView>(R.id.card_flip)
        val btn_quiz = view.findViewById<Button>(R.id.btn_back)
        isclick = false
        card_flip.setOnClickListener {
            if (isclick == false) {
                btn.visibility = View.VISIBLE
                btn_quiz.visibility = View.VISIBLE
                contect.visibility = View.VISIBLE
                textView2.visibility = View.VISIBLE
                textView3.visibility = View.VISIBLE
                isclick = true
            } else {
                btn.visibility = View.GONE
                btn_quiz.visibility = View.GONE
                contect.visibility = View.GONE
                textView2.visibility = View.GONE
                textView3.visibility = View.GONE
                isclick = false
            }
        }
//        btn_quiz.setOnClickListener {
//            val intent = Intent(context, QuizActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            intent.putExtra("단어", data[i].word)
//            intent.putExtra("뜻", data[i].mean)
//            if (i == 9) {
//                intent.putExtra("틀린답1", data[i - 2].word)
//                intent.putExtra("틀린답2", data[i - 1].word)
//            } else if (i == 0) {
//                intent.putExtra("틀린답1", data[i + 2].word)
//                intent.putExtra("틀린답2", data[i + 1].word)
//            } else {
//                intent.putExtra("틀린답1", data[i - 2].word)
//                intent.putExtra("틀린답2", data[i + 2].word)
//            }
//            context.startActivity(intent)
       // }
        return view
    }
}