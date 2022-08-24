package com.me.guanpj.module_travel_policy.bean

enum class RiskLevelEnum(var riskLevel: String, var riskLevelDesc: String) {
    ENUM_0("0", "未知"),
    ENUM_1("1", "低风险"),
    ENUM_2("2", "中风险"),
    ENUM_3("3", "高风险"),
    ENUM_4("4", "部分地区中风险"),
    ENUM_5("5", "部分地区高风险"),
    ENUM_6("6", "部分地区中高风险");

    companion object {
        fun getRiskLevelDesc(riskLevel: String): String {
            for (c in values()) {
                if (c.riskLevel == riskLevel) {
                    return c.riskLevelDesc
                }
            }
            return ""
        }
    }

}