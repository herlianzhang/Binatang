package com.latihangoding.binatang.Model

import java.io.Serializable

data class BinatangModel(
    var name: String = "",
    var photo: IntArray = intArrayOf(),
    var detail: String = ""
) : Serializable