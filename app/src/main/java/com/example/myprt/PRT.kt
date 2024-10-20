package com.example.myprt

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PRT(
    val name: String,
    val description: String,
    val photo: Int,
    val resume: String
):Parcelable{
    val location: String
        get() = description.split(", ")[0]

    val age: String
        get() = description.split(", ")[1]

    val rating: String
        get() = description.split(", ")[2]
}

