# WearableSpoof

## What is WearableSpoof?
WearableSpoof is a module for LSPosed that lets you use Samsung apps (for example Wearable/Gear, SmartThings, ...) on Samsung phones running AOSP ROMs.
Usually, when trying to install Samsung apps on a Samsung phone running an AOSP ROM (for example LineageOS), you would
be greeted by an error message saying that you're not allowed to run this app on a modified phone or simply a force closing app.
This module bypasses their checks by spoofing all device-specific properties to ones from the Pixel 7 Pro and lets you run these apps anyway.

## IMPORTANT
This module won't magically let you run all Samsung apps on your phone (for example Samsung Camera). ONLY ones that can normally be installed on
non-Samsung phones too should and will most likely work without issues.

## How to install
### Prerequisites
- Any Samsung phone running an AOSP ROM
- A ROM that won't let you use your preferred Samsung app by default (such as LineageOS)
- Gapps (Google apps) *should* be installed

### Installation
- Install [Magisk](https://github.com/topjohnwu/Magisk/releases) on your phone by flashing the Magisk APK in recovery mode.
- Once installed, go into Magisk's Settings and enable "Zygisk" and reboot afterwards.
    - IMPORTANT: DO NOT add your preferred Samsung app to Magisk's denyList as that will break the module.
- After rebooting, open Magisk and install the [LSPosed Module](https://github.com/LSPosed/LSPosed/releases).
    - Make sure to download the Zygisk version of the module.
    - Reboot after the installation finishes.
- After rebooting, if everything went right you should now see a new notification in the notification panel saying "LSPosed loaded".
    - Tap that notification to open the Manager.
    - You should now see "Activated" at the top of the Manager if everything worked fine.
- Now download the latest APK of WearableSpoof from the [releases section](https://github.com/Simon1511/WearableSpoof/releases) and install it like any normal APK.
- Open the Play Store and download all your preferred Samsung apps.
- Now open the LSPosed Manager again and go to "Modules".
- WearableSpoof should now appear in that list.
- Click on WearableSpoof and enable the module by flipping the switch at the top that says "Enable module".
- Next, tick all the Samsung apps that you just installed (for example, "Galaxy Wearable" and "Galaxy Watch 4 Manager") and reboot your phone afterwards.
- Once rebooted, you should be able to successfully open your apps.

## FAQ and issues
### The wearable app asks me to download the plugin from the Play Store
After the installation finishes, open the LSPosed Manager and add the app to the WearableSpoof module. Reboot afterwards. You might need to clear cache and data of the plugin app too.

### I get "Connection error" during setup
Go into your phone's Settings -> Apps -> All Apps -> Enable "show system apps" -> Search for "Play Services" -> Permissions -> Allow permissions for "Nearby devices".

### The plugin app on the Play Store says "Not supported on this device"
Make sure you are passing Safetynet and that your Play Store shows "Device certified" in Settings.