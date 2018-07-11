# cmake_minimum_required(VERSION <specify CMake version here>)
cmake_minimum_required(VERSION 3.10)
include(avr-gcc.cmake)
project(CLionTestProject)

set(CMAKE_CXX_STANDARD 11)

add_executable(CLionTestProject main.cpp)