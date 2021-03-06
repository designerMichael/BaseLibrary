/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gosuncn.core.common.logger.klog;

import android.util.Log;

import com.gosuncn.core.common.logger.LogUtil;

public class BaseLog {

    public static void printDefault(int type, String tag, String msg) {

        int index = 0;
        int maxLength = 4000;
        int countOfSub = msg.length() / maxLength;

        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, index + maxLength);
                printSub(type, tag, sub);
                index += maxLength;
            }
            printSub(type, tag, msg.substring(index, msg.length()));
        } else {
            printSub(type, tag, msg);
        }
    }

    private static void printSub(int type, String tag, String sub) {
        switch (type) {
            case LogUtil.V:
                Log.v(tag, sub);
                break;
            case LogUtil.D:
                Log.d(tag, sub);
                break;
            case LogUtil.I:
                Log.i(tag, sub);
                break;
            case LogUtil.W:
                Log.w(tag, sub);
                break;
            case LogUtil.E:
                Log.e(tag, sub);
                break;
            case LogUtil.WTF:
                Log.wtf(tag, sub);
                break;
        }
    }

}
