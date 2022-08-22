package com.me.guanpj.module_risk_level.bean

import com.me.guanpj.appbase.ext.splitData

class RiskLevelDetailBean {

    var type: String? = null
    var province: String? = null
    var city: String? = null
    var county: String? = null
    var area_name: String? = null
    var communitys: List<String>? = null
    val communitysString: String
        get() {
            return communitys.splitData()
        }
    var county_code: String? = null

    //数据类型默认是0 为1 即为标题 高风险标题 2是 中风险标题
    var dataType = DataTypeEnum.DATA_IS_RISKLEVEL.ordinal

}