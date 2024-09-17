# zOffsetCorrection

## Intro
This program was designed to modify .gcode files to compensate for the z-offset that comes with adding aftermarket bed leveling tools like the BLTouch.
It works by subtracting the z-offset value you provide towards every z-value in all instructions of the print file.

## How to use
- Download and unzip this repository
- Run the program using ```./main.java {filename} {zOffset} ```

^ Where {filename} is the path to the .gcode you are trying to modify, and {zOffset} is a number representing the offset you want to subtract (or add).
