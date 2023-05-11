/*
 * WearableSpoof
 * Copyright (C) 2023 Simon1511
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.simon1511.wearablespoof;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("WearableSpoof: we're behind the scenes!! package name: " + lpparam.packageName);

        if (lpparam.packageName.equals("com.samsung.android.app.watchmanager")) {
            XposedBridge.log("WearableSpoof: Hooking into Watchmanager");
            XposedHelpers.findAndHookMethod(
                    "com.samsung.android.app.twatchmanager.util.HostManagerUtils",
                    lpparam.classLoader,
                    "isSamsungDevice", XC_MethodReplacement.returnConstant(Boolean.FALSE));

            XposedHelpers.findAndHookMethod(
                    "com.samsung.android.app.twatchmanager.util.HostManagerUtils",
                    lpparam.classLoader,
                    "isSamsungDeviceWithCustomBinary", XC_MethodReplacement.returnConstant(Boolean.FALSE));
        }
    }
}