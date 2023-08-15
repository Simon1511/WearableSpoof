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

import android.os.Build;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("WearableSpoof: Started for: " + lpparam.packageName);

        if (lpparam.packageName.startsWith("com.samsung") || lpparam.packageName.startsWith("com.sec")) {
            XposedBridge.log("WearableSpoof: Hooking into: " + lpparam.packageName);

            // ro.product.manufacturer
            if (Build.MANUFACTURER.equals("samsung")) {
                XposedHelpers.setStaticObjectField(Build.class, "MANUFACTURER", "Google");
            }

            // ro.product.brand
            if (Build.BRAND.equals("samsung")) {
                XposedHelpers.setStaticObjectField(Build.class, "BRAND", "google");
            }

            // ro.product.device - always spoof this
            XposedHelpers.setStaticObjectField(Build.class, "DEVICE", "cheetah");

            // ro.build.tags
            if (!Build.TAGS.equals("release-keys")) {
                XposedHelpers.setStaticObjectField(Build.class, "TAGS", "release-keys");
            }

            // ro.build.type
            if (!Build.TYPE.equals("user")) {
                XposedHelpers.setStaticObjectField(Build.class, "TYPE", "user");
            }

            // ro.product.name - always spoof this
            XposedHelpers.setStaticObjectField(Build.class, "PRODUCT", "cheetah");

            // ro.product.model
            if (Build.MODEL.startsWith("SM-")) {
                XposedHelpers.setStaticObjectField(Build.class, "MODEL", "Pixel 7 Pro");
            }

            // ro.build.fingerprint
            if (Build.FINGERPRINT.contains("samsung")) {
                XposedHelpers.setStaticObjectField(Build.class, "FINGERPRINT",
                        "google/cheetah/cheetah:13/TQ2A.230505.002/9891397:user/release-keys");
            }
        } else {
            XposedBridge.log("WearableSpoof: Not a Samsung app");
        }
    }
}