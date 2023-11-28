package com.example.figmaapplication.recadapters

import com.example.figmaapplication.R

data class state(val title:String, val text_state:String, val image_state: Int)
class MyState
{
    val state_list = arrayListOf(state("Заголовок статьи", "Краткое описание", R.drawable.img_block))
}
