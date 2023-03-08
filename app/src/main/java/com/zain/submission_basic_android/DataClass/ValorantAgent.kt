package com.zain.submission_basic_android.DataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ValorantAgent(
    var photo_Agent:Int = 0,
    var name : String = "",
    var jenisAgent : String = "",
    var desc : String = "",
    var skillOne: String = "",
    var skillTwo: String = "",
    var skillThree: String= "",
    var ult : String = "",
    var photoSkillOne: Int= 0,
    var photoSkillTwo : Int = 0,
    var photoSkillThree: Int = 0,
    var photoUlt: Int = 0,
    var urlAgentInfo : String = ""


): Parcelable
