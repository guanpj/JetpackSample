/*
 *
 *  * Copyright (C)  HuangLinqing, TravelPrevention Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.me.guanpj.module_travel_policy.bean

class PolicyDetailReqBean {
    var province_id: String? = null
    var city_id: String? = null
    var city_name: String? = null
    var health_code_desc: String? = null
    var health_code_gid: String? = null
    var health_code_name: String? = null
    var health_code_picture: String? = null
    var health_code_style: String? = null
    var high_in_desc: String? = null
    var low_in_desc: String? = null
    var out_desc: String? = null
    var province_name: String? = null
    var risk_level: String? = null
    val isLowRisk: Boolean

    get() {
            risk_level?.let {
                if (it == "0" || it == "1") {
                    return true
                }
            }
            return false
        }
    val riskLevelDesc: String
        get() {
            risk_level?.let {
                return RiskLevelEnum.getRiskLevelDesc(it)
            }
            return "未知"
        }
}