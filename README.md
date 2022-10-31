# realestate
Assignment for SMG Android position


# Real Estate

- Simple display list of real estates with favorite function

## Table of content
* [Functions](#functions).     
* [Folder structure](#folder-structure).    
* [Technologies](#technologies).    
* [Check list](#check-list).    
* [Run](#run).     
* [Launch](#launch).     
* [Set up](#set-up).  
* [Things can be improved](#things-can-be-improved).    
* [License](#license).     

## Functions:
- Display list of estates received from API
- Estate property include info:
    - Name
    - Price 
    - Location
    - First image display
    - Is Favorite

## Folder structure:
### 1. Main presentation package:  
- Main module contains all things relative to android application (Application, Activity, Fragments, ViewModels...)
- State flow for displaying data state to UI
### 2. Base package:  
- Contains all based component for inheritance, as network result sealed class, base activity, fragments...
### 3. Data module:  
- Constain mapper class to map data from remote/local database response to model that domain module need.
- Constain simple shared preference to cache data into local data base.
- Constain remote service.
- Definition network part such as retrofit, parse exception...
- Repository definition and implementation for detecting data source
### 4. Dependency Injection folder:  
- Constain all dagger hilt module and annotation


## Technologies:
Project is created with:
* Kotlin - v1.4.32
* Coroutine - v1.4.3
* Retrofit - v2.9.0
* Dagger Hilt - v2.38.1
* Glide - v4.12.0

Test part:
* Mockito - v3.9.0
* Turbine flow testing - v0.7.0

## Check list:
1. Programming language: Kotlin is required ✅
2. Design app's architecture (MVVM) ✅
3. Apply LiveData, StateFlow mechanism ✅
4. UI should be looks like in attachment. ✅
5. Write UnitTests ✅
6. Exception handling ✅
7. Caching handling ✅
8. Data transmission via network ✅.  
9. Readme file includes: ✅  
a. Brief explanation for the software development principles, patterns & practices being applied  
b. Brief explanation for the code folder structure and the key Java/Kotlin libraries and frameworks being used  
c. All the required steps in order to get the application run on local computer  
d. Checklist of items the candidate has done.

## Run:
* Android studio Dolphin - 2021.3.1 Patch 1
* Gradle v7.1.3

## Launch:
Min SDK: 24
Target SDK: 32

## Set up:
Install on window os:
* gradlew installDebug

Intall on MAC os
* ./gradlew installDebug

## Things can be improved:
* Display estate detail
* Cache estate response to Room database
* Display multiple screen size with dimens (Apply com.intuit.sdp:sdp-android)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

