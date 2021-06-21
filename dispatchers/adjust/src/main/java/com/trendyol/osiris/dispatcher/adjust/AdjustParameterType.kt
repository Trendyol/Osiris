package com.trendyol.osiris.dispatcher.adjust

import com.trendyol.osiris.dispatcher.adjust.data.AdjustParameter
import com.trendyol.osiris.dispatcher.adjust.data.AdjustParametrizedData

/**
 * The method provides [AdjustParametrizedData] data with [AdjustParameter.Callback] type
 *
 * Callback is the parameter type which is commonly in use, so this method is implemented to make easy tracking
 *
 * @param key identifier for AdjustParametrizedData
 * @param data value for Callback parameter type
 *
 * @return [AdjustParametrizedData] with Callback type
 */
fun adjustParametrizedData(key: String, data: Any): AdjustParametrizedData {
    return AdjustParametrizedData(key, AdjustParameter.Callback(data.toString()))
}

/**
 * The method provides [AdjustParametrizedData] with given [AdjustParameter.Callback]
 *
 * @param key identifier for AdjustParametrizedData
 * @param adjustParameter parameter for AdjustParametrizedData
 *
 * @return [AdjustParametrizedData] with given parameter type
 */
fun adjustParametrizedData(key: String, adjustParameter: AdjustParameter): AdjustParametrizedData {
    return AdjustParametrizedData(key, adjustParameter)
}
