package com.me.guanpj.module_city.bean

import com.me.guanpj.appbase.util.Cn2SpellUtil
import java.util.*

class CityDataBean {
    private val provinceId: String? = null
    private val province: String? = null
    val citys: List<CityBean>? = null

    class CityBean : Comparable<CityBean> {
        var cityNamePinyin: String? = null
            get() {
                field = city?.let {
                    return Cn2SpellUtil.getPinYin(it)
                }
                return ""
            }
        var firstLetter: String? = null
            get() {
                val letter = Regex("[a-zA-Z]")
                city?.let {
                    field = Cn2SpellUtil.getPinYinFirstLetter(it)?.uppercase(Locale.getDefault())
                    if (!field?.matches(letter)!!) {
                        field = "#"
                    }
                    return field
                }
                return "#"
            }

        val city_id: String? = null
        val city: String? = null
        override fun compareTo(other: CityBean): Int {
            return if (firstLetter.equals("#") && !other.firstLetter.equals("#")) {
                1
            } else if (!firstLetter.equals("#") && other.firstLetter.equals("#")) {
                -1
            } else {
                if (cityNamePinyin != null && other.cityNamePinyin != null) {
                    cityNamePinyin!!.compareTo(other.cityNamePinyin!!, false)
                } else {
                    1
                }

            }
        }
    }
}