# zOffsetCorrection
A postprocessing workaround for 3D printers with aftermarket bed leveling tools.
## Intro
This program was designed to modify .gcode files to compensate for the z-offset that comes with adding aftermarket bed leveling tools such as the BLTouch or CRTouch.
It works by subtracting the z-offset value you provide towards every z-value in all instructions of the print file. I created this specifically to bypass having to set the Z-offset value on my Ender 3 and Ender 3 V2 printers everytime I power them on to save time.

## How to use
- Download and unzip this repository
- Run the program using the command ```java ./main.java {filename} {zOffset} ```

^ Where {filename} is the path to the .gcode you are trying to modify, and {zOffset} is a number representing the offset you want to subtract (or add).
