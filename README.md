# clion-avrgcc-toolchain-gui
CLion plugin that imitates a part of Atmel Studio Toolchain GUI. The settings are translated into your project's CMakeLists.txt.

To use the generated file place the following CMake function call BEFORE the 'project()' call, like so:

CMakeLists.txt example

cmake_minimum_required(VERSION 3.10)\n
include(avr-gcc.cmake)\n
project(YourProject)\n
set(CMAKE_CXX_STANDARD 17)\n
add_executable(YourProject main.cpp)\n

07/11/2018 -- What works so far:
- application level (IDE) toolchain/flavour selection/deletion, default flavour can be saved for each toolchain
- project level toolchain and flavour selection
- project level persistence of checkboxes, comboboxes, textfields and textareas
- basic 'avr-gcc.cmake' file generation. If you provide the avr toolchain (I only tested the 8-bit version) CLion will successfully hook up all platform-dependent includes and C standard library from the toolchain. 

For now this plugin can utilize the IDEA code writing/completion/refactoring mechanisms with the avr-gcc toolchain.
Other functionality (compilation/linking/platform-depended flags etc.) is on it's way.
