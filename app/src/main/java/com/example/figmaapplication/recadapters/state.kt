package com.example.figmaapplication.recadapters
import com.example.figmaapplication.R

data class states(val title:String, val text_state:String,val image_state:Int)

class MyState1
{
    val states_list = arrayListOf(state("Заголовок блока", "Краткое описание", R.drawable.img_block),
        state("Заголовок блока", "Краткое описание",R.drawable.img_block),
    )
}
