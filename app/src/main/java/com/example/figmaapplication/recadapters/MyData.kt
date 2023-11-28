package com.example.figmaapplication.recadapters

import com.example.figmaapplication.R

data class feel(val image:Int, val name_feel:String)
class MyFeel{val list= arrayListOf(feel(R.drawable.img_feel, name_feel = "Спокойным"),
    feel(R.drawable.relax, name_feel = "Расслабленным"),
    feel(R.drawable.focus, name_feel = "Сосредоточенным"),
    feel(R.drawable.anxious, name_feel = "Взволнованным")) }
